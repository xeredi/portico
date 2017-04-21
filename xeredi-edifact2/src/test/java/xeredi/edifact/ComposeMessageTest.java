package xeredi.edifact;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import xeredi.edifact.jjtree.Message;
import xeredi.edifact.jjtree.Node;
import xeredi.edifact.jjtree.ParseException;
import xeredi.edifact.model.CompositeData;
import xeredi.edifact.model.EdifactMessage;
import xeredi.edifact.model.MessageType;
import xeredi.edifact.model.SegmentType;
import xeredi.edifact.model.SimpleData;
import xeredi.edifact.model.SimpleSegment;

// TODO: Auto-generated Javadoc
/**
 * The Class ComposeMessageTest.
 */
public final class ComposeMessageTest {

	/**
	 * Compose.
	 *
	 * @return the edifact message
	 */
	private EdifactMessage compose() {
		return new EdifactMessage(MessageType.AUTHOR, "d96a",
				new SimpleSegment(SegmentType.UNH, new SimpleData("1"), new CompositeData("AUTHOR", "D", "96A", "UN")),
				new SimpleSegment(SegmentType.BGM, new SimpleData("149"), new SimpleData("123457")),
				new SimpleSegment(SegmentType.DTM, new CompositeData("137", "20091028", "102")),
				new SimpleSegment(SegmentType.BUS, null, null, null, new SimpleData("XAB")),
				new SimpleSegment(SegmentType.FII, new SimpleData("BF"), new SimpleData("13877034")),
				new SimpleSegment(SegmentType.LIN, new SimpleData("1"), new SimpleData("37")),
				new SimpleSegment(SegmentType.RFF, new CompositeData("IT", "12345678")),
				new SimpleSegment(SegmentType.UNT, new SimpleData("8"), new SimpleData("1")));
	}

	/**
	 * Validate.
	 *
	 * @param edifactMessage
	 *            the edifact message
	 * @throws ParseException
	 *             the parse exception
	 */
	private void validate(final EdifactMessage edifactMessage) throws ParseException {
		final Message message = new Message(new ByteArrayInputStream(edifactMessage.toEdifact().getBytes()));

		message.message();
	}

	/**
	 * Convert 2 xml.
	 *
	 * @param edifactMessage
	 *            the edifact message
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	private String convert2Xml(final EdifactMessage edifactMessage) throws ParseException {
		final Edi2Xml edi2Xml = new Edi2Xml();
		final Message message = new Message(new ByteArrayInputStream(edifactMessage.toEdifact().getBytes()));
		final Node node = message.message();

		node.jjtAccept(edi2Xml, null);

		return edi2Xml.toString();
	}

	/**
	 * Test.
	 *
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void test() throws ParseException {
		System.out.println("EDIFACT Message Compose");

		final EdifactMessage edifactMessage = compose();

		System.out.println(edifactMessage.toEdifact());

		System.out.println("EDIFACT Message Validation");

		validate(edifactMessage);

		System.out.println("EDIFACT XML Generation");

		final String xml = convert2Xml(edifactMessage);

		System.out.println(xml);

		final int numIterations = 10000;

		System.out.println("Performance Test. Iterations: " + numIterations);

		for (int i = 0; i < numIterations; i++) {
			compose();
			validate(compose());
			convert2Xml(compose());
		}

		System.out.println("Test OK");
	}
}
