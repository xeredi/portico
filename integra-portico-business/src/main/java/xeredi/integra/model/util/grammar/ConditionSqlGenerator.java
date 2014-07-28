package xeredi.integra.model.util.grammar;

import xeredi.integra.model.util.grammar.ConditionParser.BooleanExprContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathElementContext;
import xeredi.integra.model.util.grammar.ConditionParser.RContext;
import xeredi.integra.model.vo.facturacion.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConditionSqlGenerator.
 */
public final class ConditionSqlGenerator extends ConditionBaseVisitor {

    /** The sql. */
    private final transient StringBuffer sql;

    /** The regla. */
    private final transient ReglaVO regla;

    /**
     * The Constructor.
     *
     * @param aregla
     *            the aregla
     */
    public ConditionSqlGenerator(final ReglaVO aregla) {
        super();

        this.sql = new StringBuffer();
        this.regla = aregla;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPath(PathContext ctx) {
        sql.setLength(0);

        if (!ctx.children.isEmpty()) {
            for (int i = ctx.children.size(); i > 0; i--) {
                ctx.children.get(i - 1).accept(this);
            }

            System.out.println("sql: " + sql);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitR(RContext ctx) {
        return super.visitR(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitBooleanExpr(BooleanExprContext ctx) {
        return super.visitBooleanExpr(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPathElement(PathElementContext ctx) {
        if (ctx.ELEMENT_SERVICE() != null) {
            sql.append("Servicio!!");
        }
        if (ctx.ELEMENT_PARENT() != null) {
            sql.append("Padre!!_" + ctx.ID().getText());
        }
        if (ctx.ELEMENT_DATA_SERVICE() != null) {
            sql.append("DatoServicio!!_" + ctx.ID().getText());
        }
        if (ctx.ELEMENT_DATA_SUBSERVICE() != null) {
            sql.append("DatoSubservicio!!_" + ctx.ID().getText());
        }

        return null;
    }

}
