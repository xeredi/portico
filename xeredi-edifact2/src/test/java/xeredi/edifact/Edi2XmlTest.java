package xeredi.edifact;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import xeredi.edifact.jjtree.Message;
import xeredi.edifact.jjtree.Node;
import xeredi.edifact.jjtree.ParseException;

// TODO: Auto-generated Javadoc
/**
 * The Class Edi2XmlTest.
 */
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
		try {
			final Message parser = new Message(new FileInputStream(filename));
			final Edi2Xml edi2Xml = new Edi2Xml();

			final Node message = parser.message();

			message.jjtAccept(edi2Xml, null);

			// System.out.println("xml: " + edi2Xml.toString());
		} catch (final ParseException ex) {
			System.err.println("Error parsing: " + filename);

			throw ex;
		}
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		final Edi2XmlTest test = new Edi2XmlTest();

		try {
			for (int i = 0; i < 2500; i++) {
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak3.itc");

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
