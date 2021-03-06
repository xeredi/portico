package xeredi.argo.model.comun.exception;

import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationException.
 */
public abstract class ApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8087365386472206724L;

	/**
	 * Instantiates a new application exception.
	 *
	 * @param message
	 *            the message
	 */
	ApplicationException(final String message) {
		super(message);
	}

	/**
	 * Gets the message.
	 *
	 * @param bundle
	 *            the bundle
	 * @return the message
	 */
	public abstract String getMessage(final ResourceBundle bundle);
}
