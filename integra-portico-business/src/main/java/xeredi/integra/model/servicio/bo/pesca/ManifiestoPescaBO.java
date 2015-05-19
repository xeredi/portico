package xeredi.integra.model.servicio.bo.pesca;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;
import xeredi.integra.model.servicio.bo.AbstractServicioBO;
import xeredi.integra.model.servicio.dao.pesca.ManifiestoPescaDAO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

public final class ManifiestoPescaBO extends AbstractServicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final ServicioVO srvc) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(final SqlSession session, final ServicioVO srvc,
            final ServicioTramiteVO srtr, final TramiteDetailVO trmtDetail) throws ModelException {
        // noop
    }
}
