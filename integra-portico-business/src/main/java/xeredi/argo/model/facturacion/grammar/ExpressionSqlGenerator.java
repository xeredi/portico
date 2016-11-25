package xeredi.argo.model.facturacion.grammar;

import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.argo.model.facturacion.grammar.ExpressionParser.ConditionContext;
import xeredi.argo.model.facturacion.grammar.ExpressionParser.DecodeBranchContext;
import xeredi.argo.model.facturacion.grammar.ExpressionParser.FormulaContext;
import xeredi.argo.model.facturacion.grammar.ExpressionParser.PropertyContext;
import xeredi.argo.model.facturacion.grammar.ExpressionParser.PropertyElementContext;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpressionSqlGenerator.
 */
public final class ExpressionSqlGenerator extends ExpressionBaseVisitor {

    /** The enti detalle base. */
    final transient AbstractEntidadDetailVO entiDetailBase;

    /** The path type. */
    final transient PathType pathType;

    /**
     * Instantiates a new expression sql generator.
     *
     * @param entiId
     *            the enti id
     * @param apathType
     *            the apath type
     */
    public ExpressionSqlGenerator(final Long entiId, final PathType apathType) {
        super();
        entiDetailBase = EntidadProxy.select(entiId);
        pathType = apathType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitCondition(final ConditionContext ctx) {
        if (ctx.lp != null) {
            return ctx.lp.getText() + visitCondition(ctx.c1) + ctx.rp.getText();
        }

        if (ctx.unaryOP != null) {
            return ctx.unaryOP.getText() + ' ' + visitCondition(ctx.c1);
        }

        if (ctx.binaryOP != null) {
            return visitCondition(ctx.c1) + ' ' + ctx.binaryOP.getText() + ' ' + visitCondition(ctx.c2);
        }

        if (ctx.relationalOP != null) {
            return visitFormula(ctx.f1) + ' ' + ctx.relationalOP.getText() + ' ' + (ctx.allAnyOp == null
                    ? visitFormula(ctx.f2) : ctx.allAnyOp.getText() + ' ' + ctx.cteList.getText());
        }

        if (ctx.nullOp != null) {
            return visitFormula(ctx.f1) + ' ' + ctx.nullOp.getText();
        }

        if (ctx.inOp != null) {
            return visitFormula(ctx.f1) + ' ' + ctx.inOp.getText() + ' ' + ctx.cteList.getText();
        }

        if (ctx.betweenOp != null) {
            return visitFormula(ctx.f1) + ' ' + ctx.betweenOp.getText() + ' ' + visitFormula(ctx.f2) + " AND "
                    + visitFormula(ctx.f3);
        }

        throw new Error("Condicion no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitFormula(final FormulaContext ctx) {
        if (ctx.cte != null) {
            return ctx.cte.getText();
        }

        if (ctx.prop != null) {
            return visitProperty(ctx.prop);
        }

        if (ctx.lp != null) {
            return ctx.lp.getText() + visitFormula(ctx.f1) + ctx.rp.getText();
        }

        if (ctx.unaryOP != null) {
            return ctx.unaryOP.getText() + ' ' + visitFormula(ctx.f1);
        }

        if (ctx.binaryOP != null) {
            return visitFormula(ctx.f1) + ' ' + ctx.binaryOP.getText() + ' ' + visitFormula(ctx.f2);
        }

        if (ctx.fn != null) {
            final FunctionName functionName = FunctionName.valueOf(ctx.fn.getText());

            switch (functionName) {
            case COALESCE:
                return " COALESCE(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ")";
            case ROUND:
                return " ROUND(" + visitFormula(ctx.f1) + ", " + ctx.NUMBER_CONSTANT().getText() + ")";
            case CONCAT:
                return " CONCAT(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ")";
            case GREATEST:
                return " GREATEST(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ")";
            case LEAST:
                return " LEAST(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ")";
            case DECODE:
                String sqlCase = " CASE " + visitFormula(ctx.f1);

                for (final ParseTree tree : ctx.children) {
                    if (tree instanceof DecodeBranchContext) {
                        final DecodeBranchContext decodeBranchContext = (DecodeBranchContext) tree;

                        sqlCase += " WHEN " + visitFormula(decodeBranchContext.f1) + " THEN "
                                + visitFormula(decodeBranchContext.f2);
                    }
                }

                if (ctx.f2 != null) {
                    sqlCase += " ELSE " + visitFormula(ctx.f2);
                }

                sqlCase += " END";

                return sqlCase;
            case acumuladoTeus:
                return " portico.acumuladoTeus(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ", "
                        + visitFormula(ctx.f3) + ")";
            case valorServicio:
                return " portico.valorServicio(" + visitFormula(ctx.f1) + ", " + visitFormula(ctx.f2) + ", "
                        + visitFormula(ctx.f3) + ")";
            case periodosFacturablesAtraque:
                return " portico.periodosFacturablesAtraque(" + visitFormula(ctx.f1) + ")";
            case esPrimerAtraque:
                return " portico.esPrimerAtraque(" + visitFormula(ctx.f1) + ")";
            case fechaUltimaTR:
                return " portico.fechaUltimaTR(" + visitFormula(ctx.f1) + ")";
            case unidadesGtsEscala:
                return " portico.unidadesGtsEscala(" + visitFormula(ctx.f1) + ")";
            case unidadesGtsAtraque:
                return " portico.unidadesGtsAtraque(" + visitFormula(ctx.f1) + ")";
            case generaBOEscala:
                return " portico.generaBOEscala(" + visitFormula(ctx.f1) + ")";
            case esAvituallamientoEscala:
                return " portico.esAvituallamientoEscala(" + visitFormula(ctx.f1) + ")";
            case esBaseEnPuertoEscala:
                return " portico.esBaseEnPuertoEscala(" + visitFormula(ctx.f1) + ")";
            default:
                throw new Error("Funcion '" + functionName.name() + "' no implementada!");
            }
        }

        throw new Error("Formula no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitProperty(final PropertyContext ctx) {
        String sqlPath = "";

        AbstractEntidadDetailVO entiDetailElem = entiDetailBase;

        boolean isFirst = true;
        boolean isLast = false;

        final Iterator<ParseTree> parseTreeIterator = ctx.children.iterator();

        while (parseTreeIterator.hasNext()) {
            final ParseTree parseTree = parseTreeIterator.next();

            if (!parseTreeIterator.hasNext()) {
                isLast = true;
            }

            if (parseTree instanceof PropertyElementContext) {
                final PropertyElementContext pathElementCtx = (PropertyElementContext) parseTree.getPayload();
                String sqlElement = "";

                if (pathElementCtx.service != null) {
                    if (entiDetailElem.getEnti().getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al servicio desde un subservicio");
                    }

                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy
                            .select(entiDetailElem.getEnti().getId());

                    entiDetailElem = EntidadProxy.select(tpssDetail.getEnti().getTpsrId());

                    sqlElement += "SELECT " + (isLast && pathType == PathType.LABEL
                            ? "CONCAT(CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), CONCAT(srvc_anio, CONCAT('/', srvc_numero)))"
                            : "srvc_pk") + " FROM tbl_servicio_srvc WHERE srvc_pk = ";
                    sqlElement += isFirst ? "item.ssrv_srvc_pk" : "#{any}";
                }
                if (pathElementCtx.parent != null) {
                    if (entiDetailElem.getEnti().getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar a la entidad padre desde un subservicio");
                    }

                    entiDetailElem = EntidadProxy.select(Entidad.valueOf(pathElementCtx.ID().getText()).getId());

                    sqlElement += "SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = portico.getEntidad('"
                            + pathElementCtx.ID().getText() + "')) AND ssss_ssrvh_pk = ";
                    sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";
                }

                if (pathElementCtx.attribute != null) {
                    final Attribute attribute = Attribute.valueOf(pathElementCtx.arg.getText());

                    switch (entiDetailElem.getEnti().getTipo()) {
                    case P:
                        sqlElement += " SELECT prmt_" + attribute.name()
                                + " FROM tbl_parametro_prmt WHERE prmt_pk = (#{any})";
                        break;
                    case T:
                        sqlElement += " SELECT srvc_" + attribute.name() + " FROM tbl_servicio_srvc WHERE srvc_pk = ";

                        sqlElement += isFirst ? entiDetailBase.getEnti().getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk" : "(#{any})";

                        break;
                    case S:
                        sqlElement += " SELECT ssrv_" + attribute.name()
                                + " FROM tbl_subservicio_ssrv WHERE ssrv_pk = ";

                        sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";

                        break;
                    default:
                        throw new Error("Tipo de entidad no soportado: " + entiDetailElem.getEnti().getTipo());
                    }
                }
                if (pathElementCtx.data != null) {
                    final TipoDato tipoDato = TipoDato.valueOf(pathElementCtx.ID().getText());

                    Preconditions.checkNotNull(entiDetailElem);

                    EntidadTipoDatoVO entd = null;

                    for (final Long tpdtId : entiDetailElem.getEntdList()) {
                        final EntidadTipoDatoVO vo = entiDetailElem.getEntdMap().get(tpdtId);

                        if (vo.getTpdt().getId() == tipoDato.getId()) {
                            entd = vo;
                        }
                    }

                    if (entd == null) {
                        throw new Error("Dato no encontrado: " + tipoDato);
                    }

                    Preconditions.checkNotNull(entd);

                    String fieldPrefix = null;

                    switch (entiDetailElem.getEnti().getTipo()) {
                    case T:
                        fieldPrefix = "srdt_";

                        break;
                    case S:
                        fieldPrefix = "ssdt_";

                        break;
                    case P:
                        fieldPrefix = "prdt_";

                        break;
                    default:
                        throw new Error("Entidad '" + entiDetailElem.getEnti().getTipo() + "' no valida");
                    }

                    sqlElement += "SELECT ";

                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                    case NE:
                        sqlElement += fieldPrefix + "nentero";

                        break;
                    case ND:
                        sqlElement += fieldPrefix + "ndecimal";

                        break;
                    case FE:
                    case FH:
                        sqlElement += fieldPrefix + "fecha";

                        break;
                    case TX:
                        sqlElement += fieldPrefix + "cadena";

                        break;
                    case CR:
                        sqlElement += isLast && pathType == PathType.LABEL
                                ? "(SELECT CONCAT(cdrf_valor, CONCAT(' - ', i18n_text))"
                                        + " FROM tbl_codigo_ref_cdrf INNER JOIN tbl_i18n_i18n ON i18n_ext_pk = cdrf_pk"
                                        + " WHERE i18n_pref = 'cdrf' AND i18n_lang = 'es' AND cdrf_tpdt_pk = "
                                        + entd.getTpdt().getId() + " AND cdrf_valor = " + fieldPrefix + "cadena)"
                                : fieldPrefix + "cadena";

                        break;
                    case PR:
                        if (isLast) {
                            switch (pathType) {
                            case ID:
                                sqlElement += fieldPrefix + "prmt_pk";

                                break;
                            case CODE:
                                sqlElement += "(SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = "
                                        + fieldPrefix + "prmt_pk)";

                                break;
                            case LABEL:
                                sqlElement += "(SELECT CONCAT(" + "         CONCAT(prmt_parametro, ' - ')"
                                        + "         , COALESCE ("
                                        + "             (SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_ext_pk = prvr_pk AND i18n_pref = 'prvr' AND i18n_lang = 'es')"
                                        + "             , (SELECT prdt_cadena FROM tbl_parametro_dato_prdt WHERE prdt_prvr_pk = prvr_pk AND prdt_tpdt_pk = ("
                                        + "                 SELECT tppr_tpdt_pk FROM tbl_tipo_parametro_tppr WHERE tppr_pk = prmt_tppr_pk)))) AS prmt_etiqueta"
                                        + " FROM tbl_parametro_prmt INNER JOIN tbl_parametro_version_prvr ON prvr_prmt_pk = prmt_pk"
                                        + " WHERE fref BETWEEN prvr_fini AND COALESCE (prvr_ffin, fref)"
                                        + "     AND prmt_pk = " + fieldPrefix + "prmt_pk)";

                                // "(SELECT CONCAT(CONCAT(prmt_parametro , ' - '), COALESCE("
                                // +
                                // "(SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref='prvr' AND i18n_lang
                                // = 'es' AND i18n_ext_pk = ("
                                // +
                                // "SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk =
                                // prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref))), 'NO
                                // i18n!!!'))"
                                // + " FROM tbl_parametro_prmt WHERE prmt_pk = " + fieldPrefix + "prmt_pk)";

                                break;

                            default:
                                throw new Error("Invalid pathType: " + pathType.name());
                            }
                        } else {
                            sqlElement += fieldPrefix + "prmt_pk";
                        }

                        break;
                    case SR:
                        sqlElement += isLast && pathType == PathType.LABEL
                                ? "(SELECT CONCAT(CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), CONCAT(srvc_anio, CONCAT('/', srvc_numero))) FROM tbl_servicio_srvc WHERE srvc_pk = "
                                        + fieldPrefix + "srvc_dep_pk)"
                                : fieldPrefix + "srvc_dep_pk";

                        break;
                    default:
                        throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                    }

                    switch (entiDetailElem.getEnti().getTipo()) {
                    case T:
                        sqlElement += " FROM tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = portico.getTipoDato('"
                                + pathElementCtx.ID().getText() + "') AND srdt_srvc_pk = ";
                        sqlElement += isFirst ? entiDetailBase.getEnti().getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk" : "(#{any})";

                        break;
                    case S:
                        sqlElement += " FROM tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = portico.getTipoDato('"
                                + pathElementCtx.ID().getText() + "') AND ssdt_ssrv_pk = ";
                        sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";

                        break;
                    case P:
                        sqlElement += " FROM tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = portico.getTipoDato('"
                                + pathElementCtx.ID().getText()
                                + "') AND prdt_prvr_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref) AND prvr_prmt_pk = (#{any}) )";

                        break;
                    default:
                        throw new Error("Entidad '" + entiDetailElem.getEnti().getTipo() + "' no valida");
                    }

                    switch (entd.getTpdt().getTipoElemento()) {
                    case SR:
                    case PR:
                        entiDetailElem = EntidadProxy.select(entd.getTpdt().getEnti().getId());

                        break;
                    }
                }

                if (!sqlElement.isEmpty()) {
                    final int posAny = sqlElement.lastIndexOf("#{any}");

                    if (posAny > 0) {
                        sqlElement = sqlElement.replace("#{any}", sqlPath);
                    } else {
                        sqlElement += sqlPath;
                    }

                    sqlPath = sqlElement;
                }

                isFirst = false;
            }
        }

        return "(" + sqlPath + ")";
    }

}
