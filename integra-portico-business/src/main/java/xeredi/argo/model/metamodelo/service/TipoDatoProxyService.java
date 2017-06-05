package xeredi.argo.model.metamodelo.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoProxyService.
 */
@Singleton
public class TipoDatoProxyService {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoDatoProxyService.class);

	/** The Constant TIPO_DATO_MAP. */
	private final Map<Long, TipoDatoVO> MAP = new HashMap<>();

	/** The tpdt service. */
	private final TipoDatoService tpdtService;

	/**
	 * Instantiates a new tipo dato proxy service.
	 *
	 * @param tpdtService the tpdt service
	 */
	@Inject
	private TipoDatoProxyService(TipoDatoService tpdtService) {
		super();
		this.tpdtService = tpdtService;
	}

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
