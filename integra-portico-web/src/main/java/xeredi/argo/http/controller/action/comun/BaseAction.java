package xeredi.argo.http.controller.action.comun;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.service.ResourceBundleService;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "true" })
// @InterceptorRef("timer")
public abstract class BaseAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 473290129182463314L;

	/** The Constant LOG. */
	protected static final Log LOG = LogFactory.getLog(BaseAction.class);

	/**
	 * The Enum ACCION_EDICION.
	 */
	public static enum ACCION_EDICION {
		/** The alta. */
		create,
		/** The modificar. */
		edit,
		/** The duplicar. */
		duplicate,
		/** The duplicate_version. */
		duplicate_version,
		/** The load. */
		load;
	}

	/** the prefix. */
	@Getter
	protected ClassPrefix prefix;

	/** The response code. */
	@Getter
	@Setter
	protected String responseCode;

	/** the usro id. */
	@Getter
	protected Long usroId;

	/** the sprt id. */
	@Getter
	protected Long sprtId;

	/** The conf proxy service. */
	@Inject
	protected ConfigurationProxyService confProxyService;

	/** The rb service. */
	@Inject
	protected ResourceBundleService rbService;

	/**
	 * Gets the idioma.
	 *
	 * @return the idioma
	 */
	public String getIdioma() {
		return confProxyService.getString(ConfigurationKey.language_default);
	}

	/**
	 * Gets the available languages.
	 *
	 * @return the available languages
	 */
	public String[] getAvailableLanguages() {
		return confProxyService.getStringArray(ConfigurationKey.language_available);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String execute() {
		final long startMs = Calendar.getInstance().getTimeInMillis();

		try {
			usroId = SessionManager.getUsroId();
			sprtId = SessionManager.getSprtId();

			doExecute();
		} catch (final ApplicationException ex) {
			LOG.info(ex);

			addActionError(ex.getMessage(getBundle()));
		} catch (final Throwable ex) {
			LOG.fatal(ex, ex);

			addActionError(MessageI18nKey.E00000, ex.getMessage());
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug(getClass().getName() + ": " + (Calendar.getInstance().getTimeInMillis() - startMs) + " mseg.");
		}

		return SUCCESS;
	}

	/**
	 * Do execute.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doExecute() throws ApplicationException;

	/**
	 * Adds the action error.
	 *
	 * @param key
	 *            the key
	 */
	public final void addActionError(@NonNull final MessageI18nKey key) {
		addActionError(getBundle().getString(key.name()));
	}

	/**
	 * Adds the action error.
	 *
	 * @param key
	 *            the key
	 * @param args
	 *            the args
	 */
	public final void addActionError(@NonNull final MessageI18nKey key, final Object... args) {
		addActionError(MessageFormat.format(getBundle().getString(key.name()), args));
	}

	/**
	 * Gets the text.
	 *
	 * @param key
	 *            the key
	 * @return the text
	 */
	public final String getText(@NonNull final MessageI18nKey key) {
		return getBundle().getString(key.name());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getText(final String key) {
		return getBundle().getString(key);
	}

	/**
	 * Gets the bundle.
	 *
	 * @return the bundle
	 */
	protected ResourceBundle getBundle() {
		return ResourceBundle.getBundle("argo", getLocale(), rbService);
	}

	public ResourceBundle getBundle(final Locale locale) {
		return ResourceBundle.getBundle("argo", locale, rbService);
	}

}
