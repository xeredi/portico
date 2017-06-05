package xeredi.argo.model.servicio.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Injector;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SubservicioService objects.
 */
@Singleton
public class SubservicioServiceFactory {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SubservicioServiceFactory.class);

	/** The Constant MAP. */
	private final Map<Long, Class<? extends SubservicioService>> MAP = new HashMap<Long, Class<? extends SubservicioService>>();

	/** The injector. */
	private final Injector injector;

	/** The enti service. */
	private final TipoSubservicioService entiService;

	/**
	 * Instantiates a new subservicio service factory.
	 *
	 * @param injector
	 *            the injector
	 * @param entiService
	 *            the enti service
	 */
	@Inject
	private SubservicioServiceFactory(final Injector injector, final TipoSubservicioService entiService) {
		super();
		this.injector = injector;
		this.entiService = entiService;
	}

	/**
	 * Gets the single instance of SubservicioServiceFactory.
	 *
	 * @param <T>
	 *            the generic type
	 * @param entiId
	 *            the enti id
	 * @param usroId
	 *            the usro id
	 * @return single instance of SubservicioServiceFactory
	 */
	public <T extends SubservicioService> T getInstance(final @NonNull Long entiId, final @NonNull Long usroId) {
		if (MAP.isEmpty()) {
			init();
		}

		if (!MAP.containsKey(entiId)) {
			final String errorMessage = "entiId not found: " + entiId;

			LOG.fatal(errorMessage);

			throw new Error(errorMessage);
		}

		final SubservicioService ssrvService = injector.getInstance(MAP.get(entiId));

		ssrvService.setEntiId(entiId);
		ssrvService.setUsroId(usroId);

		return (T) ssrvService;
	}

	/**
	 * Gets the generic instance.
	 *
	 * @return the generic instance
	 */
	public SubservicioService getGenericInstance() {
		return injector.getInstance(SubservicioService.class);
	}

	/**
	 * Inits the.
	 */
	private void init() {
		LOG.info("SubservicioServiceFactory init");

		try {
			for (final TipoSubservicioVO enti : entiService.selectList(new TipoSubservicioCriterioVO())) {
				MAP.put(enti.getId(), enti.getClasspath() == null ? SubservicioService.class
						: (Class<? extends SubservicioService>) Class.forName(enti.getClasspath()));
			}
		} catch (final ClassNotFoundException ex) {
			LOG.fatal(ex, ex);

			throw new Error(ex);
		}

		LOG.info("SubservicioServiceFactory init ok");
	}

}
