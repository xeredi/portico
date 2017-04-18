package xeredi.edifact;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

// TODO: Auto-generated Javadoc
/**
 * The Class EdifactToXmlConverter.
 */
public final class EdifactToXmlConverter {

	/** The builder. */
	private final StringBuilder builder = new StringBuilder();

	/**
	 * Convert.
	 *
	 * @param tree
	 *            the tree
	 */
	public void convert(final ParseTree tree) {
		final Object payload = tree.getPayload();

		if (payload instanceof RuleContext) {
			final RuleContext context = (RuleContext) payload;
			final String ruleName = context.getClass().getSimpleName();

			if (!ruleName.startsWith("M_") && !ruleName.startsWith("Gr_")) {
				builder.append('<').append(ruleName).append('>');
			}

			if (ruleName.startsWith("D_")) {
				builder.append(context.getText());
			} else {
				for (int i = 0; i < context.getChildCount(); i++) {
					convert(context.getChild(i));
				}
			}

			if (!ruleName.startsWith("M_") && !ruleName.startsWith("Gr_")) {
				builder.append("</").append(ruleName).append('>');
			}
		}
	}
}
