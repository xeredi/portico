package xeredi.integra.model.metamodelo.proxy;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TramiteBO;
import xeredi.integra.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteProxy.
 */
public final class TramiteProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TramiteProxy.class);

    /** The Constant MAP. */
    private static final Map<Long, TramiteDetailVO> MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Select map.
     *
     * @return the map
     */
    public static Map<Long, TramiteDetailVO> selectMap() {
        return MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tramite detail vo
     */
    public static TramiteDetailVO select(final Long id) {
        if (!MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.trmt, id));
        }

        return MAP.get(id);
    }

    /**
     * Load.
     */
    static synchronized void load() {
        LOG.info("Carga de tramites");

        final TramiteBO trmtBO = new TramiteBO();

        for (final TramiteVO trmt : trmtBO.selectList(new TramiteCriterioVO())) {
            final TramiteDetailVO trmtDetail = new TramiteDetailVO();

            trmtDetail.setTrmt(trmt);

            MAP.put(trmt.getId(), trmtDetail);
        }

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();

        for (final TramiteTipoDatoVO trtd : trtdBO.selectList(new TramiteTipoDatoCriterioVO())) {
            final TramiteDetailVO trmtDetail = MAP.get(trtd.getTrmtId());
            final Long tpdtId = trtd.getEntd().getTpdt().getId();

            trmtDetail.getTpdtList().add(tpdtId);
            trmtDetail.getTrtdMap().put(tpdtId, trtd);
        }

        LOG.info("Carga de tramites OK");
    }
}