package xeredi.argo.model.maestro.bo.embdeportivas;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreEmbarcacionBO.
 */
public final class AmarreEmbarcacionBO extends SubparametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(@NonNull final SqlSession session, @NonNull final SubparametroVO sprm,
            @NonNull final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(sprm.getPrmtId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(@NonNull final SqlSession session, @NonNull final SubparametroVO sprm,
            @NonNull final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(sprm.getPrmtId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(@NonNull final SqlSession session, @NonNull final SubparametroVO sprm,
            @NonNull final TipoSubparametroDetailVO tpspDetail) throws InstanceNotFoundException, OverlapException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(sprm.getPrmtId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(@NonNull final SqlSession session, @NonNull final SubparametroVO sprm)
            throws InstanceNotFoundException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(sprm.getPrmtId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

}
