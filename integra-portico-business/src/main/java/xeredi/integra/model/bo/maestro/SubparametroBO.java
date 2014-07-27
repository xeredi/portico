package xeredi.integra.model.bo.maestro;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.maestro.SubparametroDAO;
import xeredi.integra.model.dao.maestro.SubparametroDatoDAO;
import xeredi.integra.model.dao.maestro.SubparametroVersionDAO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroVersionVO;
import xeredi.integra.model.vo.maestro.SubparametroCriterioVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.maestro.SubparametroVersionVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;
import xeredi.util.exception.DuplicateInstanceException;
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

    /** The spvr dao. */
    @Inject
    SubparametroVersionDAO spvrDAO;

    /** The spdt dao. */
    @Inject
    SubparametroDatoDAO spdtDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void insert(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(sprmVO);
        Preconditions.checkNotNull(tpspVO);

        final IgBO igBO = new IgBO();

        if (sprmDAO.intersects(sprmVO)) {
            throw new DuplicateInstanceException(SubparametroVO.class.getName(), sprmVO);
        }

        if (sprmDAO.exists(sprmVO)) {
            final Long id = sprmDAO.selectId(sprmVO);

            sprmVO.setId(id);
        } else {
            sprmVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            sprmDAO.insert(sprmVO);
        }

        sprmVO.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        spvrDAO.insert(sprmVO);

        if (sprmVO.getItdtMap() != null) {
            for (final Long tpdtId : sprmVO.getItdtMap().keySet()) {
                final ItemDatoVO itdtVO = sprmVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(sprmVO.getSpvr().getId());
                itdtVO.setTpdtId(tpdtId);
                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void duplicate(final SubparametroVO sprmVO, final TipoSubparametroVO tpsrVO)
            throws DuplicateInstanceException {
        // TODO Implementar
        Preconditions.checkNotNull(sprmVO);
        Preconditions.checkNotNull(sprmVO.getId());
        Preconditions.checkNotNull(tpsrVO);

        if (tpsrVO.isTempExp()) {
            Preconditions.checkNotNull(sprmVO.getSpvr());
            Preconditions.checkNotNull(sprmVO.getSpvr().getFinicio());
        } else {
            if (sprmVO.getSpvr() == null) {
                sprmVO.setSpvr(new SubparametroVersionVO());
            }

            if (sprmVO.getSpvr().getFinicio() == null) {
                sprmVO.getSpvr().setFinicio(Calendar.getInstance().getTime());
            }
        }

        final IgBO igBO = new IgBO();

        if (sprmDAO.intersects(sprmVO)) {
            throw new DuplicateInstanceException(SubparametroVO.class.getName(), sprmVO);
        }

        if (sprmDAO.exists(sprmVO)) {
            final Long id = sprmDAO.selectId(sprmVO);

            sprmVO.setId(id);
        } else {
            sprmVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            sprmDAO.insert(sprmVO);
        }

        sprmVO.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        spvrDAO.insert(sprmVO);

        if (sprmVO.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                itdtVO.setItemId(sprmVO.getSpvr().getId());

                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void update(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO) {
        Preconditions.checkNotNull(sprmVO);
        Preconditions.checkNotNull(tpspVO);
        Preconditions.checkNotNull(sprmVO.getSpvr());
        Preconditions.checkNotNull(sprmVO.getSpvr().getId());

        if (tpspVO.isTempExp()) {
            Preconditions.checkNotNull(sprmVO.getSpvr().getFinicio());
        }

        final IgBO igBO = new IgBO();

        // Validaciones

        // Validar que los datos del parametro son correctos
        if (!tpspVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpspVO.getEntdList()) {
                if (!sprmVO.getItdtMap().containsKey(tpdtId)) {
                    throw new Error("No se ha pasado informacion del dato "
                            + tpspVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del subparametro: " + sprmVO);
                }
            }
        }

        if (tpspVO.isTempExp()) {
            sprmVO.getSpvr().setFinicio(Calendar.getInstance().getTime());

            throw new Error("No implementado!");
            // TODO Implementar
        } else {
            // Si no es temporalidad eplicita, se cierra la version actual y
            // se crea una version nueva
            final Date fechaCambioPeriodo = Calendar.getInstance().getTime();

            sprmVO.getSpvr().setFfin(fechaCambioPeriodo);

            final int updatedRows = spvrDAO.updateDelete(sprmVO);

            if (updatedRows == 0) {
                throw new Error("No hay version que cerrar para el subparametro: " + sprmVO);
            }

            sprmVO.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            sprmVO.getSpvr().setFinicio(fechaCambioPeriodo);
            sprmVO.getSpvr().setFfin(null);
            spvrDAO.insert(sprmVO);

            if (sprmVO.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                    itdtVO.setItemId(sprmVO.getSpvr().getId());
                    spdtDAO.insert(itdtVO);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long spvrId, final TipoSubparametroVO tpspVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(spvrId);
        Preconditions.checkNotNull(tpspVO);

        // Un parametro con temporalidad explicita NO SE PUEDE BORRAR
        if (tpspVO.isTempExp()) {
            throw new Error("El subparametro con versionId: " + spvrId + " de la entidad: " + tpspVO
                    + " no se puede borrar debido a que tiene temporalidad explicita");
        }

        final SubparametroVO sprmVO = new SubparametroVO();
        final SubparametroVersionVO spvrVO = new SubparametroVersionVO();

        spvrVO.setId(spvrId);
        spvrVO.setFfin(Calendar.getInstance().getTime());
        sprmVO.setSpvr(spvrVO);

        // FIXME Pasar el tipo de parametro para asegurarnos de que el tipo
        // pasado por argumento
        // corresponde con el tipo de prvrId
        final int updatedRows = spvrDAO.updateDelete(sprmVO);

        if (updatedRows == 0) {
            throw new InstanceNotFoundException(ParametroVersionVO.class.getName(), spvrId);
        }
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
