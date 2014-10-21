package xeredi.integra.model.estadistica.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.dao.EstadisticaDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaBO.
 */
public class EstadisticaBO {

    /** The estd dao. */
    EstadisticaDAO estdDAO;

    /** The esdt dao. */
    EstadisticaDatoDAO esdtDAO;

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(estdCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        estdDAO = session.getMapper(EstadisticaDAO.class);

        try {
            final int count = estdDAO.selectCount(estdCriterioVO);
            final List<EstadisticaVO> estdList = new ArrayList<>();

            if (count > offset) {
                estdCriterioVO.setOffset(offset);
                estdCriterioVO.setLimit(limit);

                estdList.addAll(estdDAO.selectPaginatedList(estdCriterioVO));
                fillDependencies(session, estdList, estdCriterioVO, true);
            }

            return new PaginatedList<>(estdList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    public final List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO) {
        Preconditions.checkNotNull(estdCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        estdDAO = session.getMapper(EstadisticaDAO.class);

        try {
            final List<EstadisticaVO> estdList = estdDAO.selectList(estdCriterioVO);

            fillDependencies(session, estdList, estdCriterioVO, false);

            return estdList;
        } finally {
            session.close();
        }
    }

    /**
     * Select object.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the estadistica vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final EstadisticaVO selectObject(final EstadisticaCriterioVO estdCriterioVO)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(estdCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        estdDAO = session.getMapper(EstadisticaDAO.class);

        try {
            final EstadisticaVO estdVO = estdDAO.selectObject(estdCriterioVO);

            if (estdVO == null) {
                throw new InstanceNotFoundException(EstadisticaVO.class.getName(), estdCriterioVO);
            }

            final List<EstadisticaVO> estdList = Arrays.asList(new EstadisticaVO[] { estdVO });

            fillDependencies(session, estdList, estdCriterioVO, true);

            return estdList.get(0);
        } finally {
            session.close();
        }
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param estdList
     *            the estd list
     * @param estdCriterioVO
     *            the estd criterio vo
     */
    private final void fillDependencies(final SqlSession session, final List<EstadisticaVO> estdList,
            final EstadisticaCriterioVO estdCriterioVO, final boolean useIds) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(estdCriterioVO);

        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

        if (!estdList.isEmpty()) {
            if (useIds) {
                final Set<Long> ids = new HashSet<>();

                for (final EstadisticaVO estdVO : estdList) {
                    ids.add(estdVO.getId());
                }

                estdCriterioVO.setIds(ids);
            }

            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : esdtDAO.selectList(estdCriterioVO)) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
            }

            for (final EstadisticaVO estdVO : estdList) {
                estdVO.setItdtMap(itdtMap.get(estdVO.getId()));
            }

            if (useIds) {
                estdCriterioVO.setIds(null);
            }
        }
    }
}
