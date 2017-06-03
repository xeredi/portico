package xeredi.argo.http.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.inject.Singleton;
import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;

import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.service.ResourceBundleService;
import xeredi.argo.model.comun.vo.ConfigurationKey;
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

	private static final Log LOG = LogFactory.getLog(ArgoGuiceListener.class);

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
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		super.contextInitialized(servletContextEvent);

		LOG.info("Context Initialized");

		try {
			i18nExport();
		} catch (final IOException ex) {
			LOG.fatal(ex.getMessage(), ex);

			throw new Error(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Injector getInjector() {
		return injector;
	}

	/**
	 * I 18 n export.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void i18nExport() throws IOException {
		LOG.info("I18n Export");

		final ConfigurationProxyService confService = injector.getInstance(ConfigurationProxyService.class);
		final ResourceBundleService rbService = injector.getInstance(ResourceBundleService.class);

		final String[] languages = confService.getStringArray(ConfigurationKey.language_available);
		final String defaultLanguage = confService.getString(ConfigurationKey.language_default);
		final String webappInstallPath = confService.getString(ConfigurationKey.webapp_install_path);

		for (final String language : languages) {
			LOG.info("Language: " + language);

			final Object[][] contents = rbService.loadBundleContents("argo", new Locale(language));

			// JSON Export
			final StringBuffer jsonContent = new StringBuffer();

			jsonContent.append('{');

			for (int i = 0; i < contents.length; i++) {
				jsonContent.append("\"" + contents[i][0] + "\":\"" + contents[i][1] + "\"");

				if (i < (contents.length - 1)) {
					jsonContent.append(',');
				}
			}

			jsonContent.append('}');

			final String jsonFilename = "/home/xeredi/git/portico/argo-front-ng2/src/assets/i18n" + "/" + language
					+ ".json";

			LOG.info("Filename: " + jsonFilename);

			try (final PrintWriter printWriter = new PrintWriter(jsonFilename, "UTF-8")) {
				printWriter.print(jsonContent);
			}

			// JS Export
			final StringBuffer jsContent = new StringBuffer();

			jsContent.append("angular.module('argo.i18n', [ 'pascalprecht.translate' ])"
					+ ".config(function($translateProvider) { $translateProvider.translations('" + language + "', {");

			for (int i = 0; i < contents.length; i++) {
				jsContent.append(contents[i][0] + ":'" + contents[i][1] + "'");

				if (i < (contents.length - 1)) {
					jsContent.append(',');
				}
			}

			jsContent.append("}); $translateProvider.preferredLanguage('" + defaultLanguage + "'); });");

			final String jsFilename = webappInstallPath + "/modules/i18n/i18n_messages_" + language + ".js";

			LOG.info("Filename: " + jsFilename);

			try (final PrintWriter printWriter = new PrintWriter(jsFilename, "UTF-8")) {
				printWriter.print(jsContent);
			}
		}

		LOG.info("I18n export success");
	}
}
