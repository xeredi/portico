package xeredi.argo.model.facturacion.grammar;

import java.util.Iterator;

import lombok.NonNull;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.argo.model.facturacion.grammar.FormulaParser.DecodeBranchContext;
import xeredi.argo.model.facturacion.grammar.FormulaParser.PropertyContext;
import xeredi.argo.model.facturacion.grammar.FormulaParser.PropertyElementContext;
import xeredi.argo.model.facturacion.grammar.FormulaParser.ValueContext;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FormulaSqlGenerator.
 */
public final class FormulaSqlGenerator extends FormulaBaseVisitor {

    /** The contexto vo. */
    private final transient ReglaVO reglaVO;

    /**
     * Instantiates a new formula sql generator.
     *
     * @param areglaVO
     *            the aregla vo
     */
    public FormulaSqlGenerator(final ReglaVO areglaVO) {
        super();
        reglaVO = areglaVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitValue(final @NonNull ValueContext ctx) {
        if (ctx.cte != null) {
            return ctx.cte.getText();
        }

        if (ctx.lp != null) {
            return ctx.lp.getText() + visitValue(ctx.v1) + ctx.rp.getText();
        }

        if (ctx.arithmeticOp != null) {
            return visitValue(ctx.v1) + ctx.arithmeticOp.getText() + visitValue(ctx.v2);
        }

        if (ctx.prop != null) {
            return visitProperty(ctx.prop);
        }

        // if (ctx.minus != null) {
        // return ctx.minus.getText() + visitNumericValue(ctx.n2);
        // }

        if (ctx.fn != null) {
            final FunctionName functionName = FunctionName.valueOf(ctx.fn.getText());

            switch (functionName) {
            case CONCAT:
                return " CONCAT(" + visitValue(ctx.v1) + ", " + visitValue(ctx.v2) + ")";
            case COALESCE:
                return " COALESCE(" + visitValue(ctx.v1) + ", " + visitValue(ctx.v2) + ")";
            case DECODE:
                String sqlCase = " CASE " + visitValue(ctx.v1);

                for (final ParseTree tree : ctx.children) {
                    if (tree instanceof DecodeBranchContext) {
                        final DecodeBranchContext decodeBranchContext = (DecodeBranchContext) tree;

                        sqlCase += " WHEN " + visitValue(decodeBranchContext.v1) + " THEN "
                                + visitValue(decodeBranchContext.v2);
                    }
                }

                if (ctx.v2 != null) {
                    sqlCase += " ELSE " + visitValue(ctx.v2);
                }

                sqlCase += " END";

                return sqlCase;
            case acumuladoTeus:
                return " portico.acumuladoTeus(" + visitValue(ctx.v1) + ", " + visitValue(ctx.v2) + ", "
                        + visitValue(ctx.v3) + ")";

            default:
                throw new Error("Funcion '" + functionName.name() + "' no implementada!");
            }
        }

        throw new Error("Valor No implementado!: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitProperty(final PropertyContext ctx) {
        String sqlPath = "";

        final AbstractEntidadDetailVO entiDetailBase = EntidadProxy.select(reglaVO.getEnti().getId());

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

                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(entiDetailElem.getEnti()
                            .getId());

                    entiDetailElem = TipoServicioProxy.select(tpssDetail.getEnti().getTpsrId());

                    sqlElement += "SELECT srvc_pk FROM tbl_servicio_srvc WHERE srvc_pk = ";
                    sqlElement += isFirst ? "item.ssrv_srvc_pk" : "#{any}";
                }

                if (pathElementCtx.parent != null) {
                    if (entiDetailElem.getEnti().getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al padre desde un subservicio");
                    }

                    final Entidad entidad = Entidad.valueOf(pathElementCtx.arg.getText());

                    entiDetailElem = EntidadProxy.select(entidad.getId());

                    sqlElement += "SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = "
                            + entiDetailElem.getEnti().getId() + ") AND ssss_ssrvh_pk = ";
                    sqlElement += isFirst ? "item.ssrv_pk" : "(#{any})";
                }

                if (pathElementCtx.data != null) {
                    final TipoDato tipoDato = TipoDato.valueOf(pathElementCtx.arg.getText());

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

                    String field = "";

                    switch (entiDetailElem.getEnti().getTipo()) {
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
                        field += "nentero";
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

                    switch (entiDetailElem.getEnti().getTipo()) {
                    case P:
                        sqlElement += " tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = "
                                + entd.getTpdt().getId()
                                + " AND prdt_prvr_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )";
                        break;
                    case T:
                        sqlElement += " tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND srdt_srvc_pk = ";
                        sqlElement += isFirst ? entiDetailBase.getEnti().getTipo() == TipoEntidad.T ? "item.srvc_pk"
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
