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
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroBO.
 */
public final class TipoParametroProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoParametroProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant TIPO_PARAMETRO_MAP. */
    private static final Map<Long, TipoParametroDetailVO> TIPO_PARAMETRO_MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Instantiates a new tipo parametro proxy.
     */
    private TipoParametroProxy() {
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
    public static Map<Long, TipoParametroDetailVO> selectMap() {
        return TIPO_PARAMETRO_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoParametroDetailVO select(@NonNull final Long id) {
        if (!TIPO_PARAMETRO_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tppr, id));
        }

        return TIPO_PARAMETRO_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de parametro");

        final TipoParametroBO tpprBO = new TipoParametroBO();

        for (final TipoParametroVO tppr : tpprBO.selectList(new TipoParametroCriterioVO())) {
            final TipoParametroDetailVO tpprDetail = new TipoParametroDetailVO();

            tpprDetail.setEnti(tppr);

            TIPO_PARAMETRO_MAP.put(tpprDetail.getEnti().getId(), tpprDetail);
        }

        EntidadProxy.loadDependencies(TIPO_PARAMETRO_MAP);

        for (final TipoParametroDetailVO tpprDetail : TIPO_PARAMETRO_MAP.values()) {
            for (final Long tpspId : tpprDetail.getEntiHijasList()) {
                tpprDetail.getSubentiList().add(TipoSubparametroProxy.select(tpspId).getEnti());
            }
        }

        LABEL_VALUE_LIST.addAll(tpprBO.selectLabelValues());

        LOG.info("Carga de tipos de parametro OK");
    }
}
