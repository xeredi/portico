package xeredi.argo.model.estadistica.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.estadistica.dao.EstadisticaDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaBO.
 */
public class EstadisticaBO {
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final int count = estdDAO.count(estdCriterioVO);
            final List<EstadisticaVO> estdList = new ArrayList<>();

            if (count > offset) {
                estdList.addAll(estdDAO.selectList(estdCriterioVO, new RowBounds(offset, limit)));

                fillDependencies(session, estdList, estdCriterioVO, true);
            }

            return new PaginatedList<>(estdList, offset, limit, count);
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final List<EstadisticaVO> estdList = estdDAO.selectList(estdCriterioVO);

            fillDependencies(session, estdList, estdCriterioVO, false);

            return estdList;
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final EstadisticaVO estdVO = estdDAO.selectObject(estdCriterioVO);

            if (estdVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.estd, estdCriterioVO);
            }

            final List<EstadisticaVO> estdList = Arrays.asList(new EstadisticaVO[] { estdVO });

            fillDependencies(session, estdList, estdCriterioVO, true);

            return estdList.get(0);
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
     * @param useIds
     *            the use ids
     */
    private final void fillDependencies(final SqlSession session, final List<EstadisticaVO> estdList,
            final EstadisticaCriterioVO estdCriterioVO, final boolean useIds) {
        if (!estdList.isEmpty()) {
            if (useIds) {
                final Set<Long> ids = new HashSet<>();

                for (final EstadisticaVO estdVO : estdList) {
                    ids.add(estdVO.getId());
                }

                estdCriterioVO.setIds(ids);
            }

            final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);
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