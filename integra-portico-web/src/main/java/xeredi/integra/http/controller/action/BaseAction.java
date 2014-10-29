package xeredi.integra.http.controller.action;

import java.text.MessageFormat;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
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
@ParentPackage("json-default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "false" })
@InterceptorRefs({ @InterceptorRef(value = "timer"), @InterceptorRef(value = "json"), @InterceptorRef("basicStack") })
public abstract class BaseAction extends ActionSupport implements SessionAware {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 473290129182463314L;

    /** The Constant LOG. */
    protected static final Log LOG = LogFactory.getLog(BaseAction.class);

    /** The session. */
    private Map<String, Object> session;

    /** The bundle. */
    private final ResourceBundle bundle = PorticoResourceBundle.getBundle(getLocale());

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
    public final void addActionError(final MessageI18nKey key, final String... args) {
        addActionError(MessageFormat.format(bundle.getString(key.name()), args));
    }

    /**
     * {@inheritDoc}
     */
    public final String getText(final MessageI18nKey key) {
        return bundle.getString(key.name());
    }

}
