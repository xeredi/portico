package xeredi.integra.model.proxy.metamodelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.bo.metamodelo.TipoSubparametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroProxy.
 */
public final class TipoSubparametroProxy {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoSubparametroProxy.class);

    /** The Constant TIPO_SUBPARAMETRO_MAP. */
    private static final Map<Long, TipoSubparametroVO> TIPO_SUBPARAMETRO_MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Select map.
     * 
     * @return the map
     */
    public static Map<Long, TipoSubparametroVO> selectMap() {
        return TIPO_SUBPARAMETRO_MAP;
    }

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo subparametro vo
     */
    public static TipoSubparametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        if (!TIPO_SUBPARAMETRO_MAP.containsKey(id)) {
            throw new Error("Tipo de subparametro no encontrado: " + id);
        }

        return TIPO_SUBPARAMETRO_MAP.get(id);
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Carga de tipos de subparametro");
        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametro.class);
        final List<TipoSubparametroVO> tpspList = tpspBO.selectList(new TipoSubparametroCriterioVO());

        for (final TipoSubparametroVO tpspVO : tpspList) {
            tpspVO.setTppr(TipoParametroProxy.select(tpspVO.getTppr().getId()));

            if (tpspVO.getTpprAsociado() != null) {
                tpspVO.setTpprAsociado(TipoParametroProxy.select(tpspVO.getTpprAsociado().getId()));
            }

            TIPO_SUBPARAMETRO_MAP.put(tpspVO.getId(), tpspVO);
        }

        EntidadProxy.loadDependencies(TIPO_SUBPARAMETRO_MAP);

        LOG.info("Carga de tipos de subparametro OK");
    }

}
