package xeredi.edifact;

import xeredi.edifact.jjtree.MessageDefaultVisitor;
import xeredi.edifact.jjtree.SimpleNode;
import xeredi.edifact.jjtree.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class Edi2Xml.
 */
public final class Edi2Xml extends MessageDefaultVisitor {

	/** The builder. */
	private final StringBuilder builder = new StringBuilder();

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object defaultVisit(SimpleNode node, Object data) {
		final String nodeName = node.toString();

		if (nodeName.startsWith("s_") || nodeName.startsWith("c_") || nodeName.startsWith("d_")
				|| nodeName.equals("message")) {
			builder.append('<').append(nodeName).append('>');
		}

		if (nodeName.startsWith("d_")) {
			builder.append(node.jjtGetFirstToken().image);
		}

		// System.out.println("node: " + node.toString() + ", value: " + node.jjtGetValue() + ", data: " + data);

		data = node.childrenAccept(this, data);

		if (nodeName.startsWith("s_") || nodeName.startsWith("c_") || nodeName.startsWith("d_")
				|| nodeName.equals("message")) {
			builder.append("</").append(nodeName).append('>');
		}

		return data;
	}

}
