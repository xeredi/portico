package xeredi.integra.model.util.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestTest.
 */
public final class TestTest {

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        test("5 > 3");
        test("true OR false");
    }

    /**
     * Test.
     *
     * @param expression
     *            the expression
     * @throws IOException
     *             the IO exception
     */
    private void test(final String expression) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final TestLexer lexer = new TestLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TestParser parser = new TestParser(tokens);
        final ParseTree tree = parser.condition();

        System.out.println(tree.toStringTree(parser));
    }

}
