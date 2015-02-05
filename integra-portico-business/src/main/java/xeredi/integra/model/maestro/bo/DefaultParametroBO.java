package xeredi.integra.model.maestro.bo;

import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultParametroBO.
 */
public final class DefaultParametroBO extends AbstractParametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt)
            throws InstanceNotFoundException {
        // noop
    }

}
