package xeredi.integra.model.bo.configuracion;

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

import xeredi.integra.model.dao.configuracion.ClaveIdiomaDAO;
import xeredi.integra.model.dao.configuracion.ValorIdiomaDAO;
import xeredi.integra.model.vo.configuracion.ClaveIdiomaCriterioVO;
import xeredi.integra.model.vo.configuracion.ClaveIdiomaVO;
import xeredi.integra.model.vo.configuracion.ValorIdiomaCriterioVO;
import xeredi.integra.model.vo.configuracion.ValorIdiomaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveIdiomaBO.
 */
@Singleton
public class ClaveIdiomaBO implements ClaveIdioma {

    /** The cnci dao. */
    @Inject
    ClaveIdiomaDAO cnciDAO;

    /** The cnvi dao. */
    @Inject
    ValorIdiomaDAO cnviDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void insert(final ClaveIdiomaVO cnciVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cnciVO);

        if (cnciDAO.exists(cnciVO)) {
            throw new DuplicateInstanceException(ClaveIdiomaVO.class.getName(), cnciVO);
        }

        cnciDAO.insert(cnciVO);

        for (final Long cnidId : cnciVO.getCnviMap().keySet()) {
            final ValorIdiomaVO cnviVO = new ValorIdiomaVO();

            cnviVO.setCnciId(cnciVO.getId());
            cnviVO.setCnidId(cnidId);
            cnviVO.setValor(cnciVO.getCnviMap().get(cnidId));

            if (cnviVO.getValor() != null && !cnviVO.getValor().isEmpty()) {
                cnviDAO.insert(cnviVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void update(final ClaveIdiomaVO cnciVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cnciVO);

        final int updated = cnciDAO.update(cnciVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(ClaveIdiomaVO.class.getName(), cnciVO);
        }

        final ValorIdiomaCriterioVO cnviCriterioVO = new ValorIdiomaCriterioVO();

        cnviCriterioVO.setCnciId(cnciVO.getId());

        cnviDAO.delete(cnviCriterioVO);

        for (final Long cnidId : cnciVO.getCnviMap().keySet()) {
            final ValorIdiomaVO cnviVO = new ValorIdiomaVO();

            cnviVO.setCnciId(cnciVO.getId());
            cnviVO.setCnidId(cnidId);
            cnviVO.setValor(cnciVO.getCnviMap().get(cnidId));

            if (cnviVO.getValor() != null && !cnviVO.getValor().isEmpty()) {
                cnviDAO.insert(cnviVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ClaveIdiomaVO select(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final ClaveIdiomaVO cnciVO = cnciDAO.select(id);

        if (cnciVO == null) {
            throw new InstanceNotFoundException(ClaveIdiomaVO.class.getName(), id);
        }

        loadDependencies(Arrays.asList(new ClaveIdiomaVO[] { cnciVO }));

        return cnciVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<ClaveIdiomaVO> selectList(final ClaveIdiomaCriterioVO cnciCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(cnciCriterioVO);

        final int count = cnciDAO.selectCount(cnciCriterioVO);
        final List<ClaveIdiomaVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(cnciDAO.selectList(cnciCriterioVO, new RowBounds(offset, limit)));

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
    public Map<String, ClaveIdiomaVO> selectAllMap() {
        return cnciDAO.selectAllMap();
    }

    /**
     * Load dependencies.
     *
     * @param list
     *            the list
     */
    private final void loadDependencies(final List<ClaveIdiomaVO> list) {
        Preconditions.checkNotNull(list);

        final Set<Long> cnciIds = new HashSet<>();

        for (final ClaveIdiomaVO cnciVO : list) {
            cnciIds.add(cnciVO.getId());
        }

        if (!cnciIds.isEmpty()) {
            final ValorIdiomaCriterioVO cnviCriterioVO = new ValorIdiomaCriterioVO();

            cnviCriterioVO.setCnciIds(cnciIds);

            final List<ValorIdiomaVO> cnvis = cnviDAO.selectList(cnviCriterioVO);
            final Map<Long, Map<Long, String>> map = new HashMap<>();

            for (final ValorIdiomaVO cnviVO : cnvis) {
                if (!map.containsKey(cnviVO.getCnciId())) {
                    map.put(cnviVO.getCnciId(), new HashMap<Long, String>());
                }

                map.get(cnviVO.getCnciId()).put(cnviVO.getCnidId(), cnviVO.getValor());
            }

            for (final ClaveIdiomaVO cnclVO : list) {
                cnclVO.setCnviMap(map.get(cnclVO.getId()));
            }
        }
    }
}
