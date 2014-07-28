package xeredi.integra.model.util.grammar;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import xeredi.integra.model.util.grammar.ConditionParser.BooleanExprContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathContext;
import xeredi.integra.model.util.grammar.ConditionParser.PathElementContext;
import xeredi.integra.model.util.grammar.ConditionParser.RContext;

// TODO: Auto-generated Javadoc
/**
 * The Class ConditionSqlGenerator.
 */
public final class ConditionSqlGenerator extends ConditionBaseListener {

    /** The parser. */
    private final transient ConditionParser parser;

    /** The sql. */
    private final transient String sql;

    /**
     * The Constructor.
     *
     * @param aparser
     *            the parser
     */
    public ConditionSqlGenerator(final ConditionParser aparser) {
        super();
        this.parser = aparser;
        this.sql = "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enterR(RContext ctx) {
        super.enterR(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exitR(RContext ctx) {
        super.exitR(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enterBooleanExpr(BooleanExprContext ctx) {
        super.enterBooleanExpr(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exitBooleanExpr(BooleanExprContext ctx) {
        super.exitBooleanExpr(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enterPath(PathContext ctx) {
        super.enterPath(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exitPath(PathContext ctx) {
        super.exitPath(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enterPathElement(PathElementContext ctx) {
        super.enterPathElement(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exitPathElement(PathElementContext ctx) {
        super.exitPathElement(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

}
