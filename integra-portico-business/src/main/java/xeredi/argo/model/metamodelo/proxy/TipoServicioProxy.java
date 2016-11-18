package xeredi.argo.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
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
     * Instantiates a new tipo servicio proxy.
     */
    private TipoServicioProxy() {
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
    public static TipoServicioDetailVO select(@NonNull final Long id) {
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
