package xeredi.argo.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroProxy.
 */
public final class TipoSubparametroProxy {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TipoSubparametroProxy.class);

	/** The Constant LABEL_VALUE_LIST. */
	private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

	/** The Constant TIPO_SUBPARAMETRO_MAP. */
	private static final Map<Long, TipoSubparametroDetailVO> TIPO_SUBPARAMETRO_MAP = new HashMap<>();

	static {
		load();
	}

	/**
	 * Instantiates a new tipo subparametro proxy.
	 */
	private TipoSubparametroProxy() {
		super();
	}

	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	public static List<LabelValueVO> selectLabelValues() {
		return LABEL_VALUE_LIST;
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo subparametro vo
	 */
	public static TipoSubparametroDetailVO select(@NonNull final Long id) {
		if (!TIPO_SUBPARAMETRO_MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.tpsp, id));
		}

		return TIPO_SUBPARAMETRO_MAP.get(id);
	}

	/**
	 * Load.
	 */
	static synchronized void load() {
		LOG.info("Carga de tipos de subparametro");

		final TipoSubparametroBO tpspBO = new TipoSubparametroBO();
		final List<TipoSubparametroVO> tpspList = tpspBO.selectList(new TipoSubparametroCriterioVO());

		for (final TipoSubparametroVO tpsp : tpspList) {
			final TipoSubparametroDetailVO tpspDetail = new TipoSubparametroDetailVO();

			tpspDetail.setEnti(tpsp);

			// if (tpspVO.getTpprAsociado() != null) {
			// tpspVO.setTpprAsociado(TipoParametroProxy.select(tpspVO.getTpprAsociado().getId()));
			// }

			TIPO_SUBPARAMETRO_MAP.put(tpspDetail.getEnti().getId(), tpspDetail);
		}

		EntidadProxy.loadDependencies(TIPO_SUBPARAMETRO_MAP);

		LABEL_VALUE_LIST.addAll(tpspBO.selectLabelValues());

		LOG.info("Carga de tipos de subparametro OK");
	}

}
