package xeredi.edifact;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import xeredi.edifact.javacc.Message;
import xeredi.edifact.javacc.ParseException;

public final class Edi2XmlTest {

	/**
	 * Test file.
	 *
	 * @param filename
	 *            the filename
	 * @throws ParseException
	 *             the parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void testFile(final String filename) throws ParseException, IOException {
		final Message parser = new Message(new FileInputStream(filename));
		final Edi2Xml edi2Xml = new Edi2Xml();

		parser.message();
		edi2Xml.convert(parser);
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		final Edi2XmlTest test = new Edi2XmlTest();

		try {
			for (int i = 0; i < 1; i++) {
				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak1.itc");
				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak2.itc");
				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak3.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum4.itc");
			}
		} catch (final ParseException ex) {
			ex.printStackTrace(System.err);
		} catch (final IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
