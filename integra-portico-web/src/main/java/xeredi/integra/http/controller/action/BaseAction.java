package xeredi.integra.http.controller.action;

import java.text.MessageFormat;
import java.util.List;
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
import xeredi.integra.model.comun.vo.MessageI18nBundlename;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("json-default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "false" })
@InterceptorRefs({ @InterceptorRef(value = "timer"), @InterceptorRef(value = "json"), @InterceptorRef("basicStack") })
public class BaseAction extends ActionSupport implements SessionAware {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 473290129182463314L;

    /** The Constant LOG. */
    protected static final Log LOG = LogFactory.getLog(BaseAction.class);

    /** The session. */
    private Map<String, Object> session;

    /** The bundle. */
    private final ResourceBundle bundle = PorticoResourceBundle.getBundle(MessageI18nBundlename.app, getLocale());

    // get / set
    /**
     * Gets the idioma.
     *
     * @return the idioma
     */
    public final String getIdioma() {
        return ConfigurationProxy.getConfiguration().getString(ConfigurationKey.LANGUAGE_DEFAULT.getKey());
    }

    /**
     * Gets the available languages.
     *
     * @return the available languages
     */
    public final String[] getAvailableLanguages() {
        return ConfigurationProxy.getConfiguration().getStringArray(ConfigurationKey.LANGUAGE_AVAILABLE.getKey());
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
     * {@inheritDoc}
     */
    @Override
    public String getText(final String aTextName) {
        return bundle.getString(aTextName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String key, final String[] args) {
        return MessageFormat.format(bundle.getString(key), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String aTextName, final String defaultValue) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String aTextName, final String defaultValue, final String obj) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String aTextName, final List<?> args) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String aTextName, final String defaultValue, final List<?> args) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String key, final String defaultValue, final String[] args) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String key, final String defaultValue, final List<?> args, final ValueStack stack) {
        throw new Error("No implementado!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(final String key, final String defaultValue, final String[] args, final ValueStack stack) {
        throw new Error("No implementado!");
    }

}
