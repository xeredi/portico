package xeredi.argo.model.metamodelo.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoProxyService.
 */
public class TipoDatoProxyService {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoDatoProxyService.class);

	/** The Constant TIPO_DATO_MAP. */
	private static final Map<Long, TipoDatoVO> MAP = new HashMap<>();

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo dato VO
	 */
	public TipoDatoVO select(@NonNull final Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.tpdt, id));
		}

		return MAP.get(id);
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("DataType Load");

		MAP.putAll(tpdtService.selectMap(new TipoDatoCriterioVO()));

		LOG.info("DataType Load Success");
	}

}
