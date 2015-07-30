package xeredi.integra.proceso.servicio.escala;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.integra.model.servicio.edifact.escala.BermanMaestroReader;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bLexer;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser;

public final class BermanTest {

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
			final BermanD14bLexer lexer = new BermanD14bLexer(input);
			final CommonTokenStream tokens = new CommonTokenStream(lexer);
			final BermanD14bParser parser = new BermanD14bParser(tokens);
			final ParseTree tree = parser.berman();

			final BermanMaestroReader maestroReader = new BermanMaestroReader();

			maestroReader.visit(tree);

            System.out.println(maestroReader.getMaestroCodesMap());
            System.out.println(maestroReader.getNifSet());
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
		parse("/berman.data");
	}

}
