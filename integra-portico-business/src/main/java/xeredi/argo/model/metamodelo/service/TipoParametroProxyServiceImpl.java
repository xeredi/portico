package xeredi.argo.model.metamodelo.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroProxyServiceImpl.
 */
public class TipoParametroProxyServiceImpl implements TipoParametroProxyService {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoParametroProxyServiceImpl.class);

	/** The Constant MAP. */
	private static final Map<Long, TipoParametroDetailVO> MAP = new HashMap<>();

	/** The tpsr service. */
	@Inject
	private TipoParametroService tpprService;

	/** The tpsp service. */
	@Inject
	private TipoSubparametroService tpspService;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoParametroDetailVO select(Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.tppr, id));
		}

		return MAP.get(id);
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("TipoParametro Load");

		for (final TipoParametroVO tppr : tpprService.selectList(new TipoParametroCriterioVO())) {
			final TipoParametroDetailVO tpprDetail = new TipoParametroDetailVO();

			tpprDetail.setEnti(tppr);

			MAP.put(tpprDetail.getEnti().getId(), tpprDetail);
		}

		entiProxy.fillDependencies(MAP);

		for (final TipoSubparametroVO tpsp : tpspService.selectList(new TipoSubparametroCriterioVO())) {
			MAP.get(tpsp.getTpprId()).getSubentiList().add(tpsp);
		}

		LOG.info("TipoParametro Load Success");
	}
}
