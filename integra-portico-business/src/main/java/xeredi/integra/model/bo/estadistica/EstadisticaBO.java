package xeredi.integra.model.bo.estadistica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.estadistica.EstadisticaDAO;
import xeredi.integra.model.dao.estadistica.EstadisticaDatoDAO;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.estadistica.EstadisticaCriterioVO;
import xeredi.integra.model.vo.estadistica.EstadisticaVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaBO.
 */
@Singleton
public class EstadisticaBO implements Estadistica {

    /** The estd dao. */
    @Inject
    EstadisticaDAO estdDAO;

    /** The esdt dao. */
    @Inject
    EstadisticaDatoDAO esdtDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(estdCriterioVO);

        final int count = estdDAO.selectCount(estdCriterioVO);
        final List<EstadisticaVO> estdList = new ArrayList<>();

        if (count > offset) {
            estdList.addAll(estdDAO.selectList(estdCriterioVO, new RowBounds(offset, limit)));

            fillDependencies(estdList, estdCriterioVO);
        }

        return new PaginatedList<>(estdList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO) {
        Preconditions.checkNotNull(estdCriterioVO);

        final List<EstadisticaVO> estdList = estdDAO.selectList(estdCriterioVO);

        fillDependencies(estdList, estdCriterioVO);

        return estdList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final EstadisticaVO selectObject(final EstadisticaCriterioVO estdCriterioVO)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(estdCriterioVO);

        final EstadisticaVO estdVO = estdDAO.selectObject(estdCriterioVO);

        if (estdVO == null) {
            throw new InstanceNotFoundException(EstadisticaVO.class.getName(), estdCriterioVO);
        }

        final List<EstadisticaVO> estdList = Arrays.asList(new EstadisticaVO[] { estdVO });

        fillDependencies(estdList, estdCriterioVO);

        return estdList.get(0);
    }

    /**
     * Fill dependencies.
     *
     * @param estdList
     *            the estd list
     * @param estdCriterioVO
     *            the estd criterio vo
     */
    private final void fillDependencies(final List<EstadisticaVO> estdList, final EstadisticaCriterioVO estdCriterioVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(estdCriterioVO);

        if (!estdList.isEmpty()) {
            final Set<Long> ids = new HashSet<>();

            for (final EstadisticaVO estdVO : estdList) {
                ids.add(estdVO.getId());
            }

            estdCriterioVO.setIds(ids);

            final List<ItemDatoVO> itdtList = esdtDAO.selectList(estdCriterioVO);
            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : itdtList) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final EstadisticaVO estdVO : estdList) {
                estdVO.setItdtMap(itdtMap.get(estdVO.getId()));
            }

            estdCriterioVO.setIds(null);
        }
    }
}
