package xeredi.edifact;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.edifact.d16b.IfcsumLexer;
import xeredi.edifact.d16b.IfcsumParser;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public final class IfcsumTest {

	/**
	 * Test file.
	 *
	 * @param filename
	 *            the filename
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void testFile(final String filename) throws IOException {
		final CharStream charStream = CharStreams.fromFileName(filename);
		final IfcsumLexer lexer = new IfcsumLexer(charStream);

		lexer.removeErrorListeners();
		lexer.addErrorListener(new DescriptiveErrorListener());

		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final IfcsumParser parser = new IfcsumParser(tokens);

		parser.removeErrorListeners();
		parser.addErrorListener(new DescriptiveErrorListener());

		final ParseTree tree = parser.ifcsum();
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		try {
			for (int i = 0; i < 100; i++) {
				final IfcsumTest test = new IfcsumTest();

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum4.itc");
			}
		} catch (final IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
}
