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
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
    public static TipoParametroVO select(final @Nonnull Long id) {
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
        final List<TipoParametroVO> tpprList = tpprBO.selectList(new TipoParametroCriterioVO());

        for (final TipoParametroVO tpprVO : tpprList) {
            TIPO_PARAMETRO_MAP.put(tpprVO.getId(), tpprVO);
        }

        EntidadProxy.loadDependencies(TIPO_PARAMETRO_MAP);

        LABEL_VALUE_LIST.addAll(tpprBO.selectLabelValues());

        LOG.info("Carga de tipos de parametro OK");
    }
}
