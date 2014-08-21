package xeredi.integra.model.util.grammar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.util.grammar.ConditionParser.BooleanExprContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathElementContext;
import xeredi.integra.model.util.grammar.ConditionParser.ScalarExprContext;

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
        this.reglaVO = areglaVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitScalarExpr(ScalarExprContext ctx) {
        if (ctx.nmb != null) {
            return ctx.nmb.getText();
        }

        if (ctx.str != null) {
            return ctx.str.getText();
        }

        if (ctx.fn != null) {
            if ("COALESCE".equals(ctx.fn.getText())) {
                return " COALESCE(" + visitScalarExpr(ctx.ne1) + ", " + visitScalarExpr(ctx.ne2) + ")";
            }
            if ("escalaNumeroPuertosBuque".equals(ctx.fn.getText())) {
                return " portico.escalaNumeroPuertosBuque(itemId, item.fref)";
            }
            if ("atraqueUdsGt".equals(ctx.fn.getText())) {
                return " portico.atraqueUdsGt(itemId, item.fref)";
            }
            if ("escalaUdsGt".equals(ctx.fn.getText())) {
                return " portico.escalaUdsGt(itemId, item.fref)";
            }
            if ("escalaValorContador".equals(ctx.fn.getText())) {
                return " portico.escalaValorContador(itemId, item.fref, " + ctx.fnArg1.getText() + ")";
            }

            throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
        }

        if (ctx.pt != null) {
            return visitPath(ctx.pt);
        }

        throw new Error("Expresion Numerica no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitBooleanExpr(BooleanExprContext ctx) {
        if (ctx.lp != null) {
            return ctx.lp.getText() + visitBooleanExpr(ctx.be1) + ctx.rp.getText();
        }

        if (ctx.opLogic1 != null) {
            return ctx.opLogic1.getText() + ' ' + visitBooleanExpr(ctx.be1);
        }

        if (ctx.opLogic2 != null) {
            return visitBooleanExpr(ctx.be1) + ' ' + ctx.opLogic2.getText() + ' ' + visitBooleanExpr(ctx.be2);
        }

        if (ctx.opComp != null) {
            return visitScalarExpr(ctx.se1) + ' ' + ctx.opComp.getText() + ' ' + visitScalarExpr(ctx.se2);
        }

        if (ctx.bool != null) {
            return ctx.bool.getText();
        }

        if (ctx.fn != null) {
            if ("escalaEsAvituallamiento".equals(ctx.fn.getText())) {
                return "portico.escalaEsAvituallamiento(itemId, item.fref)";
            }
            if ("escalaEsBuqueBaseEnPuerto".equals(ctx.fn.getText())) {
                return "portico.escalaEsBuqueBaseEnPuerto(itemId, item.fref)";
            }
            if ("escalaEsBuqueCertificado".equals(ctx.fn.getText())) {
                return "portico.escalaEsBuqueCertificado(itemId, item.fref, " + ctx.fnArg1.getText() + ")";
            }

            throw new Error("Funcion '" + ctx.fn.getText() + "' no implementada!");
        }

        throw new Error("Expresion Booleana no implementada!: " + ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitPath(PathContext ctx) {
        String sqlPath = "";

        final EntidadVO entiBase = EntidadProxy.select(reglaVO.getEnti().getId());
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

                    entiElem = TipoServicioProxy.select(tpss.getTpsr().getId());

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
                    final EntidadTipoDatoVO entd = entiElem.getEntdMap().get(tipoDato.getId());

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
                        field += " SELECT " + field + "nentero FROM ";
                        break;
                    case ND:
                        field += " SELECT " + field + "ndecimal FROM ";
                        break;
                    case CR:
                    case TX:
                        field += " SELECT " + field + "cadena FROM ";
                        break;
                    case FE:
                    case FH:
                        field += " SELECT " + field + "fecha FROM ";
                        break;
                    case PR:
                        field = isLast ? " SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = ANY( SELECT "
                                + field + "prmt_pk FROM " : " SELECT " + field + "prmt_pk FROM ";
                        break;
                    case SR:
                        field += " SELECT " + field + "srvc_dep_pk FROM ";
                        break;

                    default:
                        throw new Error("Tipo de dato no soportado");
                    }

                    switch (entiElem.getTipo()) {
                    case P:
                        sqlElement += " tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = "
                                + entd.getTpdt().getId()
                                + " AND prdt_prvr_pk = ANY (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )";
                        break;
                    case T:
                        sqlElement += " tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND srdt_srvc_pk = ";
                        sqlElement += isFirst ? (entiBase.getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk") : "ANY(#{any})";
                        break;
                    case S:
                        sqlElement += " tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND ssdt_ssrv_pk = ";
                        sqlElement += isFirst ? "item.ssrv_pk" : "ANY(#{any})";

                        break;
                    default:
                        throw new Error("Tipo de entidad no soportado");
                    }

                    if (entd.getTpdt().getTipoElemento() == TipoElemento.PR && isLast) {
                        sqlElement += ")";
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
