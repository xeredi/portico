package xeredi.argo.http.controller.action.comun;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "true" })
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

    /** The idioma. */
    protected final String idioma = ConfigurationProxy.getString(ConfigurationKey.language_default);

    /** The available languages. */
    protected final String[] availableLanguages = ConfigurationProxy
            .getStringArray(ConfigurationKey.language_available);

    /** The bundle. */
    private final ResourceBundle bundle = PorticoResourceBundle.getBundle(getLocale());

    /** The response code. */
    private String responseCode;

    /** The acciones usuario. */
    private Set<String> accionesUsuario;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        try {
            doExecute();
        } catch (final ApplicationException ex) {
            throw ex;
        } catch (final Throwable ex) {
            throw new InternalErrorException(ex);
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

    // get / set
    /**
     * Gets the idioma.
     *
     * @return the idioma
     */
    public final String getIdioma() {
        return idioma;
    }

    /**
     * Gets the sprt id.
     *
     * @return the sprt id
     */
    public final Long getSprtId() {
        // FIXME !!!
        return 36000L;
    }

    /**
     * Gets the available languages.
     *
     * @return the available languages
     */
    public final String[] getAvailableLanguages() {
        return availableLanguages;
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
     * Gets the response code.
     *
     * @return the response code
     */
    public final String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code.
     *
     * @param value
     *            the new response code
     */
    public final void setResponseCode(final String value) {
        responseCode = value;
    }

    /**
     * Gets the acciones usuario.
     *
     * @return the acciones usuario
     */
    public final Set<String> getAccionesUsuario() {
        return accionesUsuario;
    }

    /**
     * Sets the acciones usuario.
     *
     * @param value the new acciones usuario
     */
    public final void setAccionesUsuario(final Set<String> value) {
        this.accionesUsuario = value;
    }
}
