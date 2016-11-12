package xeredi.argo.http.controller.action.comun;

import java.text.MessageFormat;
import java.util.ResourceBundle;

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
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;

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

    /** The bundle. */
    private final ResourceBundle bundle = PorticoResourceBundle.getBundle(getLocale());

    /** The idioma. */
    @Getter
    protected final String idioma = ConfigurationProxy.getString(ConfigurationKey.language_default);

    /** The available languages. */
    @Getter
    protected final String[] availableLanguages = ConfigurationProxy
            .getStringArray(ConfigurationKey.language_available);

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

    @Getter
    protected Long sprtId;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        try {
            usroId = SessionManager.getUsroId();
            sprtId = SessionManager.getSprtId();

            doExecute();
        } catch (final ApplicationException ex) {
            LOG.error(ex, ex);

            addActionError(ex.getMessage(getLocale()));
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);

            addActionError(MessageI18nKey.E00000, ex.getMessage());
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
    public final void addActionError(final @NonNull MessageI18nKey key) {
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
    public final void addActionError(final @NonNull MessageI18nKey key, final Object... args) {
        addActionError(MessageFormat.format(bundle.getString(key.name()), args));
    }

    /**
     * Gets the text.
     *
     * @param key
     *            the key
     * @return the text
     */
    public final String getText(final @NonNull MessageI18nKey key) {
        return bundle.getString(key.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getText(final String key) {
        return bundle.getString(key);
    }
}
