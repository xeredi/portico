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
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
    public static TipoEstadisticaVO select(final @Nonnull long id) {
        final TipoEstadisticaVO tpesVO = TIPO_ESTADISTICA_MAP.get(id);

        if (tpesVO == null) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tpes, id));
        }

        return tpesVO;
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de estadistica");

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        for (final TipoEstadisticaVO tpesVO : tpesBO.selectList(new TipoEstadisticaCriterioVO())) {
            tpesVO.setCmagList(new ArrayList<CampoAgregacionVO>());

            TIPO_ESTADISTICA_MAP.put(tpesVO.getId(), tpesVO);
        }

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        for (final CampoAgregacionVO cmagVO : cmagBO.selectList(new CampoAgregacionCriterioVO())) {
            TIPO_ESTADISTICA_MAP.get(cmagVO.getTpesId()).getCmagList().add(cmagVO);
        }

        EntidadProxy.loadDependencies(TIPO_ESTADISTICA_MAP);

        LABEL_VALUE_LIST.addAll(tpesBO.selectLabelValues());

        LOG.info("Carga de tipos de estadistica OK");
    }

}
