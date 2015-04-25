package xeredi.integra.model.comun.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.SuperpuertoDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoBO.
 */
public final class SuperpuertoBO {
    /**
     * Select object.
     *
     * @param sprtCriterio
     *            the sprt criterio
     * @return the superpuerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public SuperpuertoVO selectObject(final @NonNull SuperpuertoCriterioVO sprtCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
            final SuperpuertoVO sprt = sprtDAO.selectObject(sprtCriterio);

            if (sprt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.sprt, sprtCriterio);
            }

            return sprt;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<SuperpuertoVO> selectList(final @NonNull SuperpuertoCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

            return sprtDAO.selectList(criterio);
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<SuperpuertoVO> selectList(final @NonNull SuperpuertoCriterioVO criterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
            final int count = sprtDAO.count(criterio);
            final List<SuperpuertoVO> sprtList = new ArrayList<>();

            if (count >= offset) {
                sprtList.addAll(sprtDAO.selectList(criterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<SuperpuertoVO>(sprtList, offset, limit, count);
        }
    }

}
