package xeredi.argo.model.util;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.vo.ConfigurationKey;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailUtil.
 */
public class EmailUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EmailUtil.class);

	/** The conf proxy. */
	@Inject
	private ConfigurationProxyService confProxy;

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
	public void send(@NonNull final String to, @NonNull final String subject, @NonNull final String text)
			throws ApplicationException {
		try {
			final Email email = new SimpleEmail();

			email.setHostName(confProxy.getString(ConfigurationKey.email_host));
			email.setSmtpPort(confProxy.getInt(ConfigurationKey.email_port));
			email.setAuthenticator(new DefaultAuthenticator(confProxy.getString(ConfigurationKey.email_user),
					confProxy.getString(ConfigurationKey.email_password)));
			email.setSSLOnConnect(confProxy.getBoolean(ConfigurationKey.email_ssl));
			email.setFrom(confProxy.getString(ConfigurationKey.email_account));
			email.setSubject(subject);
			email.setMsg(text);
			email.addTo(to);
			email.send();
		} catch (final EmailException ex) {
			throw new InternalErrorException(ex);
		}
	}
}
