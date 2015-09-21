package xeredi.argo.model.seguridad.bo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ContraseniaIncorrectaException.
 */
public final class ContraseniaIncorrectaException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8490507121300456092L;

    /**
     * Instantiates a new contrasenia incorrecta exception.
     *
     * @param login
     *            the login
     */
    public ContraseniaIncorrectaException(final String login) {
        super("Contraseña Incorrecta", MessageI18nKey.usro, login);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        Preconditions.checkNotNull(locale);

        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00014.name()),
                new Object[] { bundle.getString(getClassName()), getObjId() });
    }

}
