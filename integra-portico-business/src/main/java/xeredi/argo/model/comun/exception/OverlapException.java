package xeredi.argo.model.comun.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class OverlapException.
 */
public final class OverlapException extends ModelException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2765874878516074151L;

	/**
	 * Instantiates a new overlap exception.
	 *
	 * @param aclassName
	 *            the aclass name
	 * @param aobjId
	 *            the aobj id
	 */
	public OverlapException(final MessageI18nKey aclassName, final Object aobjId) {
		super("Overlap", aclassName, aobjId);
	}

	/**
	 * Instantiates a new overlap exception.
	 *
	 * @param aclassId
	 *            the aclass id
	 * @param aobjId
	 *            the aobj id
	 */
	public OverlapException(final Long aclassId, final Object aobjId) {
		super("Overlap", aclassId, aobjId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage(final @NonNull ResourceBundle bundle) {
		return MessageFormat.format(bundle.getString(MessageI18nKey.E00009.name()),
				new Object[] { bundle.getString(getClassName()), getObjId() });
	}

}
