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
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
    private static final Map<Long, TipoServicioDetailVO> TIPO_SERVICIO_MAP = new HashMap<>();

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
    public static Map<Long, TipoServicioDetailVO> selectMap() {
        return TIPO_SERVICIO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoServicioDetailVO select(final @Nonnull Long id) {
        if (!TIPO_SERVICIO_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tpsr, id));
        }

        return TIPO_SERVICIO_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de servicio");

        final TipoServicioBO tpsrBO = new TipoServicioBO();

        for (final TipoServicioVO tpsr : tpsrBO.selectList(new TipoServicioCriterioVO())) {
            if (tpsr.getTpdtEstado() != null) {
                tpsr.setTpdtEstado(TipoDatoProxy.select(tpsr.getTpdtEstado().getId()));
            }

            final TipoServicioDetailVO tpsrDetail = new TipoServicioDetailVO();

            tpsrDetail.setEnti(tpsr);

            TIPO_SERVICIO_MAP.put(tpsrDetail.getEnti().getId(), tpsrDetail);
        }

        EntidadProxy.loadDependencies(TIPO_SERVICIO_MAP);

        LABEL_VALUE_LIST.addAll(tpsrBO.selectLabelValues(new TipoServicioCriterioVO()));

        LOG.info("Carga de tipos de servicio OK");
    }

}
