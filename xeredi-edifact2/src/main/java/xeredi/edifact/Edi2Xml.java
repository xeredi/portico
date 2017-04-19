package xeredi.edifact;

import xeredi.edifact.javacc.Message;
import xeredi.edifact.javacc.MessageTokenManager;
import xeredi.edifact.javacc.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class Edi2Xml.
 */
public final class Edi2Xml {

	/** The builder. */
	private final StringBuilder builder = new StringBuilder();

	/**
	 * Convert.
	 *
	 * @param message
	 *            the message
	 */
	public void convert(final Message message) {
		final MessageTokenManager manager = message.token_source;

		Token token = null;

		do {
			token = manager.getNextToken();

			System.out
					.println("token: " + token.image + ", class: " + token.getClass() + ", value: " + token.getValue());
		} while (token != null);
	}
}
