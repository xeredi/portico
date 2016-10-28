package xeredi.argo.model.util;

import lombok.NonNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailUtil.
 */
public final class EmailUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EmailUtil.class);

	/** The Constant EMAIL_HOST. */
	private static final String EMAIL_HOST;

	/** The Constant EMAIL_PORT. */
	private static final Integer EMAIL_PORT;

	/** The Constant EMAIL_SSL. */
	private static final Boolean EMAIL_SSL;

	/** The Constant EMAIL_USER. */
	private static final String EMAIL_USER;

	/** The Constant EMAIL_PASSWORD. */
	private static final String EMAIL_PASSWORD;

	/** The Constant EMAIL_ACCOUNT. */
	private static final String EMAIL_ACCOUNT;

	static {
		LOG.info("Loading email configuration");

		EMAIL_HOST = ConfigurationProxy.getString(ConfigurationKey.email_host);
		EMAIL_PORT = ConfigurationProxy.getInt(ConfigurationKey.email_port);
		EMAIL_SSL = ConfigurationProxy.getBoolean(ConfigurationKey.email_ssl);
		EMAIL_USER = ConfigurationProxy.getString(ConfigurationKey.email_user);
		EMAIL_PASSWORD = ConfigurationProxy.getString(ConfigurationKey.email_password);
		EMAIL_ACCOUNT = ConfigurationProxy.getString(ConfigurationKey.email_account);
	}

	/**
	 * Instantiates a new email util.
	 */
	private EmailUtil() {
		super();
	}

	/**
	 * Send.
	 *
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param text
	 *            the text
	 * @throws ApplicationException
	 *             the application exception
	 */
	public static void send(final @NonNull String to, final @NonNull String subject, final @NonNull String text)
			throws ApplicationException {
		Preconditions.checkNotNull(EMAIL_HOST);
		Preconditions.checkNotNull(EMAIL_PORT);
		Preconditions.checkNotNull(EMAIL_SSL);
		Preconditions.checkNotNull(EMAIL_USER);
		Preconditions.checkNotNull(EMAIL_PASSWORD);
		Preconditions.checkNotNull(EMAIL_ACCOUNT);

		try {
			final Email email = new SimpleEmail();

			email.setHostName(EMAIL_HOST);
			email.setSmtpPort(EMAIL_PORT);
			email.setAuthenticator(new DefaultAuthenticator(EMAIL_USER, EMAIL_PASSWORD));
			email.setSSLOnConnect(EMAIL_SSL);
			email.setFrom(EMAIL_ACCOUNT);
			email.setSubject(subject);
			email.setMsg(text);
			email.addTo(to);
			email.send();
		} catch (final EmailException ex) {
			throw new InternalErrorException(ex);
		}
	}
}
