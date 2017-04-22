package xeredi.edifact;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import xeredi.edifact.jjtree.Message;
import xeredi.edifact.jjtree.Node;
import xeredi.edifact.jjtree.ParseException;
import xeredi.edifact.xml.Edi2Xml;

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
		try (final InputStream is = new FileInputStream(filename)) {
			final Message parser = new Message(is);
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
			for (int i = 0; i < 2000; i++) {
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/aperak/aperak3.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/author/author3.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/bansta/bansta1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/bansta/bansta2.itc");

				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/berman/berman1.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco4.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/codeco/codeco5.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/cremul/cremul1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/cremul/cremul2.itc");

				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/cuscar/cuscar1.itc");

				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/cusres/cusres1.itc");
				// test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/cusres/cusres2.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum2.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum3.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/ifcsum/ifcsum4.itc");

				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/invoic/invoic1.itc");
				test.testFile("/home/xeredi/git/portico/xeredi-edifact2/samples/invoic/invoic2.itc");
			}
		} catch (final ParseException ex) {
			ex.printStackTrace(System.err);
		} catch (final IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
