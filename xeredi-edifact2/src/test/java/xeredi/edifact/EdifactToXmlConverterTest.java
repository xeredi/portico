package xeredi.edifact;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import xeredi.edifact.d16b.MessageLexer;
import xeredi.edifact.d16b.MessageParser;

// TODO: Auto-generated Javadoc
/**
 * The Class EdifactToXmlConverterTest.
 */
public final class EdifactToXmlConverterTest {

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
		final MessageLexer lexer = new MessageLexer(charStream);

		lexer.removeErrorListeners();
		lexer.addErrorListener(new DescriptiveErrorListener());

		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final MessageParser parser = new MessageParser(tokens);

		parser.removeErrorListeners();
		parser.addErrorListener(new DescriptiveErrorListener());

		final EdifactToXmlConverter converter = new EdifactToXmlConverter();

		converter.convert(parser.message());
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		try {
			final EdifactToXmlConverterTest test = new EdifactToXmlConverterTest();

			for (int i = 0; i < 1; i++) {
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak3.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author3.itc");

				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/berman/berman1.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco4.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco5.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum4.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/invoic/invoic1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/invoic/invoic2.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/orders/orders1.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/paymul/paymul1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/paymul/paymul2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/paymul/paymul3.itc");
			}
		} catch (final IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
