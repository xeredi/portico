package xeredi.integra.model.maestro.bo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.dao.SubparametroDAO;
import xeredi.integra.model.maestro.dao.SubparametroDatoDAO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroBO.
 */
@Singleton
public class SubparametroBO implements Subparametro {

    /** The sprm dao. */
    @Inject
    SubparametroDAO sprmDAO;

    /** The spdt dao. */
    @Inject
    SubparametroDatoDAO spdtDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void insert(final SubparametroVO sprm, final TipoSubparametroVO tpspVO) throws OverlapException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(tpspVO);

        final IgBO igBO = new IgBO();

        if (sprmDAO.exists(sprm)) {
            sprm.setId(sprmDAO.selectId(sprm));
        } else {
            sprm.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            sprmDAO.insert(sprm);
        }

        sprm.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(SubparametroVO.class.getName(), sprm);
        }

        sprmDAO.insertVersion(sprm);

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getSpvr().getId());
                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void duplicate(final SubparametroVO sprm, final TipoSubparametroVO tpsrVO) throws OverlapException {
        // TODO Implementar
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getId());
        Preconditions.checkNotNull(tpsrVO);

        final IgBO igBO = new IgBO();

        if (sprmDAO.exists(sprm)) {
            sprm.setId(sprmDAO.selectId(sprm));
        } else {
            sprm.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            sprmDAO.insert(sprm);
        }

        sprm.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(SubparametroVO.class.getName(), sprm);
        }

        sprmDAO.insertVersion(sprm);

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getSpvr().getId());
                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void update(final SubparametroVO sprm, final TipoSubparametroVO tpspVO)
            throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(tpspVO);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(sprm.getSpvr().getId());
        Preconditions.checkNotNull(sprm.getSpvr().getFini());

        // Validaciones

        // Validar que los datos del parametro son correctos
        if (!tpspVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpspVO.getEntdList()) {
                if (!sprm.getItdtMap().containsKey(tpdtId.toString())) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    sprm.getItdtMap().put(tpdtId, itdt);

                    // throw new Error("No se ha pasado informacion del dato "
                    // + tpspVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del subparametro: " + sprm);
                }
            }
        }

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(SubparametroVO.class.getName(), sprm);
        }

        final int updated = sprmDAO.updateVersion(sprm);

        if (updated == 0) {
            throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprm);
        }

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getSpvr().getId());
                spdtDAO.update(itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final SubparametroVO sprm) throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(sprm.getSpvr().getId());

        final int updated = sprmDAO.deleteVersion(sprm);

        if (updated == 0) {
            throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprm);
        }

        spdtDAO.deleteVersion(sprm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(sprmCriterioVO);

        List<SubparametroVO> sprmList = null;

        final int count = sprmDAO.selectCount(sprmCriterioVO);

        if (count > offset) {
            sprmList = sprmDAO.selectList(sprmCriterioVO, new RowBounds(offset, limit));

            // FIXME Ojo en la paginacion, puede traer una barbaridad de
            // dependencias
            fillDependencies(sprmList, sprmCriterioVO);
        }

        return new PaginatedList<>(sprmList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO) {
        Preconditions.checkNotNull(sprmCriterioVO);

        final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);

        if (!sprmList.isEmpty()) {
            fillDependencies(sprmList, sprmCriterioVO);
        }

        return sprmList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final SubparametroVO selectObject(final SubparametroCriterioVO sprmCriterioVO)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprmCriterioVO);

        final SubparametroVO sprmVO = sprmDAO.selectObject(sprmCriterioVO);

        if (sprmVO == null) {
            throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprmCriterioVO);
        }

        fillDependencies(Arrays.asList(new SubparametroVO[] { sprmVO }), sprmCriterioVO);

        return sprmVO;
    }

    /**
     * Fill dependencies.
     *
     * @param sprmList
     *            the sprm list
     * @param sprmCriterioVO
     *            the sprm criterio vo
     */
    private void fillDependencies(final Collection<SubparametroVO> sprmList, final SubparametroCriterioVO sprmCriterioVO) {
        Preconditions.checkNotNull(sprmList);
        Preconditions.checkNotNull(sprmCriterioVO);

        if (!sprmList.isEmpty()) {
            final Set<Long> spvrIds = new HashSet<>();

            for (final SubparametroVO sprmVO : sprmList) {
                spvrIds.add(sprmVO.getSpvr().getId());
            }

            sprmCriterioVO.setSpvrIds(spvrIds);

            final List<ItemDatoVO> itdtList = spdtDAO.selectList(sprmCriterioVO);
            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : itdtList) {
                if (!map.containsKey(itdtVO.getItemId())) {
                    map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final SubparametroVO sprmVO : sprmList) {
                sprmVO.setItdtMap(map.get(sprmVO.getSpvr().getId()));
            }

            sprmCriterioVO.setSpvrIds(null);
        }
    }

}
