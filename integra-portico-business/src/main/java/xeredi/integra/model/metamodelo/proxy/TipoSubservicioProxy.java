package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioBO.
 */
public final class TipoSubservicioProxy {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoSubservicioProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant TIPO_SUBSERVICIO_MAP. */
    private static final Map<Long, TipoSubservicioVO> TIPO_SUBSERVICIO_MAP = new HashMap<>();

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
    public static Map<Long, TipoSubservicioVO> selectMap() {
        return TIPO_SUBSERVICIO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public static TipoSubservicioVO select(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        if (!TIPO_SUBSERVICIO_MAP.containsKey(id)) {
            throw new InstanceNotFoundException(MessageI18nKey.tpss, id);
        }

        return TIPO_SUBSERVICIO_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de subservicio");
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final List<TipoSubservicioVO> tpssList = tpssBO.selectList(new TipoSubservicioCriterioVO());

        for (final TipoSubservicioVO tpssVO : tpssList) {
            if (tpssVO.getTpdtEstado() != null) {
                try {
                    tpssVO.setTpdtEstado(TipoDatoProxy.select(tpssVO.getTpdtEstado().getId()));
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            TIPO_SUBSERVICIO_MAP.put(tpssVO.getId(), tpssVO);
        }

        EntidadProxy.loadDependencies(TIPO_SUBSERVICIO_MAP);

        LABEL_VALUE_LIST.addAll(tpssBO.selectLabelValues(new TipoSubservicioCriterioVO()));

        LOG.info("Carga de tipos de subservicio OK");
    }

}
