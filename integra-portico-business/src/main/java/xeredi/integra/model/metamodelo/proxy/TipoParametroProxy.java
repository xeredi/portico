package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoParametro;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

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
    private static final Map<Long, TipoParametroVO> TIPO_PARAMETRO_MAP = new HashMap<>();

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
    public static Map<Long, TipoParametroVO> selectMap() {
        return TIPO_PARAMETRO_MAP;
    }

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public static TipoParametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        if (!TIPO_PARAMETRO_MAP.containsKey(id)) {
            throw new Error("Tipo de parametro no encontrado: " + id);
        }

        return TIPO_PARAMETRO_MAP.get(id);
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Carga de tipos de parametro");

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametro.class);
        final List<TipoParametroVO> tpprList = tpprBO.selectList(new TipoParametroCriterioVO());

        for (final TipoParametroVO tpprVO : tpprList) {
            TIPO_PARAMETRO_MAP.put(tpprVO.getId(), tpprVO);
        }

        EntidadProxy.loadDependencies(TIPO_PARAMETRO_MAP);

        LABEL_VALUE_LIST.addAll(tpprBO.selectLabelValues());

        LOG.info("Carga de tipos de parametro OK");
    }
}
