package xeredi.argo.model.comun.report;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.inject.Injector;

import xeredi.argo.model.comun.service.ResourceBundleService;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating PdfService objects.
 */
@Singleton
public class PdfServiceFactory {

	/** The injector. */
	private final Injector injector;

	/** The bundle service. */
	private final ResourceBundleService bundleService;

	/**
	 * Instantiates a new pdf service factory.
	 *
	 * @param injector
	 *            the injector
	 * @param bundleService
	 *            the bundle service
	 */
	@Inject
	private PdfServiceFactory(final Injector injector, final ResourceBundleService bundleService) {
		super();
		this.injector = injector;
		this.bundleService = bundleService;
	}

	/**
	 * Gets the single instance of PdfServiceFactory.
	 *
	 * @param <T>
	 *            the generic type
	 * @param pdfClass
	 *            the pdf class
	 * @param locale
	 *            the locale
	 * @return single instance of PdfServiceFactory
	 */
	public <T extends BasePdf> T getInstance(final Class<? extends BasePdf> pdfClass, final Locale locale) {
		final T pdfInstance = (T) injector.getInstance(pdfClass);

		pdfInstance.setLocale(locale);
		pdfInstance.setBundle(ResourceBundle.getBundle("argo", locale, bundleService));

		return pdfInstance;
	}

}
