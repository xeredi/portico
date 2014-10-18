package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioBO.
 */
public final class TipoServicioProxy {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoServicioProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant TIPO_SERVICIO_MAP. */
    private static final Map<Long, TipoServicioVO> TIPO_SERVICIO_MAP = new HashMap<>();

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
    public static Map<Long, TipoServicioVO> selectMap() {
        return TIPO_SERVICIO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoServicioVO select(final Long id) {
        Preconditions.checkNotNull(id);

        TipoServicioVO tpsrVO = null;

        tpsrVO = TIPO_SERVICIO_MAP.get(id);

        if (tpsrVO == null) {
            throw new Error("Tipo de servicio no encontrado: " + id);
        }

        return tpsrVO;
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de servicio");

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final List<TipoServicioVO> tpsrList = tpsrBO.selectList(new TipoServicioCriterioVO());

        for (final TipoServicioVO tpsrVO : tpsrList) {
            if (tpsrVO.getTpdtEstado() != null) {
                tpsrVO.setTpdtEstado(TipoDatoProxy.select(tpsrVO.getTpdtEstado().getId()));
            }

            TIPO_SERVICIO_MAP.put(tpsrVO.getId(), tpsrVO);
        }

        EntidadProxy.loadDependencies(TIPO_SERVICIO_MAP);

        LABEL_VALUE_LIST.addAll(tpsrBO.selectLabelValues(new TipoServicioCriterioVO()));

        LOG.info("Carga de tipos de servicio OK");
    }

}
