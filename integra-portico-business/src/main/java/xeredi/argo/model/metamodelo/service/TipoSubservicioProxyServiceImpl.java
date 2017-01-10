package xeredi.argo.model.metamodelo.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioProxyServiceImpl.
 */
public class TipoSubservicioProxyServiceImpl implements TipoSubservicioProxyService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoSubservicioProxyServiceImpl.class);

	/** The Constant MAP. */
	private static final Map<Long, TipoSubservicioDetailVO> MAP = new HashMap<>();

	/** The tpsr service. */
	@Inject
	private TipoSubservicioService tpssService;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoSubservicioDetailVO select(Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.tpss, id));
		}

		return MAP.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Long, TipoSubservicioDetailVO> selectMap() {
		if (MAP.isEmpty()) {
			load();
		}

		return MAP;
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("TipoSubservicio Load");

		for (final TipoSubservicioVO tpss : tpssService.selectList(new TipoSubservicioCriterioVO())) {
			if (tpss.getTpdtEstado() != null) {
				tpss.setTpdtEstado(TipoDatoProxy.select(tpss.getTpdtEstado().getId()));
			}

			final TipoSubservicioDetailVO tpssDetail = new TipoSubservicioDetailVO();

			tpssDetail.setEnti(tpss);

			MAP.put(tpssDetail.getEnti().getId(), tpssDetail);
		}

		entiProxy.fillDependencies(MAP);

		LOG.info("TipoSubservicio Load Success");
	}

}
