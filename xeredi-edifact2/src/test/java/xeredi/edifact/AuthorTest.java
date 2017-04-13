package xeredi.edifact;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.edifact.d16b.AuthorLexer;
import xeredi.edifact.d16b.AuthorParser;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public final class AuthorTest {

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
		final AuthorLexer lexer = new AuthorLexer(charStream);

		lexer.removeErrorListeners();
		lexer.addErrorListener(new DescriptiveErrorListener());

		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final AuthorParser parser = new AuthorParser(tokens);

		parser.removeErrorListeners();
		parser.addErrorListener(new DescriptiveErrorListener());

		final ParseTree tree = parser.author();
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		try {
			for (int i = 0; i < 10000; i++) {
				final AuthorTest test = new AuthorTest();

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author3.itc");
			}
		} catch (final IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
}
