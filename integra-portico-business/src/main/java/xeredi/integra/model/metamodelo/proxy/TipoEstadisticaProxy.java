package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaDetailVO;
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
    private static final Map<Long, TipoEstadisticaDetailVO> TIPO_ESTADISTICA_MAP = new HashMap<>();

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
    public static Map<Long, TipoEstadisticaDetailVO> selectMap() {
        return TIPO_ESTADISTICA_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoEstadisticaDetailVO select(final long id) {
        if (!TIPO_ESTADISTICA_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tpes, id));
        }

        return TIPO_ESTADISTICA_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de estadistica");

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        for (final TipoEstadisticaVO tpes : tpesBO.selectList(new TipoEstadisticaCriterioVO())) {
            final TipoEstadisticaDetailVO tpesDetail = new TipoEstadisticaDetailVO();

            tpesDetail.setEnti(tpes);

            TIPO_ESTADISTICA_MAP.put(tpesDetail.getEnti().getId(), tpesDetail);
        }

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        for (final CampoAgregacionVO cmag : cmagBO.selectList(new CampoAgregacionCriterioVO())) {
            final TipoEstadisticaDetailVO tpesDetail = TIPO_ESTADISTICA_MAP.get(cmag.getTpesId());

            if (tpesDetail.getCmagList() == null) {
                tpesDetail.setCmagList(new ArrayList<CampoAgregacionVO>());
            }

            tpesDetail.getCmagList().add(cmag);
        }

        EntidadProxy.loadDependencies(TIPO_ESTADISTICA_MAP);

        LABEL_VALUE_LIST.addAll(tpesBO.selectLabelValues());

        LOG.info("Carga de tipos de estadistica OK");
    }

}
