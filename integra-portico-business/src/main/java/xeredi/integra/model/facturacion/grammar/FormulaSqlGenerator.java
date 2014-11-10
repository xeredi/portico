package xeredi.integra.model.facturacion.grammar;

import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.metamodelo.proxy.EntidadProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.util.grammar.FormulaBaseVisitor;
import xeredi.integra.model.util.grammar.FormulaParser.AritmethicExprContext;
import xeredi.integra.model.util.grammar.FormulaParser.PathContext;
import xeredi.integra.model.util.grammar.FormulaParser.PathElementContext;

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
    public String visitAritmethicExpr(final AritmethicExprContext ctx) {
        if (ctx.nmb != null) {
            return ctx.nmb.getText();
        }

        if (ctx.lp != null) {
            return ctx.lp.getText() + visitAritmethicExpr(ctx.ae1) + ctx.rp.getText();
        }

        if (ctx.fn != null) {
            if ("COALESCE".equals(ctx.fn.getText())) {
                return " COALESCE(" + visitAritmethicExpr(ctx.ae1) + ", " + visitAritmethicExpr(ctx.ae2) + ")";
            }
            if ("escalaNumeroPuertosBuque".equals(ctx.fn.getText())) {
                return " portico.escalaNumeroPuertosBuque(itemId, item.fref)";
            }
            if ("escalaUdsGt".equals(ctx.fn.getText())) {
                return " portico.escalaUdsGt(itemId, item.fref)";
            }
            if ("atraqueUdsGt".equals(ctx.fn.getText())) {
                return " portico.atraqueUdsGt(itemId, item.fref)";
            }
            if ("escalaValorContador".equals(ctx.fn.getText())) {
                return " portico.escalaValorContador(itemId, item.fref, " + ctx.fnArg1.getText() + ")";
            }

            throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
        }

        if (ctx.pt != null) {
            return visitPath(ctx.pt);
        }

        if (ctx.opArit1 != null) {
            return ctx.opArit1.getText() + ' ' + visitAritmethicExpr(ctx.ae1);
        }

        if (ctx.opArit2 != null) {
            return visitAritmethicExpr(ctx.ae1) + ' ' + ctx.opArit2.getText() + ' ' + visitAritmethicExpr(ctx.ae2);
        }

        throw new Error("Expresion Aritmetica no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitPath(final PathContext ctx) {
        String sqlPath = "";

        final EntidadVO entiBase = EntidadProxy.select(reglaVO.getRglv().getEnti().getId());
        EntidadVO entiElem = entiBase;

        boolean isFirst = true;
        boolean isLast = false;

        final Iterator<ParseTree> parseTreeIterator = ctx.children.iterator();

        while (parseTreeIterator.hasNext()) {
            final ParseTree parseTree = parseTreeIterator.next();

            if (!parseTreeIterator.hasNext()) {
                isLast = true;
            }

            if (parseTree instanceof PathElementContext) {
                final PathElementContext pathElementCtx = (PathElementContext) parseTree.getPayload();
                String sqlElement = "";

                if (pathElementCtx.service != null) {
                    if (entiElem.getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al servicio desde un subservicio");
                    }

                    final TipoSubservicioVO tpss = TipoSubservicioProxy.select(entiElem.getId());

                    entiElem = TipoServicioProxy.select(tpss.getTpsrId());

                    sqlElement += "SELECT srvc_pk FROM tbl_servicio_srvc WHERE srvc_pk = ";
                    sqlElement += isFirst ? "item.ssrv_srvc_pk" : "#{any}";
                }

                if (pathElementCtx.parent != null) {
                    if (entiElem.getTipo() != TipoEntidad.S) {
                        throw new Error("Solo se puede llegar al padre desde un subservicio");
                    }

                    final Entidad entidad = Entidad.valueOf(pathElementCtx.arg.getText());

                    entiElem = EntidadProxy.select(entidad.getId());

                    sqlElement += "SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = "
                            + entiElem.getId() + ") AND ssss_ssrvh_pk = ";
                    sqlElement += isFirst ? "item.ssrv_pk" : "ANY(#{any})";
                }

                if (pathElementCtx.data != null) {
                    final TipoDato tipoDato = TipoDato.valueOf(pathElementCtx.arg.getText());

                    EntidadTipoDatoVO entd = null;

                    for (final EntidadTipoDatoVO vo : entiElem.getEntdList()) {
                        if (vo.getTpdt().getId() == tipoDato.getId()) {
                            entd = vo;
                        }
                    }

                    if (entd == null) {
                        throw new Error("Dato no encontrado: " + tipoDato);
                    }

                    String field = "";

                    switch (entiElem.getTipo()) {
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

                    switch (entiElem.getTipo()) {
                    case P:
                        sqlElement += " tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = "
                                + entd.getTpdt().getId()
                                + " AND prdt_prvr_pk = ANY (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )";
                        break;
                    case T:
                        sqlElement += " tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = " + entd.getTpdt().getId()
                        + " AND srdt_srvc_pk = ";
                        sqlElement += isFirst ? entiBase.getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk" : "ANY(#{any})";
                        break;
                    case S:
                        sqlElement += " tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = " + entd.getTpdt().getId()
                        + " AND ssdt_ssrv_pk = ";
                        sqlElement += isFirst ? "item.ssrv_pk" : "ANY(#{any})";

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
