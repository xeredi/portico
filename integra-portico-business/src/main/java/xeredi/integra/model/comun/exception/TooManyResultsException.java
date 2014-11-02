package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class TooManyResultsException.
 */
public final class TooManyResultsException extends ModelException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6231679936855397650L;

	/** The max results. */
	private final int maxResults;

	/**
	 * Instantiates a new too many results exception.
	 *
	 * @param aclassName
	 *            the aclass name
	 * @param aobjId
	 *            the aobj id
	 * @param amaxResults
	 *            the amax results
	 */
	public TooManyResultsException(final MessageI18nKey aclassName,
			final Object aobjId, final int amaxResults) {
		super("TooManyResults", aclassName, aobjId);

		maxResults = amaxResults;
	}

	/**
	 * Instantiates a new too many results exception.
	 *
	 * @param aclassId
	 *            the aclass id
	 * @param aobjId
	 *            the aobj id
	 * @param amaxResults
	 *            the amax results
	 */
	public TooManyResultsException(final Long aclassId, final Object aobjId,
			final int amaxResults) {
		super("TooManyResults", aclassId, aobjId);

		maxResults = amaxResults;
	}

	/**
	 * Gets the max results.
	 *
	 * @return the max results
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage(Locale locale) {
		throw new Error("No implementado");
	}

}
