package xeredi.argo.http.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

import xeredi.argo.model.util.ArgoGuiceModule;

// TODO: Auto-generated Javadoc
/**
 * The Class GuiceInjector.
 */
public final class ArgoGuiceInjector {

	/** The Constant injector. */
	private static final Injector injector = Guice.createInjector(new ArgoGuiceModule());

	/**
	 * Gets the injector.
	 *
	 * @return the injector
	 */
	public static Injector getInjector() {
		return injector;
	}
}
