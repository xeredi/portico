package xeredi.argo.model.comun.service;

import java.util.ListResourceBundle;
import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class ArgoResourceBundle.
 */
public final class ArgoResourceBundle extends ListResourceBundle {

    /** The locale. */
    private final Locale locale;

    /** The contents. */
    private final Object[][] contents;

	/**
	 * Instantiates a new argo resource bundle.
	 *
	 * @param alocale the alocale
	 * @param acontents the acontents
	 */
	public ArgoResourceBundle(Locale alocale, Object[][] acontents) {
		super();
		this.locale = alocale;
		this.contents = acontents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object[][] getContents() {
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	public Locale getLocale() {
		return locale;
	}
}
