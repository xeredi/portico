package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoDato;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

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
    public static TipoDatoVO select(final Long id) {
        Preconditions.checkNotNull(id);

        return TIPO_DATO_MAP.get(id);
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Carga de tipos de Dato");

        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

        TIPO_DATO_MAP.putAll(tpdtBO.selectMap(new TipoDatoCriterioVO()));
        LABEL_VALUE_LIST.addAll(tpdtBO.selectLabelValues());

        LOG.info("Carga de tipos de Dato OK");
    }
}
