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
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoBO.
 */
public final class TipoDatoProxy {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoDatoProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant TIPO_DATO_MAP. */
    private static final Map<Long, TipoDatoVO> TIPO_DATO_MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Instantiates a new tipo dato proxy.
     */
    private TipoDatoProxy() {
        super();
    }

    /**
     * Select map.
     *
     * @return the map
     */
    public static Map<Long, TipoDatoVO> selectMap() {
        return TIPO_DATO_MAP;
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
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo dato vo
     */
    public static TipoDatoVO select(@NonNull final Long id) {
        if (!TIPO_DATO_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.tpdt, id));
        }

        return TIPO_DATO_MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tipos de Dato");

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        TIPO_DATO_MAP.putAll(tpdtBO.selectMap(new TipoDatoCriterioVO()));
        LABEL_VALUE_LIST.addAll(tpdtBO.selectLabelValues(new TipoDatoCriterioVO()));

        LOG.info("Carga de tipos de Dato OK");
    }
}
