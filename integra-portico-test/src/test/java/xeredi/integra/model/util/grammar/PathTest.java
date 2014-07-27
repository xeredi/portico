package xeredi.integra.model.util.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class PathTest.
 */
public final class PathTest {

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        for (int i = 0; i < 10; i++) {
            final ANTLRInputStream input = new ANTLRInputStream("COALESCE(padre[\"LUIS\"].dato[\"JUAN" + i + "\"], padre[\"LUIS\"])");
            final PathLexer lexer = new PathLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final PathParser parser = new PathParser(tokens);

            parser.r();
        }
    }

}
