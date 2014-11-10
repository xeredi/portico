package xeredi.integra.http.controller.action;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "false" })
public abstract class BaseAction extends ActionSupport implements SessionAware {

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
        duplicate;
    }

    /** The session. */
    private Map<String, Object> session;

    /** The bundle. */
    private final ResourceBundle bundle = PorticoResourceBundle.getBundle(getLocale());

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // get / set
    /**
     * Gets the idioma.
     *
     * @return the idioma
     */
    public final String getIdioma() {
        return ConfigurationProxy.getString(ConfigurationKey.language_default);
    }

    /**
     * Gets the available languages.
     *
     * @return the available languages
     */
    public final String[] getAvailableLanguages() {
        return ConfigurationProxy.getStringArray(ConfigurationKey.language_available);
    }

    /**
     * Gets the session.
     *
     * @return the session
     */
    public final Map<String, Object> getSession() {
        return session;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setSession(final Map<String, Object> value) {
        session = value;
    }

    /**
     * Adds the action error.
     *
     * @param key
     *            the key
     */
    public final void addActionError(final MessageI18nKey key) {
        addActionError(bundle.getString(key.name()));
    }

    /**
     * Adds the action error.
     *
     * @param key
     *            the key
     * @param args
     *            the args
     */
    public final void addActionError(final MessageI18nKey key, final Object... args) {
        addActionError(MessageFormat.format(bundle.getString(key.name()), args));
    }

    /**
     * Gets the text.
     *
     * @param key
     *            the key
     * @return the text
     */
    public final String getText(final MessageI18nKey key) {
        return bundle.getString(key.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getText(final String key) {
        return bundle.getString(key);
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

}
