package xeredi.argo.model.servicio.bo;

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
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.proxy.TramiteProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioTramiteDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSubservicioBO.
 */
public class SubservicioBO {

    /** The enti id. */
    protected final transient Long entiId;

    /** The usro id. */
    protected final transient Long usroId;

    /**
     * Instantiates a new subservicio bo.
     *
     * @param aentiId
     *            the aenti id
     * @param ausroId
     *            the ausro id
     */
    protected SubservicioBO(final @NonNull Long aentiId, final @NonNull Long ausroId) {
        super();

        this.entiId = aentiId;
        this.usroId = ausroId;
    }

    /**
     * Select list.
     *
     * @param ssrvCriterio
     *            the ssrv criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, ssrvCriterio);

            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final int count = ssrvDAO.count(ssrvCriterio);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvList.addAll(ssrvDAO.selectList(ssrvCriterio, new RowBounds(offset, limit)));
                fillDependencies(session, ssrvList, ssrvCriterio, true);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param ssrvCriterio
     *            the ssrv criterio vo
     * @return the list
     */
    public final List<SubservicioVO> selectList(final @NonNull SubservicioCriterioVO ssrvCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, ssrvCriterio);

            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterio);

            fillDependencies(session, ssrvList, ssrvCriterio, false);

            return ssrvList;
        }
    }

    /**
     * Select label value object.
     *
     * @param ssrvCriterio
     *            the ssrv criterio vo
     * @return the label value vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final LabelValueVO selectLabelValueObject(final @NonNull SubservicioCriterioVO ssrvCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, ssrvCriterio);

            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterio);

            if (ssrv == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvCriterio);
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
            final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

            ssrvCriterio.setId(ssrvId);
            ssrvCriterio.setIdioma(idioma);

            fillUserSpecificFilter(session, ssrvCriterio);

            final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterio);

            if (ssrv == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvId);
            }

            fillDependencies(session, Arrays.asList(new SubservicioVO[] { ssrv }), ssrvCriterio, true);

            return ssrv;
        }
    }

    /**
     * Select lupa list.
     *
     * @param ssrvTypeaheadCriterio
     *            the ssrv typeahead criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public final List<SubservicioVO> selectTypeaheadList(final @NonNull SubservicioLupaCriterioVO ssrvTypeaheadCriterio,
            final int limit) {
        ssrvTypeaheadCriterio.setNumero(Integer.valueOf(ssrvTypeaheadCriterio.getTextoBusqueda()));

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

            return ssrvDAO.selectLupaList(ssrvTypeaheadCriterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
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
        Preconditions.checkNotNull(ssrvVO.getSrvc());
        Preconditions.checkNotNull(ssrvVO.getSrvc().getId());

        // FIXME En entidades padre, NO debería estar el propio tipo de servicio
        // if (tpssDetail.getEntiPadresList() != null && !tpssDetail.getEntiPadresList().isEmpty()) {
        // Preconditions.checkNotNull(ssrvPadreIds);
        // Preconditions.checkArgument(!ssrvPadreIds.isEmpty());
        // }

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

            if (ssrvDAO.exists(ssrvVO)) {
                throw new DuplicateInstanceException(ssrvVO.getEntiId(), ssrvVO);
            }

            IgUtilBO.assignNextVal(ssrvVO);

            ssrvDAO.insert(ssrvVO);

            for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);
                ssdtDAO.insert(itdtVO);
            }

            if (ssrvPadreIds != null) {
                for (final Long ssrvPadreId : ssrvPadreIds) {
                    final SubservicioSubservicioVO ssssVO = new SubservicioSubservicioVO(ssrvPadreId, ssrvVO.getId());

                    ssssDAO.insert(ssssVO);
                }
            }

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ssrvVO.getSrvc().getId());
            sracDAO.insert(ssrvVO.getSrvc().getId());

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
        Preconditions.checkNotNull(ssrvVO.getSrvc());
        Preconditions.checkNotNull(ssrvVO.getSrvc().getId());

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

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ssrvVO.getSrvc().getId());
            sracDAO.insert(ssrvVO.getSrvc().getId());

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
        Preconditions.checkNotNull(ssrvVO.getSrvc());
        Preconditions.checkNotNull(ssrvVO.getSrvc().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            if (ssrvVO.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                    itdtVO.setItemId(ssrvVO.getId());
                    ssdtDAO.update(itdtVO);
                }
            }

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ssrvVO.getSrvc().getId());
            sracDAO.insert(ssrvVO.getSrvc().getId());

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

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ssrv.getSrvc().getId());
            sracDAO.insert(ssrv.getSrvc().getId());

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

            IgUtilBO.assignNextVal(ittr);

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

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ssrv.getSrvc().getId());
            sracDAO.insert(ssrv.getSrvc().getId());

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

    private void fillUserSpecificFilter(final @NonNull SqlSession session,
            final @NonNull SubservicioCriterioVO ssrvCriterio) {
        ssrvCriterio.setEntiId(entiId);

        final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setId(usroId);

        final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

        if (usro == null) {
            throw new Error("Usuario no encontrado: " + usroId);
        }

        ssrvCriterio.setUsroId(usro.getId());

        if (usro.getSprt() != null) {
            ssrvCriterio.setUsroSprtId(usro.getSprt().getId());
        }

        if (usro.getPrto() != null) {
            ssrvCriterio.setUsroPrtoId(usro.getPrto().getId());
        }

        if (usro.getOrga() != null) {
            ssrvCriterio.setUsroOrgaId(usro.getPrto().getId());
        }
    }
}
