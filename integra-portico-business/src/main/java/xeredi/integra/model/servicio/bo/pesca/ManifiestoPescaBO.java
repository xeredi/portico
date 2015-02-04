package xeredi.integra.model.servicio.bo.pesca;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.servicio.bo.AbstractServicioBO;
import xeredi.integra.model.servicio.dao.pesca.ManifiestoPescaDAO;
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

        mapeDAO.updateRecalcular(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final Long srvcId) throws ModelException {
        // noop
    }

}