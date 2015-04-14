package xeredi.integra.model.maestro.bo.pesca;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.AbstractParametroBO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BuquePescaBO.
 */
public final class BuquePescaBO extends AbstractParametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final ParametroVO prmt)
            throws InstanceNotFoundException {
        // noop
    }

}
