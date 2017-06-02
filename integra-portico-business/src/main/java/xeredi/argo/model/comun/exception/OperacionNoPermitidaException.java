package xeredi.argo.model.comun.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class OperacionNoPermitidaException.
 */
public final class OperacionNoPermitidaException extends ModelException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1079106391938492752L;

	/** The operacion. */
	private final MessageI18nKey operacion;

	/**
	 * Instantiates a new operacion no permitida exception.
	 *
	 * @param aclassName
	 *            the aclass name
	 * @param aoperacion
	 *            the operacion
	 * @param aobjId
	 *            the aobj id
	 */
	public OperacionNoPermitidaException(final MessageI18nKey aclassName, final MessageI18nKey aoperacion,
			final Object aobjId) {
		super("No se puede realizar la operacion " + aoperacion.name(), aclassName, aobjId);

		this.operacion = aoperacion;
	}

	/**
	 * Instantiates a new operacion no permitida exception.
	 *
	 * @param aclassId
	 *            the aclass id
	 * @param aoperacion
	 *            the operacion
	 * @param aobjId
	 *            the aobj id
	 */
	public OperacionNoPermitidaException(final Long aclassId, final MessageI18nKey aoperacion, final Object aobjId) {
		super("No se puede realizar la operacion " + aoperacion.name(), aclassId, aobjId);

		this.operacion = aoperacion;
	}

	/**
	 * Gets the operacion.
	 *
	 * @return the operacion
	 */
	public MessageI18nKey getOperacion() {
		return operacion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage(final @NonNull ResourceBundle bundle) {
		return MessageFormat.format(bundle.getString(MessageI18nKey.E00013.name()),
				new Object[] { bundle.getString(operacion.name()), bundle.getString(getClassName()), getObjId() });
	}

}
