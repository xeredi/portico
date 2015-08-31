package xeredi.integra.model.maestro.bo.embdeportivas;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreEmbarcacionBO.
 */
public final class AmarreEmbarcacionBO extends SubparametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @NonNull SqlSession session, final @NonNull SubparametroVO sprm,
            final @NonNull TipoSubparametroDetailVO tpspDetail) throws OverlapException {
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
    protected void duplicatePostOperations(final @NonNull SqlSession session, final @NonNull SubparametroVO sprm,
            final @NonNull TipoSubparametroDetailVO tpspDetail) throws OverlapException {
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
    protected void updatePostOperations(final @NonNull SqlSession session, final @NonNull SubparametroVO sprm,
            final @NonNull TipoSubparametroDetailVO tpspDetail) throws InstanceNotFoundException, OverlapException {
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
    protected void deletePostOperations(final @NonNull SqlSession session, final @NonNull SubparametroVO sprm)
            throws InstanceNotFoundException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(sprm.getPrmtId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

}
