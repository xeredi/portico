package xeredi.argo.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.auditoria.bo.Auditable;
import xeredi.argo.model.auditoria.bo.EventoAuditoriaUtils;
import xeredi.argo.model.auditoria.vo.AuditoriaAccion;
import xeredi.argo.model.auditoria.vo.AuditoriaPrefijoEntidad;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.proxy.TramiteProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.ServicioArchivoDAO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.dao.ServicioDatoDAO;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.dao.ServicioTramiteDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.vo.ServicioArchivoVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractServicioBO.
 */
@Data
public class ServicioBO implements Auditable {

    /** The enti id. */
    protected final transient Long entiId;

    /** The usro id. */
    protected final transient Long usroId;

    /**
     * Instantiates a new servicio bo.
     *
     * @param aentiId
     *            the aenti id
     * @param ausroId
     *            the ausro id
     */
    protected ServicioBO(final @NonNull Long aentiId, final @NonNull Long ausroId) {
        super();

        this.entiId = aentiId;
        this.usroId = ausroId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditoriaPrefijoEntidad getPrefijoEntidad() {
        return AuditoriaPrefijoEntidad.srvc;
    }

    /**
     * Select.
     *
     * @param srvcId
     *            the srvc id
     * @param idioma
     *            the idioma
     * @return the servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final ServicioVO select(final @NonNull Long srvcId, final String idioma) throws InstanceNotFoundException {
        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(srvcId);
        srvcCriterioVO.setIdioma(idioma);

        return selectObject(srvcCriterioVO);
    }

    /**
     * Select object.
     *
     * @param srvcCriterio
     *            the srvc criterio vo
     * @return the servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final ServicioVO selectObject(final @NonNull ServicioCriterioVO srvcCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, srvcCriterio);

            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterio);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcCriterio);
            }

            fillDependencies(session, Arrays.asList(new ServicioVO[] { srvcVO }), srvcCriterio, true);

            return srvcVO;
        }
    }

    /**
     * Select list.
     *
     * @param srvcCriterio
     *            the srvc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<ServicioVO> selectList(final @NonNull ServicioCriterioVO srvcCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, srvcCriterio);

            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final int count = srvcDAO.count(srvcCriterio);
            final List<ServicioVO> srvcList = new ArrayList<>();

            if (count > offset) {
                srvcList.addAll(srvcDAO.selectList(srvcCriterio, new RowBounds(offset, limit)));

                fillDependencies(session, srvcList, srvcCriterio, true);
            }

            return new PaginatedList<>(srvcList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param srvcCriterio
     *            the srvc criterio vo
     * @return the list
     */
    public final List<ServicioVO> selectList(final @NonNull ServicioCriterioVO srvcCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, srvcCriterio);

            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final List<ServicioVO> srvcList = srvcDAO.selectList(srvcCriterio);

            fillDependencies(session, srvcList, srvcCriterio, false);

            return srvcList;
        }
    }

    /**
     * Select lupa list.
     *
     * @param criterio
     *            the srvc typeahead criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public final List<ServicioVO> selectTypeaheadList(final @NonNull ServicioTypeaheadCriterioVO criterio,
            final int limit) {
        Preconditions.checkNotNull(criterio.getTextoBusqueda());

        final StringTokenizer tokenizer = new StringTokenizer(criterio.getTextoBusqueda(), "/");

        criterio.setSubpuerto(tokenizer.nextToken().toUpperCase());

        if (tokenizer.hasMoreTokens()) {
            criterio.setAnno(tokenizer.nextToken() + "%");
        }

        if (tokenizer.hasMoreTokens()) {
            criterio.setNumero(tokenizer.nextToken() + "%");
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);

            return srvcDAO.selectTypeaheadList(criterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param srvc
     *            the srvc
     * @param ssrvList
     *            the ssrv list
     * @param ssssList
     *            the ssss list
     * @param archId
     *            the arch id
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final @NonNull ServicioVO srvc, final List<SubservicioVO> ssrvList,
            final List<SubservicioSubservicioVO> ssssList, final Long archId) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioArchivoDAO srarDAO = session.getMapper(ServicioArchivoDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            final Map<Long, Long> ssrvDepsMap = new HashMap<Long, Long>();

            final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(srvc.getEntiId());

            if (tpsrDetail.getEntdList() != null) {
                if (srvc.getItdtMap() == null) {
                    srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());
                }

                for (final Long tpdtId : tpsrDetail.getEntdList()) {
                    if (!srvc.getItdtMap().containsKey(tpdtId)) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        srvc.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            srscDAO.incrementarSecuencia(srvc);

            final Integer secuencia = srscDAO.obtenerSecuencia(srvc);

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + srvc);
            }

            srvc.setNumero(ServicioVO.convertNumero(secuencia));

            if (srvcDAO.exists(srvc)) {
                throw new DuplicateInstanceException(srvc.getEntiId(), srvc);
            }

            IgUtilBO.assignNextVal(srvc);

            srvcDAO.insert(srvc);

            if (srvc.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : srvc.getItdtMap().values()) {
                    itdtVO.setItemId(srvc.getId());
                    srdtDAO.insert(itdtVO);
                }
            }

            if (ssrvList != null) {
                for (final SubservicioVO ssrvVO : ssrvList) {
                    final SubservicioVO ssrvNew = new SubservicioVO();

                    IgUtilBO.assignNextVal(ssrvNew);

                    if (ssrvVO.getId() != null) {
                        ssrvDepsMap.put(ssrvVO.getId(), ssrvNew.getId());
                    }

                    ssrvVO.setId(ssrvNew.getId());
                    ssrvVO.setSrvc(srvc);
                    ssrvDAO.insert(ssrvVO);

                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(ssrvVO.getEntiId());

                    if (tpssDetail.getEntdList() != null) {
                        if (ssrvVO.getItdtMap() == null) {
                            ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                        }

                        for (final Long tpdtId : tpsrDetail.getEntdList()) {
                            if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
                                final ItemDatoVO itdt = new ItemDatoVO();

                                itdt.setTpdtId(tpdtId);
                                ssrvVO.getItdtMap().put(tpdtId, itdt);
                            }
                        }
                    }
                }

                for (final SubservicioVO ssrvVO : ssrvList) {
                    if (ssrvVO.getItdtMap() != null) {
                        for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                            itdtVO.setItemId(ssrvVO.getId());
                            ssdtDAO.insert(itdtVO);
                        }
                    }
                }
            }

            if (ssssList != null) {
                for (final SubservicioSubservicioVO ssssVO : ssssList) {
                    ssssDAO.insert(new SubservicioSubservicioVO(ssrvDepsMap.get(ssssVO.getSsrvPadreId()),
                            ssrvDepsMap.get(ssssVO.getSsrvHijoId())));
                }
            }

            if (archId != null) {
                final ServicioArchivoVO srar = new ServicioArchivoVO();

                srar.setSrvcId(srvc.getId());
                srar.setArchId(archId);

                srarDAO.insert(srar);
            }

            sracDAO.insert(srvc.getId());

            insertPostOperations(session, srvc, ssrvList, ssssList);

            if (ConfigurationProxy.getBoolean(ConfigurationKey.audit_enabled)) {
                EventoAuditoriaUtils.insert(session, this, AuditoriaAccion.INSERT);
            }

            session.commit();
        }
    }

    /**
     * Insert post operations.
     *
     * @param session
     *            the session
     * @param srvcVO
     *            the srvc vo
     * @param ssrvList
     *            the ssrv list
     * @param ssssList
     *            the ssss list
     */
    protected void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        // noop
    }

    /**
     * Insert list.
     *
     * @param srvcMap
     *            the srvc map
     * @param ssrvMap
     *            the ssrv map
     * @param ssssMap
     *            the ssss map
     * @param archId
     *            the arch id
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insertList(final @NonNull Map<String, ServicioVO> srvcMap,
            final Map<String, List<SubservicioVO>> ssrvMap, final Map<String, List<SubservicioSubservicioVO>> ssssMap,
            final Long archId) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioArchivoDAO srarDAO = session.getMapper(ServicioArchivoDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            final Map<Long, Long> ssrvDepsMap = new HashMap<Long, Long>();

            for (final String key : srvcMap.keySet()) {
                final ServicioVO srvc = srvcMap.get(key);
                final List<SubservicioVO> ssrvList = ssrvMap == null ? null : ssrvMap.get(key);
                final List<SubservicioSubservicioVO> ssssList = ssssMap == null ? null : ssssMap.get(key);

                final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(srvc.getEntiId());

                if (tpsrDetail.getEntdList() != null) {
                    if (srvc.getItdtMap() == null) {
                        srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    }

                    for (final Long tpdtId : tpsrDetail.getEntdList()) {
                        if (!srvc.getItdtMap().containsKey(tpdtId)) {
                            final ItemDatoVO itdt = new ItemDatoVO();

                            itdt.setTpdtId(tpdtId);
                            srvc.getItdtMap().put(tpdtId, itdt);
                        }
                    }
                }

                srscDAO.incrementarSecuencia(srvc);

                final Integer secuencia = srscDAO.obtenerSecuencia(srvc);

                if (secuencia == null) {
                    throw new Error("No se encuentra secuencia para: " + srvc);
                }

                srvc.setNumero(ServicioVO.convertNumero(secuencia));

                if (srvcDAO.exists(srvc)) {
                    throw new DuplicateInstanceException(srvc.getEntiId(), srvc);
                }

                IgUtilBO.assignNextVal(srvc);

                srvcDAO.insert(srvc);

                if (srvc.getItdtMap() != null) {
                    for (final ItemDatoVO itdtVO : srvc.getItdtMap().values()) {
                        itdtVO.setItemId(srvc.getId());
                        srdtDAO.insert(itdtVO);
                    }
                }

                if (ssrvList != null) {
                    for (final SubservicioVO ssrvVO : ssrvList) {
                        final SubservicioVO ssrvNew = new SubservicioVO();

                        IgUtilBO.assignNextVal(ssrvNew);

                        if (ssrvVO.getId() != null) {
                            ssrvDepsMap.put(ssrvVO.getId(), ssrvNew.getId());
                        }

                        ssrvVO.setId(ssrvNew.getId());
                        ssrvVO.setSrvc(srvc);
                        ssrvDAO.insert(ssrvVO);

                        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(ssrvVO.getEntiId());

                        if (tpssDetail.getEntdList() != null) {
                            if (ssrvVO.getItdtMap() == null) {
                                ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                            }

                            for (final Long tpdtId : tpsrDetail.getEntdList()) {
                                if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
                                    final ItemDatoVO itdt = new ItemDatoVO();

                                    itdt.setTpdtId(tpdtId);
                                    ssrvVO.getItdtMap().put(tpdtId, itdt);
                                }
                            }
                        }
                    }

                    for (final SubservicioVO ssrvVO : ssrvList) {
                        if (ssrvVO.getItdtMap() != null) {
                            for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                                itdtVO.setItemId(ssrvVO.getId());
                                ssdtDAO.insert(itdtVO);
                            }
                        }
                    }
                }

                if (ssssList != null) {
                    for (final SubservicioSubservicioVO ssssVO : ssssList) {
                        ssssDAO.insert(new SubservicioSubservicioVO(ssrvDepsMap.get(ssssVO.getSsrvPadreId()),
                                ssrvDepsMap.get(ssssVO.getSsrvHijoId())));
                    }
                }

                if (archId != null) {
                    final ServicioArchivoVO srar = new ServicioArchivoVO();

                    srar.setSrvcId(srvc.getId());
                    srar.setArchId(archId);

                    srarDAO.insert(srar);
                }

                sracDAO.insert(srvc.getId());

                insertPostOperations(session, srvc, ssrvList, ssssList);
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param srvc
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    public final void update(final @NonNull ServicioVO srvc) throws ModelException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            for (final ItemDatoVO itdt : srvc.getItdtMap().values()) {
                itdt.setItemId(srvc.getId());
                srdtDAO.update(itdt);
            }

            // TODO Actualizar datos del servicio??

            sracDAO.deleteList(srvc.getId());
            sracDAO.insert(srvc.getId());

            updatePostOperations(session, srvc);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param session
     *            the session
     * @param srvcVO
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * Duplicate.
     *
     * @param srvcVO
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    public final void duplicate(final @NonNull ServicioVO srvcVO) throws ModelException {
        Preconditions.checkNotNull(srvcVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            final Map<Long, Long> ssrvIds = new HashMap<>();

            // Busqueda de los elementos a duplicar
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
            final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

            srvcCriterioVO.setId(srvcVO.getId());
            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            ssssCriterio.setSrvcId(srvcVO.getId());

            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);
            final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);
            final List<SubservicioSubservicioVO> ssssList = ssssDAO.selectList(ssssCriterio);

            // Duplicado del servicio. Se duplica el propio servicio y sus datos
            // asociados, los
            // subservicios y
            // los datos asociados, y las relaciones entre subservicios.
            srscDAO.incrementarSecuencia(srvcVO);

            final Integer secuencia = srscDAO.obtenerSecuencia(srvcVO);
            final Long srvcIdActual = srvcVO.getId();

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + srvcVO.getEtiqueta());
            }

            IgUtilBO.assignNextVal(srvcVO);

            srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

            for (final SubservicioVO ssrvVO : ssrvList) {
                final Long ssrvIdActual = ssrvVO.getId();

                IgUtilBO.assignNextVal(ssrvVO);

                ssrvVO.setSrvc(srvcVO);

                ssrvIds.put(ssrvIdActual, ssrvVO.getId());
            }

            srvcDAO.insert(srvcVO);

            for (final Object tpdtId : srvcVO.getItdtMap().keySet()) {
                final ItemDatoVO itdtVO = srvcVO.getItdtMap().get(tpdtId);

                itdtVO.setTpdtId(tpdtId instanceof Long ? (Long) tpdtId : Long.parseLong(tpdtId.toString()));
                itdtVO.setItemId(srvcVO.getId());

                srdtDAO.insert(itdtVO);
            }

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvDAO.insert(ssrvVO);
            }

            for (final ItemDatoVO ssdtVO : ssdtList) {
                ssdtVO.setItemId(ssrvIds.get(ssdtVO.getItemId()));

                ssdtDAO.insert(ssdtVO);
            }

            for (final SubservicioSubservicioVO ssssVO : ssssList) {
                ssssDAO.insert(new SubservicioSubservicioVO(ssrvIds.get(ssssVO.getSsrvPadreId()),
                        ssrvIds.get(ssssVO.getSsrvHijoId())));
            }

            sracDAO.insert(srvcVO.getId());

            duplicatePostOperations(session, srvcVO);

            session.commit();
        }
    }

    /**
     * Duplicate.
     *
     * @param session
     *            the session
     * @param srvcVO
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * Delete.
     *
     * @param srvc
     *            the srvc
     * @throws ModelException
     *             the model exception
     */
    public final void delete(final @NonNull ServicioVO srvc) throws ModelException {
        Preconditions.checkNotNull(srvc.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioArchivoDAO srarDAO = session.getMapper(ServicioArchivoDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();
            final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
            final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

            srvcCriterio.setId(srvc.getId());
            ssrvCriterio.setSrvc(srvcCriterio);
            ssssCriterio.setSrvcId(srvc.getId());

            ssssDAO.deleteList(ssssCriterio);
            ssdtDAO.deleteList(ssrvCriterio);
            ssrvDAO.deleteList(ssrvCriterio);
            srdtDAO.deleteList(srvcCriterio);
            srarDAO.deleteList(srvc.getId());
            sracDAO.deleteList(srvc.getId());

            final int updated = srvcDAO.delete(srvc);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvc);
            }

            deletePostOperations(session, srvc);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param srvc
     *            the srvc
     * @throws ModelException
     *             the model exception
     */
    protected void deletePostOperations(final SqlSession session, final ServicioVO srvc) throws ModelException {
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
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

            srvcCriterio.setId(ittr.getItemId());

            final ServicioVO srvc = srvcDAO.selectObject(srvcCriterio);

            if (srvc == null) {
                throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
            }

            if (srvcDAO.updateEstado(ittr) == 0) {
                throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
            }

            final ServicioTramiteDAO srtrDAO = session.getMapper(ServicioTramiteDAO.class);
            final ItemTramiteDAO ittrDAO = session.getMapper(ItemTramiteDAO.class);
            final TramiteDetailVO trmtDetail = TramiteProxy.select(ittr.getTrmt().getId());

            IgUtilBO.assignNextVal(ittr);

            ittr.setFecha(Calendar.getInstance().getTime());

            ittrDAO.insert(ittr);
            srtrDAO.insert(ittr);

            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
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

                srdtDAO.update(itdt);
                ittdDAO.insert(ittd);
            }

            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            sracDAO.deleteList(ittr.getItemId());
            sracDAO.insert(ittr.getItemId());

            statechangePostOperations(session, srvc, ittr, trmtDetail);

            session.commit();
        }
    }

    /**
     * Statechange post operations.
     *
     * @param session
     *            the session
     * @param srvc
     *            the srvc
     * @param srtr
     *            the srtr
     * @param trmtDetail
     *            the trmt detail
     * @throws ModelException
     *             the model exception
     */
    protected void statechangePostOperations(final SqlSession session, final ServicioVO srvc, final ItemTramiteVO srtr,
            final TramiteDetailVO trmtDetail) throws ModelException {
        // noop
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param srvcList
     *            the srvc list
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @param useIds
     *            the use ids
     */
    private final void fillDependencies(final @NonNull SqlSession session, final @NonNull List<ServicioVO> srvcList,
            final @NonNull ServicioCriterioVO srvcCriterioVO, final boolean useIds) {
        final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);

        if (!srvcList.isEmpty()) {
            if (useIds) {
                final Set<Long> srvcIds = new HashSet<>();

                for (final ServicioVO srvcVO : srvcList) {
                    srvcIds.add(srvcVO.getId());
                }

                srvcCriterioVO.setIds(srvcIds);
            }

            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : srdtDAO.selectList(srvcCriterioVO)) {
                if (!map.containsKey(itdtVO.getItemId())) {
                    map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
            }

            for (final ServicioVO srvcVO : srvcList) {
                srvcVO.setItdtMap(map.get(srvcVO.getId()));
            }

            if (useIds) {
                srvcCriterioVO.setIds(null);
            }
        }
    }

    /**
     * Fill user specific filter.
     *
     * @param session
     *            the session
     * @param srvcCriterio
     *            the srvc criterio
     */
    private void fillUserSpecificFilter(final @NonNull SqlSession session,
            final @NonNull ServicioCriterioVO srvcCriterio) {
        srvcCriterio.setEntiId(entiId);

        final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setId(usroId);

        final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

        if (usro == null) {
            throw new Error("Usuario no encontrado: " + usroId);
        }

        srvcCriterio.setUsroId(usro.getId());

        if (usro.getSprt() != null) {
            srvcCriterio.setUsroSprtId(usro.getSprt().getId());
        }

        if (usro.getPrto() != null) {
            srvcCriterio.setUsroPrtoId(usro.getPrto().getId());
        }

        if (usro.getOrga() != null) {
            srvcCriterio.setUsroOrgaId(usro.getPrto().getId());
        }
    }
}
