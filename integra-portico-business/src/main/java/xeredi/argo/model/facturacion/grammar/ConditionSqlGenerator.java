package xeredi.argo.model.facturacion.grammar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import lombok.NonNull;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.argo.model.facturacion.grammar.ConditionParser.ConditionContext;
import xeredi.argo.model.facturacion.grammar.ConditionParser.NumericValueContext;
import xeredi.argo.model.facturacion.grammar.ConditionParser.PropertyContext;
import xeredi.argo.model.facturacion.grammar.ConditionParser.PropertyElementContext;
import xeredi.argo.model.facturacion.grammar.ConditionParser.TextValueContext;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TestInterpreter.
 */
public final class ConditionSqlGenerator extends ConditionBaseVisitor {

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /** The contexto vo. */
    private final transient ReglaVO reglaVO;

    /**
     * The Constructor.
     *
     * @param areglaVO
     *            the aregla vo
     */
    public ConditionSqlGenerator(final ReglaVO areglaVO) {
        super();
        reglaVO = areglaVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitCondition(final @NonNull ConditionContext ctx) {
        if (ctx.bool != null) {
            return ctx.bool.getText();
        }

        if (ctx.lp != null) {
            return ctx.lp.getText() + visitCondition(ctx.cond1) + ctx.rp.getText();
        }

        if (ctx.unaryBool != null) {
            return ctx.unaryBool.getText() + ' ' + visitCondition(ctx.cond1);
        }

        if (ctx.binaryBool != null) {
            return visitCondition(ctx.cond1) + ' ' + ctx.binaryBool.getText() + ' ' + visitCondition(ctx.cond2);
        }

        if (ctx.relatOp != null) {
            return visitValue(ctx.value1).toString() + ' ' + ctx.relatOp.getText() + ' '
                    + visitValue(ctx.value2).toString();
        }

        if (ctx.likeOp != null) {
            return visitTextValue(ctx.text1).toString() + ' ' + ctx.likeOp.getText() + ' '
                    + visitTextValue(ctx.text2).toString();
        }

        if (ctx.inOp != null) {
            return visitValue(ctx.value1).toString() + ' ' + ctx.inOp.getText() + ' ' + ctx.cteList.getText();
        }

        throw new Error("Expresion Numerica no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitNumericValue(final NumericValueContext ctx) {
        if (ctx.cte != null) {
            return ctx.cte.getText();
        }

        if (ctx.lp != null) {
            return ctx.lp.getText() + visitNumericValue(ctx.n1) + ctx.rp.getText();
        }

        if (ctx.arithmeticOp != null) {
            return visitNumericValue(ctx.n1) + ctx.arithmeticOp.getText() + visitNumericValue(ctx.n2);
        }

//        if (ctx.minus != null) {
//            return ctx.minus.getText() + visitNumericValue(ctx.n2);
//        }

        if (ctx.fn != null) {
            switch (ctx.fn.getText()) {
            case "COALESCE":
                return " COALESCE(" + visitNumericValue(ctx.n1) + ", " + visitNumericValue(ctx.n2) + ")";
            case "DECODE":
                throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
            case "escalaNumeroPuertosBuque":
                return " portico.escalaNumeroPuertosBuque(itemId, item.fref)";
            case "escalaUdsGt":
                return " portico.escalaUdsGt(itemId, item.fref)";
            case "atraqueUdsGt":
                return " portico.atraqueUdsGt(itemId, item.fref)";
            case "escalaValorContador":
                return " portico.escalaValorContador(itemId, item.fref, " + ctx.cntName.getText() + ")";

            default:
                throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
            }
        }

        if (ctx.prop != null) {
            return visitProperty(ctx.prop);
        }

        throw new Error("Expresion Numerica no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitTextValue(final TextValueContext ctx) {
        if (ctx.cte != null) {
            return ctx.cte.getText();
        }

        if (ctx.prop != null) {
            return visitProperty(ctx.prop);
        }

        if (ctx.fn != null) {
            switch (ctx.fn.getText()) {
            case "COALESCE":
                return " COALESCE(" + visitTextValue(ctx.t1) + ", " + visitTextValue(ctx.t2) + ")";
            case "DECODE":
                throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");

            default:
                throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
            }
        }

        throw new Error("Expresion de Texto no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitProperty(final PropertyContext ctx) {
        String sqlPath = "";

        final AbstractEntidadDetailVO entiDetalleBase = EntidadProxy.select(reglaVO.getEnti().getId());

        AbstractEntidadDetailVO entiDetalleElem = entiDetalleBase;

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
                    if (entiDetalleElem.getEnti().getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al servicio desde un subservicio");
                    }

                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(entiDetalleElem.getEnti()
                            .getId());

                    entiDetalleElem = TipoServicioProxy.select(tpssDetail.getEnti().getTpsrId());

                    sqlElement += "SELECT srvc_pk FROM tbl_servicio_srvc WHERE srvc_pk = ";
                    sqlElement += isFirst ? "item.ssrv_srvc_pk" : "#{any}";
                }

                if (pathElementCtx.parent != null) {
                    if (entiDetalleElem.getEnti().getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al padre desde un subservicio");
                    }

                    final Entidad entidad = Entidad.valueOf(pathElementCtx.arg.getText());

                    entiDetalleElem = EntidadProxy.select(entidad.getId());

                    sqlElement += "SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = "
                            + entiDetalleElem.getEnti().getId() + ") AND ssss_ssrvh_pk = ";
                    sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";
                }

                if (pathElementCtx.data != null) {
                    final TipoDato tipoDato = TipoDato.valueOf(pathElementCtx.arg.getText());

                    EntidadTipoDatoVO entd = null;

                    for (final Long tpdtId : entiDetalleElem.getEntdList()) {
                        final EntidadTipoDatoVO vo = entiDetalleElem.getEntdMap().get(tpdtId);

                        if (vo.getTpdt().getId() == tipoDato.getId()) {
                            entd = vo;
                        }
                    }

                    if (entd == null) {
                        throw new Error("Dato no encontrado: " + tipoDato);
                    }

                    String field = "";

                    switch (entiDetalleElem.getEnti().getTipo()) {
                    case P:
                        field = "prdt_";
                        break;
                    case T:
                        field = "srdt_";
                        break;
                    case S:
                        field = "ssdt_";
                        break;
                    default:
                        throw new Error("Tipo de entidad no soportado");
                    }

                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                    case NE:
                        field += "nentero";
                        break;
                    case ND:
                        field += "ndecimal";
                        break;
                    case CR:
                    case TX:
                        field += "cadena";
                        break;
                    case FE:
                    case FH:
                        field += "fecha";
                        break;
                    case PR:
                        field += "prmt_pk";
                        break;
                    case SR:
                        field += "srvc_dep_pk";
                        break;

                    default:
                        throw new Error("Tipo de dato no soportado");
                    }

                    sqlElement += " SELECT " + field + " FROM ";

                    switch (entiDetalleElem.getEnti().getTipo()) {
                    case P:
                        sqlElement += " tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = "
                                + entd.getTpdt().getId()
                                + " AND prdt_prvr_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any})) ";
                        break;
                    case T:
                        sqlElement += " tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND srdt_srvc_pk = ";
                        sqlElement += isFirst ? entiDetalleBase.getEnti().getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk" : "(#{any})";
                        break;
                    case S:
                        sqlElement += " tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND ssdt_ssrv_pk = ";
                        sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";

                        break;
                    default:
                        throw new Error("Tipo de entidad no soportado");
                    }

                    if (entd.getTpdt().getTipoElemento() == TipoElemento.PR && isLast) {
                    //    sqlElement += ")";
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
