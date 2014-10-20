package xeredi.integra.http.controller.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("json-default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "true" })
@InterceptorRefs({ @InterceptorRef(value = "timer"), @InterceptorRef(value = "json"), @InterceptorRef("basicStack") })
public class BaseAction extends ActionSupport implements SessionAware {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 473290129182463314L;

    /** The Constant LOG. */
    protected static final Log LOG = LogFactory.getLog(BaseAction.class);

    /** The Constant ACTION_MESSAGES. */
    private static final String ACTION_MESSAGES = "actionMessages";

    /** The session. */
    private Map<String, Object> session;

    // get / set

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public final void addActionMessage(final String value) {
        super.addActionMessage(value);

        if (!session.containsKey(ACTION_MESSAGES)) {
            session.put(ACTION_MESSAGES, new ArrayList<String>());
        }

        ((List<String>) session.get(ACTION_MESSAGES)).add(value);
    }

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

}
