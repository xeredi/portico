package xeredi.argo.proceso.servicio.escala;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.argo.model.servicio.edifact.escala.AperakMaestroReader;
import xeredi.edifact.grammar.AperakD14bLexer;
import xeredi.edifact.grammar.AperakD14bParser;

// TODO: Auto-generated Javadoc
/**
 * The Class AperakTest.
 */
public final class AperakTest {

    /**
     * Parses the.
     *
     * @param filename
     *            the filename
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void parse(final String filename) throws IOException {
        System.out.println(filename);

        try (final InputStream is = new FileInputStream(filename)) {
            final ANTLRInputStream input = new ANTLRInputStream(is);
            final AperakD14bLexer lexer = new AperakD14bLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final AperakD14bParser parser = new AperakD14bParser(tokens);
            final ParseTree tree = parser.aperak();

            final AperakMaestroReader maestroReader = new AperakMaestroReader();

            maestroReader.visit(tree);
        }
    }

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        parse("/aperak_a.data");
        parse("/aperak_b.data");
        parse("/aperak_c1_a.data");
        parse("/aperak_c1_b.data");
        parse("/aperak_c2.data");
        parse("/aperak_d1.data");
        parse("/aperak_d2.data");
    }

}
