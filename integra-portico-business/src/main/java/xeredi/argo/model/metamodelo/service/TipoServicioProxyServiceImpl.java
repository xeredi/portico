package xeredi.argo.model.metamodelo.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioProxyServiceImpl.
 */
public class TipoServicioProxyServiceImpl implements TipoServicioProxyService {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoServicioProxyServiceImpl.class);

	/** The Constant TIPO_SERVICIO_MAP. */
	private static final Map<Long, TipoServicioDetailVO> MAP = new HashMap<>();

	/** The tpsr service. */
	@Inject
	private TipoServicioService tpsrService;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoServicioDetailVO select(Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.tpsr, id));
		}

		return MAP.get(id);
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("TipoServicio Load");

		for (final TipoServicioVO tpsr : tpsrService.selectList(new TipoServicioCriterioVO())) {
			if (tpsr.getTpdtEstado() != null) {
				tpsr.setTpdtEstado(TipoDatoProxy.select(tpsr.getTpdtEstado().getId()));
			}

			final TipoServicioDetailVO tpsrDetail = new TipoServicioDetailVO();

			tpsrDetail.setEnti(tpsr);

			MAP.put(tpsrDetail.getEnti().getId(), tpsrDetail);
		}

		entiProxy.fillDependencies(MAP);

		LOG.info("TipoServicio Load Success");
	}

}
