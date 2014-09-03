package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadBO.
 */
public final class EntidadProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(EntidadProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant ENTIDAD_MAP. */
    private static final Map<Long, EntidadVO> ENTIDAD_MAP = new HashMap<>();

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
    public static Map<Long, EntidadVO> selectMap() {
        return ENTIDAD_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the entidad vo
     */
    public static EntidadVO select(final Long id) {
        Preconditions.checkNotNull(id);

        if (!ENTIDAD_MAP.containsKey(id)) {
            throw new Error("Entidad no encontrada: " + id);
        }

        return ENTIDAD_MAP.get(id);
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Carga de Entidades");

        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);
        final Map<Long, TipoDatoVO> tpdtMap = TipoDatoProxy.selectMap();

        ENTIDAD_MAP.putAll(entiBO.selectMap(tpdtMap));
        LABEL_VALUE_LIST.addAll(entiBO.selectLabelValues(new EntidadCriterioVO()));

        LOG.info("Carga de entidades OK");
    }

    /**
     * Load dependencies.
     *
     * @param entiMap
     *            the enti map
     */
    static void loadDependencies(final Map<Long, ? extends EntidadVO> entiMap) {
        Preconditions.checkNotNull(entiMap);

        for (final EntidadVO entiVO : entiMap.values()) {
            if (ENTIDAD_MAP.containsKey(entiVO.getId())) {
                entiVO.setEntdList(ENTIDAD_MAP.get(entiVO.getId()).getEntdList());
                entiVO.setEntdGridList(ENTIDAD_MAP.get(entiVO.getId()).getEntdGridList());
                entiVO.setEntdMap(ENTIDAD_MAP.get(entiVO.getId()).getEntdMap());
                entiVO.setEntiHijasList(ENTIDAD_MAP.get(entiVO.getId()).getEntiHijasList());
                entiVO.setEntiPadresList(ENTIDAD_MAP.get(entiVO.getId()).getEntiPadresList());
                entiVO.setEnacList(ENTIDAD_MAP.get(entiVO.getId()).getEnacList());
                entiVO.setEngdList(ENTIDAD_MAP.get(entiVO.getId()).getEngdList());
                entiVO.setEngdMap(ENTIDAD_MAP.get(entiVO.getId()).getEngdMap());
                entiVO.setEngdEntdMap(ENTIDAD_MAP.get(entiVO.getId()).getEngdEntdMap());
            }
        }
    }
}
