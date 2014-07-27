package xeredi.integra.model.util.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class FormulaTest.
 */
public final class FormulaTest {
    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        for (int i = 0; i < 100; i++) {
            final ANTLRInputStream input = new ANTLRInputStream("servicio.datoSr(LUIS) + padre(LUIS).datoSs(ALBERTO" + i + ") / 1000.5");
            final FormulaLexer lexer = new FormulaLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final FormulaParser parser = new FormulaParser(tokens);

            parser.r();
        }
    }
}
