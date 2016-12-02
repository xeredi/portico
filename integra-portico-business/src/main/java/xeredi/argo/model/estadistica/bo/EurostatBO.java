package xeredi.argo.model.estadistica.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.estadistica.dao.EurostatDAO;
import xeredi.argo.model.estadistica.vo.EurostatCriterioVO;
import xeredi.argo.model.estadistica.vo.EurostatVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EurostatBO.
 */
public final class EurostatBO {

    /**
     * Select a1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectA1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectA1List(criterio);
        }
    }

    /**
     * Select a2 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectA2List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectA2List(criterio);
        }
    }

    /**
     * Select a3 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectA3List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectA3List(criterio);
        }
    }

    /**
     * Select b1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectB1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectB1List(criterio);
        }
    }

    /**
     * Select c1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectC1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectC1List(criterio);
        }
    }

    /**
     * Select d1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectD1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectD1List(criterio);
        }
    }

    /**
     * Select e1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectE1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectE1List(criterio);
        }
    }

    /**
     * Select f1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectF1List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectF1List(criterio);
        }
    }

    /**
     * Select f2 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<EurostatVO> selectF2List(@NonNull final EurostatCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EurostatDAO erstDAO = session.getMapper(EurostatDAO.class);

            return erstDAO.selectF2List(criterio);
        }
    }
}
