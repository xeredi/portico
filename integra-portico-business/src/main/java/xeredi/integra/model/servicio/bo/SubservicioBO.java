package xeredi.integra.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioBO.
 */
@Singleton
public class SubservicioBO implements Subservicio {

    /** The ssrv dao. */
    @Inject
    SubservicioDAO ssrvDAO;

    /** The ssdt dao. */
    @Inject
    SubservicioDatoDAO ssdtDAO;

    /** The ssss dao. */
    @Inject
    SubservicioSubservicioDAO ssssDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(ssrvCriterioVO);

        final int count = ssrvDAO.selectCount(ssrvCriterioVO);
        final List<SubservicioVO> ssrvList = new ArrayList<>();

        if (count > offset) {
            ssrvCriterioVO.setOffset(offset);
            ssrvCriterioVO.setLimit(limit);

            ssrvList.addAll(ssrvDAO.selectList(ssrvCriterioVO));

            ssrvCriterioVO.setOffset(null);
            ssrvCriterioVO.setLimit(null);

            fillDependencies(ssrvList, ssrvCriterioVO);
        }

        return new PaginatedList<>(ssrvList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO) {
        Preconditions.checkNotNull(ssrvCriterioVO);

        final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);

        fillDependencies(ssrvList, ssrvCriterioVO);

        return ssrvList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SubservicioVO select(final Long ssrvId, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(idioma);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setIdioma(idioma);

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        fillDependencies(Arrays.asList(new SubservicioVO[] { ssrvVO }), ssrvCriterioVO);

        return ssrvVO;
    }

    /**
     * Fill dependencies.
     *
     * @param ssrvList
     *            the ssrv list
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     */
    private void fillDependencies(final List<SubservicioVO> ssrvList, final SubservicioCriterioVO ssrvCriterioVO) {
        Preconditions.checkNotNull(ssrvList);
        Preconditions.checkNotNull(ssrvCriterioVO);

        // Datos asociados
        if (!ssrvList.isEmpty()) {
            final Set<Long> ssrvIds = new HashSet<>();

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvIds.add(ssrvVO.getId());
            }

            ssrvCriterioVO.setIds(ssrvIds);

            final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);

            ssrvCriterioVO.setIds(null);

            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : ssdtList) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvVO.setItdtMap(itdtMap.get(ssrvVO.getId()));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void insert(final SubservicioVO ssrvVO, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        Preconditions.checkNotNull(ssrvVO);
        Preconditions.checkNotNull(ssrvPadreIds);

        final IgBO igBO = new IgBO();

        if (ssrvDAO.exists(ssrvVO)) {
            throw new DuplicateInstanceException(SubservicioVO.class.getName(), ssrvVO);
        }

        ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        ssrvDAO.insert(ssrvVO);

        for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
            final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

            itdtVO.setItemId(ssrvVO.getId());
            itdtVO.setTpdtId(tpdtId);
            ssdtDAO.insert(itdtVO);
        }

        for (final Long ssrvPadreId : ssrvPadreIds) {
            final SubservicioSubservicioVO ssssVO = new SubservicioSubservicioVO(ssrvPadreId, ssrvVO.getId());

            ssssDAO.insert(ssssVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void update(final SubservicioVO ssrvVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvVO);

        for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
            final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

            itdtVO.setItemId(ssrvVO.getId());
            itdtVO.setTpdtId(Long.valueOf(tpdtId));

            if (ssdtDAO.update(itdtVO) == 0) {
                throw new Error("Error modificando un subservicio de dato no existente: " + itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(final Long ssrvId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvId);

        throw new Error("No Implementado");
    }

}
