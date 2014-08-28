package xeredi.integra.model.servicio.grammar.manifiesto;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumLoaderTest.
 */
public class IfcsumLoaderTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(IfcsumLoaderTest.class);

    /**
     * Test.
     *
     * @throws IOException
     *             the IO exception
     */
    @Test
    public void test() throws IOException {
        for (int i = 0; i < 1; i++) {
            test("/xeredi/git/portico/integra-portico-test/etc/examples/ifcsum/MZ1NO605_b.itc");
        }
    }

    /**
     * Test.
     *
     * @param filepath
     *            the filepath
     * @throws IOException
     *             the IO exception
     */
    private void test(final String filepath) throws IOException {
        final String message = "Testing: " + filepath;

        System.out.println(message);
        LOG.info(message);

        final ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(filepath));
        final IfcsumLexer lexer = new IfcsumLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final IfcsumParser parser = new IfcsumParser(tokens);
        final ParseTree tree = parser.ifcsum();

        final IfcsumLoader loader = new IfcsumLoader();

        LOG.info(loader.visit(tree));
    }

}
