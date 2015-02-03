package xeredi.integra.model.maestro.bo;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * Implementación del servicio de gestión de maestros de la aplicación.
 */
public final class ParametroBO extends AbstractParametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ParametroVO prmt, final TipoParametroVO tpprVO,
            final Map<String, I18nVO> i18nMap) {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ParametroVO prmt, final TipoParametroVO tpprVO,
            final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
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
