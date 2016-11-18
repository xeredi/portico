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

import lombok.NonNull;
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
public final class EstadisticaBO {
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
    public PaginatedList<EstadisticaVO> selectList(@NonNull final EstadisticaCriterioVO estdCriterioVO,
            final int offset, final int limit) {
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
    public List<EstadisticaVO> selectList(@NonNull final EstadisticaCriterioVO estdCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final List<EstadisticaVO> estdList = estdDAO.selectList(estdCriterioVO);

            fillDependencies(session, estdList, estdCriterioVO, false);

            return estdList;
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the estadistica VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        final EstadisticaCriterioVO estdCriterio = new EstadisticaCriterioVO();

        estdCriterio.setId(id);
        estdCriterio.setIdioma(idioma);

        return selectObject(estdCriterio);
    }

    /**
     * Select object.
     *
     * @param estdCriterio
     *            the estd criterio
     * @return the estadistica vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EstadisticaVO selectObject(@NonNull final EstadisticaCriterioVO estdCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final EstadisticaVO estd = estdDAO.selectObject(estdCriterio);

            if (estd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.estd, estdCriterio);
            }

            final List<EstadisticaVO> estdList = Arrays.asList(new EstadisticaVO[] { estd });

            fillDependencies(session, estdList, estdCriterio, true);

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
     * @param estdCriterio
     *            the estd criterio
     * @param useIds
     *            the use ids
     */
    private void fillDependencies(@NonNull final SqlSession session, @NonNull final List<EstadisticaVO> estdList,
            @NonNull final EstadisticaCriterioVO estdCriterio, final boolean useIds) {
        if (!estdList.isEmpty()) {
            if (useIds) {
                final Set<Long> ids = new HashSet<>();

                for (final EstadisticaVO estd : estdList) {
                    ids.add(estd.getId());
                }

                estdCriterio.setIds(ids);
            }

            final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);
            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdt : esdtDAO.selectList(estdCriterio)) {
                if (!itdtMap.containsKey(itdt.getItemId())) {
                    itdtMap.put(itdt.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdt.getItemId()).put(itdt.getTpdtId(), itdt);

                itdt.setItemId(null);
                itdt.setTpdtId(null);
            }

            for (final EstadisticaVO estd : estdList) {
                estd.setItdtMap(itdtMap.get(estd.getId()));
            }

            if (useIds) {
                estdCriterio.setIds(null);
            }
        }
    }
}
