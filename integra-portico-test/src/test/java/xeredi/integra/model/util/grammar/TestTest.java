package xeredi.integra.model.util.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
        // test("5 > 3");
        test("(true AND false) OR (NOT true)");
        test("(true OR false) AND (5 > 4)");
        test("NOT (COALESCE(3, 5) > 4)");
        test("escalaEsAvituallamiento() AND (5 > 4)");
        test("escalaEsBuqueCertificado('PEPE') AND (escalaNumeroPuertosBuque() > 4)");
        // test("servicio.dato(BUQUE) <> 4");
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
        // final ParseTree tree = parser.condition();

        // System.out.println(tree.toStringTree(parser));
        System.out.println(parser.condition().sql);
    }

}
