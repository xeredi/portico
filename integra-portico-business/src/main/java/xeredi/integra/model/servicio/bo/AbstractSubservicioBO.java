package xeredi.integra.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.collect.Sets;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSubservicioBO.
 */
public abstract class AbstractSubservicioBO implements SubservicioBO {
    /**
     * {@inheritDoc}
     */
    @Override
    public final PaginatedList<SubservicioVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final int count = ssrvDAO.selectCount(ssrvCriterioVO);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvCriterioVO.setOffset(offset);
                ssrvCriterioVO.setLimit(limit);

                ssrvList.addAll(ssrvDAO.selectList(ssrvCriterioVO));
                fillDependencies(session, ssrvList, ssrvCriterioVO, true);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<SubservicioVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            ssrvCriterioVO.setOffset(null);
            ssrvCriterioVO.setLimit(null);

            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);

            fillDependencies(session, ssrvList, ssrvCriterioVO, false);

            return ssrvList;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LabelValueVO selectLabelValueObject(final SubservicioCriterioVO ssrvCriterioVO)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrv == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvCriterioVO);
            }

            return new LabelValueVO(ssrv.getEtiqueta(), ssrv.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final SubservicioVO select(final @Nonnull Long ssrvId, final @Nonnull String idioma)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setIdioma(idioma);

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvId);
            }

            fillDependencies(session, Arrays.asList(new SubservicioVO[] { ssrvVO }), ssrvCriterioVO, true);

            return ssrvVO;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<SubservicioVO> selectLupaList(final @Nonnull SubservicioLupaCriterioVO ssrvLupaCriterioVO,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

            return ssrvDAO.selectLupaList(ssrvLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void insert(final @Nonnull SubservicioVO ssrvVO, final @Nonnull TipoSubservicioVO tpssVO,
            final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

            if (tpssVO.getEntdList() != null && !tpssVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpssVO.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!ssrvVO.getItdtMap().containsKey(tpdtId) && !ssrvVO.getItdtMap().containsKey(tpdtId.toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        ssrvVO.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            final IgBO igBO = new IgBO();

            if (ssrvDAO.exists(ssrvVO)) {
                throw new DuplicateInstanceException(ssrvVO.getEntiId(), ssrvVO);
            }

            ssrvVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
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

            insertPostOperations(session, ssrvVO, tpssVO, ssrvPadreIds);

            session.commit();
        }
    }

    /**
     * Insert post operations.
     *
     * @param session
     *            the session
     * @param ssrvVO
     *            the ssrv vo
     * @param tpssVO
     *            the tpss vo
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    protected abstract void insertPostOperations(final @Nonnull SqlSession session,
            final @Nonnull SubservicioVO ssrvVO, final @Nonnull TipoSubservicioVO tpssVO, final Set<Long> ssrvPadreIds)
                    throws DuplicateInstanceException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void duplicate(final @Nonnull SubservicioVO ssrvVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

            // Depencias padre
            final SubservicioCriterioVO ssrvCriterioPadreVO = new SubservicioCriterioVO();

            ssrvCriterioPadreVO.setHijoId(ssrvVO.getId());

            final List<SubservicioSubservicioVO> ssrvPadresList = ssssDAO.selectList(ssrvCriterioPadreVO);

            // Dependencias hija hija
            final List<SubservicioSubservicioVO> ssrvHijosList = new ArrayList<>();
            final List<SubservicioSubservicioVO> ssrvHijosStepList = new ArrayList<>();
            final SubservicioCriterioVO ssrvCriterioHijoVO = new SubservicioCriterioVO();

            ssrvCriterioHijoVO.setPadreIds(Sets.newHashSet(ssrvVO.getId()));

            do {
                ssrvHijosStepList.clear();
                ssrvHijosStepList.addAll(ssssDAO.selectList(ssrvCriterioHijoVO));

                final Set<Long> ssrvPadreIds = new HashSet<>();

                for (final SubservicioSubservicioVO ssssVO : ssrvHijosStepList) {
                    ssrvPadreIds.add(ssssVO.getSsrvHijoId());
                }

                ssrvCriterioHijoVO.setPadreIds(ssrvPadreIds);
            } while (!ssrvHijosStepList.isEmpty());

            duplicatePostOperations(session, ssrvVO);

            session.commit();
        }

        throw new Error("No implementado");
    }

    /**
     * Duplicate post operations.
     *
     * @param session
     *            the session
     * @param ssrvVO
     *            the ssrv vo
     */
    protected abstract void duplicatePostOperations(final @Nonnull SqlSession session,
            final @Nonnull SubservicioVO ssrvVO);

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final @Nonnull SubservicioVO ssrvVO) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                itdtVO.setItemId(ssrvVO.getId());
                ssdtDAO.update(itdtVO);
            }

            updatePostOperations(session, ssrvVO);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param session
     *            the session
     * @param ssrvVO
     *            the ssrv vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    protected abstract void updatePostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO)
            throws InstanceNotFoundException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void delete(final @Nonnull Long srvcId, final @Nonnull Long ssrvId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            deletePostOperations(session, srvcId, ssrvId);

            session.commit();
        }

        throw new Error("No implementado");
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param srvcId
     *            the srvc id
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    protected abstract void deletePostOperations(final @Nonnull SqlSession session, final @Nonnull Long srvcId,
            final @Nonnull Long ssrvId) throws InstanceNotFoundException;

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param ssrvList
     *            the ssrv list
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param useIds
     *            the use ids
     */
    private final void fillDependencies(final @Nonnull SqlSession session, final @Nonnull List<SubservicioVO> ssrvList,
            final @Nonnull SubservicioCriterioVO ssrvCriterioVO, final boolean useIds) {
        final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

        // Datos asociados
        if (!ssrvList.isEmpty()) {
            if (useIds) {
                final Set<Long> ssrvIds = new HashSet<>();

                for (final SubservicioVO ssrvVO : ssrvList) {
                    ssrvIds.add(ssrvVO.getId());
                }

                ssrvCriterioVO.setIds(ssrvIds);
            }

            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : ssdtDAO.selectList(ssrvCriterioVO)) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
            }

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvVO.setItdtMap(itdtMap.get(ssrvVO.getId()));
            }

            if (useIds) {
                ssrvCriterioVO.setIds(null);
            }
        }
    }
}
