package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaProxy.
 */
public final class TipoEstadisticaProxy {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoEstadisticaProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant TIPO_ESTADISTICA_MAP. */
    private static final Map<Long, TipoEstadisticaVO> TIPO_ESTADISTICA_MAP = new HashMap<>();

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
    public static Map<Long, TipoEstadisticaVO> selectMap() {
        return TIPO_ESTADISTICA_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoEstadisticaVO select(final long id) {
        Preconditions.checkNotNull(id);

        TipoEstadisticaVO tpesVO = null;

        tpesVO = TIPO_ESTADISTICA_MAP.get(id);

        if (tpesVO == null) {
            throw new Error("Tipo de servicio no encontrado: " + id);
        }

        return tpesVO;
    }

    /**
     * Load.
     */
    private static synchronized void load() {
        if (TIPO_ESTADISTICA_MAP.isEmpty()) {
            LOG.info("Carga de tipos de estadistica");

            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();
            final List<TipoEstadisticaVO> tpesList = tpesBO.selectList(new TipoEstadisticaCriterioVO());

            for (final TipoEstadisticaVO tpesVO : tpesList) {
                TIPO_ESTADISTICA_MAP.put(tpesVO.getId(), tpesVO);
            }

            EntidadProxy.loadDependencies(TIPO_ESTADISTICA_MAP);

            LABEL_VALUE_LIST.addAll(tpesBO.selectLabelValues());

            LOG.info("Carga de tipos de estadistica OK");
        }
    }

}
