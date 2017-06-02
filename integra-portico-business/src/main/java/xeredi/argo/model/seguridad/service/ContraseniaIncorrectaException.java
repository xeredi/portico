package xeredi.argo.model.seguridad.service;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;

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
	public String getMessage(final @NonNull ResourceBundle bundle) {
		return MessageFormat.format(bundle.getString(MessageI18nKey.E00014.name()),
				new Object[] { bundle.getString(getClassName()), getObjId() });
	}

}
