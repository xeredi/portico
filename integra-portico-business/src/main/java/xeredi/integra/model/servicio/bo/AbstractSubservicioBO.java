package xeredi.integra.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
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

import com.google.common.base.Preconditions;
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
    public final PaginatedList<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final int count = ssrvDAO.selectCount(ssrvCriterioVO);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvList.addAll(ssrvDAO.selectList(ssrvCriterioVO, new RowBounds(offset, limit)));
                fillDependencies(session, ssrvList, ssrvCriterioVO, true);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
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
    public LabelValueVO selectLabelValueObject(final @NonNull SubservicioCriterioVO ssrvCriterioVO)
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
    public final SubservicioVO select(final @NonNull Long ssrvId, final String idioma) throws InstanceNotFoundException {
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
    public final List<SubservicioVO> selectLupaList(final @NonNull SubservicioLupaCriterioVO ssrvLupaCriterioVO,
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
    public final void insert(final @NonNull SubservicioVO ssrvVO, final @NonNull TipoSubservicioDetailVO tpssDetail,
            final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

            if (tpssDetail.getEntdList() != null) {
                for (final Long tpdtId : tpssDetail.getEntdList()) {
                    if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
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

            insertPostOperations(session, ssrvVO, tpssDetail, ssrvPadreIds);

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
     * @param tpssDetail
     *            the tpss detail
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    protected abstract void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void duplicate(final @NonNull SubservicioVO ssrvVO) {
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
    protected abstract void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO);

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final @NonNull SubservicioVO ssrvVO) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            if (ssrvVO.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                    itdtVO.setItemId(ssrvVO.getId());
                    ssdtDAO.update(itdtVO);
                }
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
    protected abstract void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void delete(final @NonNull SubservicioVO ssrv) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrv.getId());
        Preconditions.checkNotNull(ssrv.getEntiId());
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            // Busqueda de los padres del subservicio a borrar
            {
                final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setHijoId(ssrv.getId());

                final List<SubservicioVO> ssrvPadres = ssrvDAO.selectList(ssrvCriterio);
            }

            final Set<Long> ssrvIds = new HashSet<Long>();

            ssrvIds.add(ssrv.getId());

            // Busqueda de los hijos del Subservicio a borrar
            {
                final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setPadreIds(ssrvIds);

                boolean process = true;

                while (process) {
                    final List<SubservicioVO> ssrvHijos = ssrvDAO.selectList(ssrvCriterio);

                    if (ssrvHijos.isEmpty()) {
                        process = false;
                    }

                    final Set<Long> ssrvStepIds = new HashSet<Long>();

                    for (final SubservicioVO ssrvHijo : ssrvHijos) {
                        ssrvStepIds.add(ssrvHijo.getId());
                    }

                    ssrvIds.addAll(ssrvStepIds);
                    ssrvCriterio.setPadreIds(ssrvStepIds);
                }
            }

            Preconditions.checkArgument(!ssrvIds.isEmpty());

            {

                final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setIds(ssrvIds);

                ssdtDAO.delete(ssrvCriterio);
            }

            {
                final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setPadreIds(ssrvIds);

                ssssDAO.delete(ssrvCriterio);
            }

            {
                final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setIds(ssrvIds);

                ssrvDAO.deleteList(ssrvCriterio);
            }

            // FIXME Habria que pasar a deletePostOperations los padres del subservicio eliminado
            deletePostOperations(session, ssrv);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param ssrv
     *            the ssrv
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    protected abstract void deletePostOperations(final SqlSession session, final SubservicioVO ssrv)
            throws InstanceNotFoundException;

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
    private final void fillDependencies(final SqlSession session, final List<SubservicioVO> ssrvList,
            final SubservicioCriterioVO ssrvCriterioVO, final boolean useIds) {
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
