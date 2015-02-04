package xeredi.integra.model.servicio.bo.pesca;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.AbstractSubservicioBO;
import xeredi.integra.model.servicio.dao.pesca.ManifiestoPescaDAO;
import xeredi.integra.model.servicio.dao.pesca.PartidaPescaDAO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaPescaBO.
 */
public final class PartidaPescaBO extends AbstractSubservicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioVO tpssVO, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcular(ssrvVO.getId());
        mapeDAO.updateRecalcular(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO) {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcular(ssrvVO.getId());
        mapeDAO.updateRecalcular(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcular(ssrvVO.getId());
        mapeDAO.updateRecalcular(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final Long ssrvId) throws InstanceNotFoundException {
        throw new Error("Implementar");
    }

}
