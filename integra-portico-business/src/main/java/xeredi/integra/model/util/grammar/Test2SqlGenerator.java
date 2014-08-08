package xeredi.integra.model.util.grammar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.util.grammar.Test2Parser.BooleanExprContext;
import xeredi.integra.model.util.grammar.Test2Parser.NumericExprContext;
import xeredi.integra.model.util.grammar.Test2Parser.PathContext;
import xeredi.integra.model.util.grammar.Test2Parser.PathElementContext;
import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Class TestInterpreter.
 */
public final class Test2SqlGenerator extends Test2BaseVisitor {

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /** The contexto vo. */
    private final transient ValoradorContextoVO contextoVO;

    /**
     * Instantiates a new test sql generator.
     *
     * @param acontextoVO
     *            the acontexto vo
     */
    public Test2SqlGenerator(final ValoradorContextoVO acontextoVO) {
        super();
        this.contextoVO = acontextoVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String visitNumericExpr(NumericExprContext ctx) {
        if (ctx.nmb != null) {
            return ctx.nmb.getText();
        }

        if (ctx.fn != null) {
            if ("COALESCE".equals(ctx.fn.getText())) {
                return " COALESCE(" + visitNumericExpr(ctx.ne1) + ", " + visitNumericExpr(ctx.ne2) + ")";
            }
            if ("escalaNumeroPuertosBuque".equals(ctx.fn.getText())) {
                return " portico.escalaNumeroPuertosBuque(itemId, '" + DATE_FORMAT.format(contextoVO.getFreferencia())
                        + "')";
            }
            if ("escalaValorContador".equals(ctx.fn.getText())) {
                return " portico.escalaValorContador(itemId, '" + DATE_FORMAT.format(contextoVO.getFreferencia())
                        + "', " + ctx.fnArg1.getText() + ")";
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
            return visitNumericExpr(ctx.ne1) + ' ' + ctx.opComp.getText() + ' ' + visitNumericExpr(ctx.ne2);
        }

        if (ctx.bool != null) {
            return ctx.bool.getText();
        }

        if (ctx.fn != null) {
            if ("escalaEsAvituallamiento".equals(ctx.fn.getText())) {
                return "portico.escalaEsAvituallamiento(itemId, '" + DATE_FORMAT.format(contextoVO.getFreferencia())
                        + "')";
            }
            if ("escalaEsBuqueBaseEnPuerto".equals(ctx.fn.getText())) {
                return "portico.escalaEsBuqueBaseEnPuerto(itemId, '" + DATE_FORMAT.format(contextoVO.getFreferencia())
                        + "')";
            }
            if ("escalaEsBuqueCertificado".equals(ctx.fn.getText())) {
                return "portico.escalaEsBuqueCertificado(itemId, '" + DATE_FORMAT.format(contextoVO.getFreferencia())
                        + "', " + ctx.fnArg1.getText() + ")";
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
        String sql = "";

        EntidadVO entiBase = contextoVO.getRgla().getEnti();

        boolean isFirst = true;
        boolean isLast = false;

        final Iterator<ParseTree> parseTreeIterator = ctx.children.iterator();

        while (parseTreeIterator.hasNext()) {
            final ParseTree parseTree = parseTreeIterator.next();

            entiBase = EntidadProxy.select(entiBase.getId());

            if (!parseTreeIterator.hasNext()) {
                isLast = true;
            }

            if (parseTree instanceof PathElementContext) {
                final PathElementContext pathElementCtx = (PathElementContext) parseTree.getPayload();

                if (pathElementCtx.data != null) {
                    final TipoDato tipoDato = TipoDato.valueOf(pathElementCtx.arg.getText());
                    final EntidadTipoDatoVO entd = entiBase.getEntdMap().get(tipoDato.getId());

                    String field = "";

                    switch (entiBase.getTipo()) {
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

                    sql += " SELECT " + field + " FROM ";

                    switch (entiBase.getTipo()) {
                    case P:
                        sql += " tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = "
                                + entd.getTpdt().getId()
                                + " AND prdt_prvr_pk = ANY (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )";
                        break;
                    case T:
                        sql += " tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND srdt_srvc_pk = ";
                        sql += isFirst ? (entiBase.getTipo() == TipoEntidad.T ? "item.srvc_pk" : "item.ssrv_srvc_pk")
                                : "ANY(#{any})";
                        break;
                    case S:
                        sql += " tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = " + entd.getTpdt().getId()
                                + " AND ssdt_ssrv_pk = ";
                        sql += isFirst ? "item.ssrv_pk" : "ANY(#{any})";

                        break;
                    default:
                        throw new Error("Tipo de entidad no soportado");
                    }
                }

                isFirst = false;
            }
        }

        // TODO Auto-generated method stub

        return "(" + sql + ")";
    }

}
