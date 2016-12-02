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
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

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
    private static final Map<Long, TipoSubservicioDetailVO> TIPO_SUBSERVICIO_MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Instantiates a new tipo subservicio proxy.
     */
    private TipoSubservicioProxy() {
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
     * Select map.
     *
     * @return the map
     */
    public static Map<Long, TipoSubservicioDetailVO> selectMap() {
        return TIPO_SUBSERVICIO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo subservicio vo
     */
    public static TipoSubservicioDetailVO select(@NonNull final Long id) {
        if (!TIPO_SUBSERVICIO_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tpss, id));
        }

        return TIPO_SUBSERVICIO_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de subservicio");
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        for (final TipoSubservicioVO tpss : tpssBO.selectList(new TipoSubservicioCriterioVO())) {
            if (tpss.getTpdtEstado() != null) {
                tpss.setTpdtEstado(TipoDatoProxy.select(tpss.getTpdtEstado().getId()));
            }

            final TipoSubservicioDetailVO tpssDetail = new TipoSubservicioDetailVO();

            tpssDetail.setEnti(tpss);

            TIPO_SUBSERVICIO_MAP.put(tpssDetail.getEnti().getId(), tpssDetail);
        }

        EntidadProxy.loadDependencies(TIPO_SUBSERVICIO_MAP);

        LABEL_VALUE_LIST.addAll(tpssBO.selectLabelValues(new TipoSubservicioCriterioVO()));

        LOG.info("Carga de tipos de subservicio OK");
    }

}
