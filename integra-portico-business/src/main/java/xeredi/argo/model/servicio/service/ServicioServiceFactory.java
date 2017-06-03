package xeredi.argo.model.servicio.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Injector;

import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ParametroService objects.
 */
@Singleton
public class ServicioServiceFactory {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ServicioServiceFactory.class);

	/** The Constant MAP. */
	private static final Map<Long, Class<? extends ServicioService>> MAP = new HashMap<Long, Class<? extends ServicioService>>();

	/** The injector. */
	private final Injector injector;

	/** The enti service. */
	private final TipoServicioService entiService;

	/**
	 * Instantiates a new servicio service factory.
	 *
	 * @param injector
	 *            the injector
	 * @param entiService
	 *            the enti service
	 */
	@Inject
	public ServicioServiceFactory(final Injector injector, final TipoServicioService entiService) {
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
	public ServicioService getInstance(final Long entiId) {
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
	public ServicioService getGenericInstance() {
		return injector.getInstance(ServicioService.class);
	}

	/**
	 * Inits the.
	 */
	private void init() {
		LOG.info("ServicioServiceFactory init");

		try {
			for (final TipoServicioVO enti : entiService.selectList(new TipoServicioCriterioVO())) {
				MAP.put(enti.getId(), enti.getClasspath() == null ? ServicioService.class
						: (Class<? extends ServicioService>) Class.forName(enti.getClasspath()));
			}
		} catch (final ClassNotFoundException ex) {
			LOG.fatal(ex, ex);

			throw new Error(ex);
		}

		LOG.info("ServicioServiceFactory init ok");
	}
}
