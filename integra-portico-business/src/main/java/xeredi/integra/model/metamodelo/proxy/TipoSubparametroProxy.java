package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
    private static final Map<Long, TipoSubparametroVO> TIPO_SUBPARAMETRO_MAP = new HashMap<>();

    static {
        load();
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
     * Select map.
     *
     * @return the map
     */
    public static Map<Long, TipoSubparametroVO> selectMap() {
        return TIPO_SUBPARAMETRO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo subparametro vo
     */
    public static TipoSubparametroVO select(final @Nonnull Long id) {
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

        for (final TipoSubparametroVO tpspVO : tpspList) {
            // tpspVO.setTppr(TipoParametroProxy.select(tpspVO.getTppr().getId()));

            if (tpspVO.getTpprAsociado() != null) {
                tpspVO.setTpprAsociado(TipoParametroProxy.select(tpspVO.getTpprAsociado().getId()));
            }

            TIPO_SUBPARAMETRO_MAP.put(tpspVO.getId(), tpspVO);
        }

        EntidadProxy.loadDependencies(TIPO_SUBPARAMETRO_MAP);

        LABEL_VALUE_LIST.addAll(tpspBO.selectLabelValues());

        LOG.info("Carga de tipos de subparametro OK");
    }

}
