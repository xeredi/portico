package xeredi.argo.model.maestro.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Injector;

import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ParametroService objects.
 */
@Singleton
public class ParametroServiceFactory {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ParametroServiceFactory.class);

	/** The Constant MAP. */
	private static final Map<Long, Class<? extends ParametroService>> MAP = new HashMap<Long, Class<? extends ParametroService>>();

	/** The injector. */
	private final Injector injector;

	/** The enti service. */
	private final TipoParametroService entiService;

	/**
	 * Instantiates a new parametro service factory.
	 *
	 * @param injector
	 *            the injector
	 * @param entiService
	 *            the enti service
	 */
	@Inject
	public ParametroServiceFactory(final Injector injector, final TipoParametroService entiService) {
		super();
		this.injector = injector;
		this.entiService = entiService;
	}

	/**
	 * Gets the single instance of ParametroServiceFactory.
	 *
	 * @param entiId
	 *            the enti id
	 * @return single instance of ParametroServiceFactory
	 */
	public ParametroService getInstance(final Long entiId) {
		if (MAP.isEmpty()) {
			init();
		}

		if (!MAP.containsKey(entiId)) {
			final String errorMessage = "entiId not found: " + entiId;

			LOG.fatal(errorMessage);

			throw new Error(errorMessage);
		}

		return injector.getInstance(MAP.get(entiId));
	}

	/**
	 * Gets the generic instance.
	 *
	 * @return the generic instance
	 */
	public ParametroService getGenericInstance() {
		return injector.getInstance(ParametroService.class);
	}

	/**
	 * Inits the.
	 */
	private void init() {
		LOG.info("ParametroServiceFactory init");

		try {
			for (final TipoParametroVO enti : entiService.selectList(new TipoParametroCriterioVO())) {
				MAP.put(enti.getId(), enti.getClasspath() == null ? ParametroService.class
						: (Class<? extends ParametroService>) Class.forName(enti.getClasspath()));
			}
		} catch (final ClassNotFoundException ex) {
			LOG.fatal(ex, ex);

			throw new Error(ex);
		}

		LOG.info("ParametroServiceFactory init ok");
	}
}
