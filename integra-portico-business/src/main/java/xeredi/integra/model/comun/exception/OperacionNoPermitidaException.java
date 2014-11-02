package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class OperacionNoPermitidaException.
 */
public final class OperacionNoPermitidaException extends ModelException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1079106391938492752L;

	/**
	 * Instantiates a new operacion no permitida exception.
	 *
	 * @param aclassName
	 *            the aclass name
	 * @param aobjId
	 *            the aobj id
	 */
	public OperacionNoPermitidaException(final MessageI18nKey aclassName,
			final Object aobjId) {
		super("El estado del objeto no permite la ejecucion de esta operacion",
				aclassName, aobjId);
	}

	/**
	 * Instantiates a new operacion no permitida exception.
	 *
	 * @param aclassId
	 *            the aclass id
	 * @param aobjId
	 *            the aobj id
	 */
	public OperacionNoPermitidaException(final Long aclassId,
			final Object aobjId) {
		super("El estado del objeto no permite la ejecucion de esta operacion",
				aclassId, aobjId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage(Locale locale) {
		final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

		return MessageFormat.format(
				bundle.getString(MessageI18nKey.E00013.name()), new Object[] {
						bundle.getString(getClassName()), getObjId() });
	}

}
