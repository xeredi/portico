package xeredi.integra.model.configuracion.bo;

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

import xeredi.integra.model.configuracion.dao.ClaveDAO;
import xeredi.integra.model.configuracion.dao.ValorDAO;
import xeredi.integra.model.configuracion.vo.ClaveCriterioVO;
import xeredi.integra.model.configuracion.vo.ClaveVO;
import xeredi.integra.model.configuracion.vo.ValorCriterioVO;
import xeredi.integra.model.configuracion.vo.ValorVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveBO.
 */
@Singleton
public class ClaveBO implements Clave {

    /** The cncl dao. */
    @Inject
    ClaveDAO cnclDAO;

    /** The cnvl dao. */
    @Inject
    ValorDAO cnvlDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void insert(final ClaveVO cnclVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cnclVO);

        if (cnclDAO.exists(cnclVO)) {
            throw new DuplicateInstanceException(ClaveVO.class.getName(), cnclVO);
        }

        cnclDAO.insert(cnclVO);

        if (cnclVO.getCnvlMap() != null) {
            for (final Long cnenId : cnclVO.getCnvlMap().keySet()) {
                final ValorVO cnvlVO = new ValorVO();

                cnvlVO.setCnclId(cnclVO.getId());
                cnvlVO.setCnenId(cnenId);
                cnvlVO.setValor(cnclVO.getCnvlMap().get(cnenId));

                if (cnvlVO.getValor() != null && !cnvlVO.getValor().isEmpty()) {
                    cnvlDAO.insert(cnvlVO);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void update(final ClaveVO cnclVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cnclVO);

        final int updated = cnclDAO.update(cnclVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(ClaveVO.class.getName(), cnclVO);
        }

        final ValorCriterioVO cnvlCriterioVO = new ValorCriterioVO();

        cnvlCriterioVO.setCnclId(cnclVO.getId());

        cnvlDAO.delete(cnvlCriterioVO);

        if (cnclVO.getCnvlMap() != null) {
            for (final Long cnenId : cnclVO.getCnvlMap().keySet()) {
                final ValorVO cnvlVO = new ValorVO();

                cnvlVO.setCnclId(cnclVO.getId());
                cnvlVO.setCnenId(cnenId);
                cnvlVO.setValor(cnclVO.getCnvlMap().get(cnenId));

                if (cnvlVO.getValor() != null && !cnvlVO.getValor().isEmpty()) {
                    cnvlDAO.insert(cnvlVO);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ClaveVO select(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final ClaveVO cnclVO = cnclDAO.select(id);

        if (cnclVO == null) {
            throw new InstanceNotFoundException(ClaveVO.class.getName(), id);
        }

        loadDependencies(Arrays.asList(new ClaveVO[] { cnclVO }));

        return cnclVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<ClaveVO> selectList(final ClaveCriterioVO cnclCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(cnclCriterioVO);

        final int count = cnclDAO.selectCount(cnclCriterioVO);
        final List<ClaveVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(cnclDAO.selectList(cnclCriterioVO, new RowBounds(offset, limit)));

            if (!list.isEmpty()) {
                loadDependencies(list);
            }
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Map<String, ClaveVO> selectAllMap() {
        return cnclDAO.selectAllMap();
    }

    /**
     * Load dependencies.
     *
     * @param list
     *            the list
     */
    private final void loadDependencies(final List<ClaveVO> list) {
        Preconditions.checkNotNull(list);

        final Set<Long> cnclIds = new HashSet<>();

        for (final ClaveVO cnclVO : list) {
            cnclIds.add(cnclVO.getId());
        }

        if (!cnclIds.isEmpty()) {
            final ValorCriterioVO cnvlCriterioVO = new ValorCriterioVO();

            cnvlCriterioVO.setCnclIds(cnclIds);

            final List<ValorVO> cnvls = cnvlDAO.selectList(cnvlCriterioVO);
            final Map<Long, Map<Long, String>> map = new HashMap<>();

            for (final ValorVO cnvlVO : cnvls) {
                if (!map.containsKey(cnvlVO.getCnclId())) {
                    map.put(cnvlVO.getCnclId(), new HashMap<Long, String>());
                }

                map.get(cnvlVO.getCnclId()).put(cnvlVO.getCnenId(), cnvlVO.getValor());
            }

            for (final ClaveVO cnclVO : list) {
                cnclVO.setCnvlMap(map.get(cnclVO.getId()));
            }
        }
    }
}
