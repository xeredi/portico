package xeredi.argo.model.maestro.bo.embdeportivas;

import java.util.Calendar;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbarcacionDeportivaAutonomicaBO.
 */
public final class AmarreDeportivoBO extends ParametroBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void insertPostOperations(@NonNull final SqlSession session, @NonNull final ParametroVO prmt,
            @NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(prmt.getId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void duplicatePostOperations(@NonNull final SqlSession session, @NonNull final ParametroVO prmt,
            @NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
                    throws OverlapException, InstanceNotFoundException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(prmt.getId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void updatePostOperations(@NonNull final SqlSession session, @NonNull final ParametroVO prmt,
            @NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
                    throws OverlapException, InstanceNotFoundException {
        final AmarreDeportivoDAO dao = session.getMapper(AmarreDeportivoDAO.class);
        final ParametroCriterioVO criterio = new ParametroCriterioVO();

        criterio.setId(prmt.getId());
        criterio.setFechaVigencia(Calendar.getInstance().getTime());

        dao.updateRecalcularEstado(criterio);
    }

    /**
     * Update recalcular estado.
     */
    public final void updateRecalcularEstado() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AmarreDeportivoDAO embaDAO = session.getMapper(AmarreDeportivoDAO.class);
            final ParametroCriterioVO embaCriterio = new ParametroCriterioVO();

            embaCriterio.setFechaVigencia(Calendar.getInstance().getTime());

            embaDAO.updateRecalcularEstado(embaCriterio);

            session.commit();
        }
    }

}
