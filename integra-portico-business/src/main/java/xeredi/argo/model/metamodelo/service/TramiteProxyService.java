package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteProxyServiceImpl.
 */
public class TramiteProxyService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TramiteProxyService.class);

	/** The Constant MAP. */
	private static final Map<Long, TramiteDetailVO> MAP = new HashMap<>();

	/** The trmt service. */
	@Inject
	private TramiteService trmtService;

	/** The trtd service. */
	@Inject
	private TramiteTipoDatoService trtdService;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tramite detail VO
	 */
	public TramiteDetailVO select(@NonNull final Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.trmt, id));
		}

		return MAP.get(id);
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("Tramite Load");

		for (final TramiteVO trmt : trmtService.selectList(new TramiteCriterioVO())) {
			final TramiteDetailVO trmtDetail = new TramiteDetailVO();

			trmtDetail.setTrmt(trmt);
			trmtDetail.setTpdtList(new ArrayList<>());
			trmtDetail.setTrtdMap(new HashMap<>());

			MAP.put(trmt.getId(), trmtDetail);
		}

		for (final TramiteTipoDatoVO trtd : trtdService.selectList(new TramiteTipoDatoCriterioVO())) {
			MAP.get(trtd.getTrmtId()).getTpdtList().add(trtd.getEntd().getTpdt().getId());
			MAP.get(trtd.getTrmtId()).getTrtdMap().put(trtd.getEntd().getTpdt().getId(), trtd);
		}

		LOG.info("Tramite Load Success");
	}

}
