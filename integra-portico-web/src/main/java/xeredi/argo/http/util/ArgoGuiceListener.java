package xeredi.argo.http.util;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;

import xeredi.argo.model.util.ArgoGuiceModule;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving argoGuice events. The class that is
 * interested in processing a argoGuice event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's addArgoGuiceListener method. When the argoGuice event occurs,
 * that object's appropriate method is invoked.
 */
public final class ArgoGuiceListener extends GuiceServletContextListener {

	/** The Constant injector. */
	private static final Injector injector = Guice.createInjector(new Struts2GuicePluginModule(), new ServletModule() {
		@Override
		protected void configureServlets() {
			// Struts 2 setup
			bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
			filter("/*").through(StrutsPrepareAndExecuteFilter.class);
		}
	}, new ArgoGuiceModule());

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Injector getInjector() {
		return injector;
	}
}
