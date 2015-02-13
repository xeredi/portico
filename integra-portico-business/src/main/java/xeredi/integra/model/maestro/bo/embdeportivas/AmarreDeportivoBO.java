package xeredi.integra.model.maestro.bo.embdeportivas;

import java.util.Calendar;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbarcacionDeportivaAutonomicaBO.
 */
public final class AmarreDeportivoBO {

    /**
     * Update recalcular estado.
     */
    public void updateRecalcularEstado() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AmarreDeportivoDAO embaDAO = session.getMapper(AmarreDeportivoDAO.class);
            final ParametroCriterioVO embaCriterio = new ParametroCriterioVO();

            embaCriterio.setFechaVigencia(Calendar.getInstance().getTime());

            embaDAO.updateRecalcularEstado(embaCriterio);

            session.commit();
        }
    }

}
