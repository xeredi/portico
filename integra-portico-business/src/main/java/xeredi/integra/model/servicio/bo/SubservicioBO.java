package xeredi.integra.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import lombok.NonNull;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.item.dao.ItemTramiteDAO;
import xeredi.integra.model.item.dao.ItemTramiteDatoDAO;
import xeredi.integra.model.item.vo.ItemTramiteDatoVO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioTramiteDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSubservicioBO.
 */
public class SubservicioBO {

    /**
     * Instantiates a new subservicio bo.
     */
    protected SubservicioBO() {
        super();
    }

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final int count = ssrvDAO.count(ssrvCriterioVO);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvList.addAll(ssrvDAO.selectList(ssrvCriterioVO, new RowBounds(offset, limit)));
                fillDependencies(session, ssrvList, ssrvCriterioVO, true);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    public final List<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);

            fillDependencies(session, ssrvList, ssrvCriterioVO, false);

            return ssrvList;
        }
    }

    /**
     * Select label value object.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the label value vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final LabelValueVO selectLabelValueObject(final @NonNull SubservicioCriterioVO ssrvCriterioVO)
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
     * Select.
     *
     * @param ssrvId
     *            the ssrv id
     * @param idioma
     *            the idioma
     * @return the subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final SubservicioVO select(final @NonNull Long ssrvId, final String idioma)
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
     * Select lupa list.
     *
     * @param ssrvLupaCriterioVO
     *            the ssrv lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    public final List<SubservicioVO> selectLupaList(final @NonNull SubservicioLupaCriterioVO ssrvLupaCriterioVO,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

            return ssrvDAO.selectLupaList(ssrvLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @param tpssDetail
     *            the tpss detail
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
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
    protected void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        // noop
    }

    /**
     * Duplicate.
     *
     * @param ssrvVO
     *            the ssrv vo
     */
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
    protected void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO) {
        // noop
    }

    /**
     * Update.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
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
    protected void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        // noop
    }

    /**
     * Delete.
     *
     * @param ssrv
     *            the ssrv
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
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

                ssdtDAO.deleteList(ssrvCriterio);
            }

            {
                final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
                final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

                ssrvCriterio.setPadreIds(ssrvIds);

                ssssDAO.deleteList(ssrvCriterio);
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
    protected void deletePostOperations(final SqlSession session, final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        // noop
    }

    /**
     * Statechange.
     *
     * @param ittr
     *            the ittr
     * @throws ModelException
     *             the model exception
     */
    public final void statechange(final @NonNull ItemTramiteVO ittr) throws ModelException {
        Preconditions.checkNotNull(ittr.getItemId());
        Preconditions.checkNotNull(ittr.getTrmt());
        Preconditions.checkNotNull(ittr.getTrmt().getId());
        Preconditions.checkNotNull(ittr.getTrmt().getEntiId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final IgBO igBO = new IgBO();

            // Modificacion del subservicio
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

            ssrvCriterio.setId(ittr.getItemId());

            final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterio);

            if (ssrv == null) {
                throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
            }

            ssrv.setFini(ittr.getDitemFini());
            ssrv.setFfin(ittr.getDitemFfin());

            ssrvDAO.update(ssrv);

            // Alta del tramite
            final TramiteDetailVO trmtDetail = TramiteProxy.select(ittr.getTrmt().getId());

            ittr.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            ittr.setFecha(Calendar.getInstance().getTime());

            if (ssrvDAO.updateEstado(ittr) == 0) {
                throw new InstanceNotFoundException(ssrv.getEntiId(), ssrv.getId());
            }

            final ItemTramiteDAO ittrDAO = session.getMapper(ItemTramiteDAO.class);
            final SubservicioTramiteDAO sstrDAO = session.getMapper(SubservicioTramiteDAO.class);

            ittrDAO.insert(ittr);
            sstrDAO.insert(ittr);

            // Modificacion de los datos del subservicio introducidos en el tramite (si los hay)
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final ItemTramiteDatoDAO ittdDAO = session.getMapper(ItemTramiteDatoDAO.class);

            for (final Long tpdtId : ittr.getIttdMap().keySet()) {
                final ItemTramiteDatoVO ittd = ittr.getIttdMap().get(tpdtId);

                ittd.setTpdtId(tpdtId);
                ittd.setIttrId(ittr.getId());

                final ItemDatoVO itdt = new ItemDatoVO();

                itdt.setItemId(ittr.getItemId());
                itdt.setTpdtId(tpdtId);
                itdt.setCantidadEntera(ittd.getDnentero());
                itdt.setCantidadDecimal(ittd.getDndecimal());
                itdt.setCadena(ittd.getDcadena());
                itdt.setFecha(ittd.getDfecha());
                itdt.setPrmt(ittd.getDprmt());
                itdt.setSrvc(ittd.getDsrvc());

                ssdtDAO.update(itdt);
                ittdDAO.insert(ittd);
            }

            statechangePostOperations(session, ssrv, ittr, trmtDetail);

            session.commit();
        }
    }

    /**
     * Statechange post operations.
     *
     * @param session
     *            the session
     * @param ssrv
     *            the ssrv
     * @param ittr
     *            the ittr
     * @param trmtDetail
     *            the trmt detail
     * @throws ModelException
     *             the model exception
     */
    protected void statechangePostOperations(final SqlSession session, final SubservicioVO ssrv,
            final ItemTramiteVO ittr, final TramiteDetailVO trmtDetail) throws ModelException {
        // noop
    }

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
    private final void fillDependencies(final @NonNull SqlSession session, final @NonNull List<SubservicioVO> ssrvList,
            final @NonNull SubservicioCriterioVO ssrvCriterioVO, final boolean useIds) {
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
