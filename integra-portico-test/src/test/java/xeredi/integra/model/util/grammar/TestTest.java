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
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream("hello pepe");
        final TestLexer lexer = new TestLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TestParser parser = new TestParser(tokens);

        parser.r();
    }
}
