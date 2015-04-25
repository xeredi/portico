package xeredi.integra.model.comun.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.PuertoDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoBO.
 */
public final class PuertoBO {
    /**
     * Select object.
     *
     * @param prtoCriterio
     *            the prto criterio
     * @return the puerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public PuertoVO selectObject(final @NonNull PuertoCriterioVO prtoCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
            final PuertoVO prto = prtoDAO.selectObject(prtoCriterio);

            if (prto == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prto, prtoCriterio);
            }

            return prto;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<PuertoVO> selectList(final @NonNull PuertoCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

            return prtoDAO.selectList(criterio);
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
    public PaginatedList<PuertoVO> selectList(final @NonNull PuertoCriterioVO criterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
            final int count = prtoDAO.count(criterio);
            final List<PuertoVO> prtoList = new ArrayList<>();

            if (count >= offset) {
                prtoList.addAll(prtoDAO.selectList(criterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<PuertoVO>(prtoList, offset, limit, count);
        }
    }

}
