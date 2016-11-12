package xeredi.argo.model.servicio.bo.pesca;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.dao.pesca.ManifiestoPescaDAO;
import xeredi.argo.model.servicio.dao.pesca.PartidaPescaDAO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaPescaBO.
 */
public final class PartidaPescaBO extends SubservicioBO {

    /**
     * Instantiates a new partida pesca BO.
     *
     * @param ausroId
     *            the ausro id
     */
    private PartidaPescaBO(Long ausroId) {
        super(Entidad.PARTIDA_PESCA.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO) {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(ssrv.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrv.getSrvc().getId());
    }
}
