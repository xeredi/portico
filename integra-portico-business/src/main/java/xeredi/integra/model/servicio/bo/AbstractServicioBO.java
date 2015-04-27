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
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.servicio.dao.ServicioArchivoDAO;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.dao.ServicioDatoDAO;
import xeredi.integra.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioArchivoVO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractServicioBO.
 */
public abstract class AbstractServicioBO implements ServicioBO {
    /**
     * {@inheritDoc}
     */
    @Override
    public final ServicioVO select(final @NonNull Long srvcId, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);
            srvcCriterioVO.setIdioma(idioma);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcId);
            }

            fillDependencies(session, Arrays.asList(new ServicioVO[] { srvcVO }), srvcCriterioVO, true);

            return srvcVO;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ServicioVO selectObject(final @NonNull ServicioCriterioVO srvcCriterioVO)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new ServicioVO[] { srvcVO }), srvcCriterioVO, true);

            return srvcVO;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final PaginatedList<ServicioVO> selectList(final @NonNull ServicioCriterioVO srvcCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final int count = srvcDAO.count(srvcCriterioVO);
            final List<ServicioVO> srvcList = new ArrayList<>();

            if (count > offset) {
                srvcList.addAll(srvcDAO.selectList(srvcCriterioVO, new RowBounds(offset, limit)));

                fillDependencies(session, srvcList, srvcCriterioVO, true);
            }

            return new PaginatedList<>(srvcList, offset, limit, count);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<ServicioVO> selectList(final @NonNull ServicioCriterioVO srvcCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final List<ServicioVO> srvcList = srvcDAO.selectList(srvcCriterioVO);

            fillDependencies(session, srvcList, srvcCriterioVO, false);

            return srvcList;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<ServicioVO> selectLupaList(final @NonNull ServicioLupaCriterioVO srvcLupaCriterioVO,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);

            return srvcDAO.selectLupaList(srvcLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
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

            final Map<Long, Long> ssrvDepsMap = new HashMap<Long, Long>();

            final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(srvc.getEntiId());

            if (tpsrDetail.getEntdList() != null) {
                if (srvc.getItdtMap() == null) {
                    srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());
                }

                for (final EntidadTipoDatoVO entd : tpsrDetail.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!srvc.getItdtMap().containsKey(tpdtId)) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        srvc.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            final IgBO igBO = new IgBO();

            srscDAO.incrementarSecuencia(srvc);

            final Integer secuencia = srscDAO.obtenerSecuencia(srvc);

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + srvc);
            }

            srvc.setNumero(ServicioVO.convertNumero(secuencia));

            if (srvcDAO.exists(srvc)) {
                throw new DuplicateInstanceException(srvc.getEntiId(), srvc);
            }

            srvc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            srvcDAO.insert(srvc);

            if (srvc.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : srvc.getItdtMap().values()) {
                    itdtVO.setItemId(srvc.getId());
                    srdtDAO.insert(itdtVO);
                }
            }

            if (ssrvList != null) {
                for (final SubservicioVO ssrvVO : ssrvList) {
                    final Long ssrvId = igBO.nextVal(IgBO.SQ_INTEGRA);

                    if (ssrvVO.getId() != null) {
                        ssrvDepsMap.put(ssrvVO.getId(), ssrvId);
                    }

                    ssrvVO.setId(ssrvId);
                    ssrvVO.setSrvc(srvc);
                    ssrvDAO.insert(ssrvVO);

                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(ssrvVO.getEntiId());

                    if (tpssDetail.getEntdList() != null) {
                        if (ssrvVO.getItdtMap() == null) {
                            ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                        }

                        for (final EntidadTipoDatoVO entd : tpssDetail.getEntdList()) {
                            final Long tpdtId = entd.getTpdt().getId();

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
                    ssssDAO.insert(new SubservicioSubservicioVO(ssrvDepsMap.get(ssssVO.getSsrvPadreId()), ssrvDepsMap
                            .get(ssssVO.getSsrvHijoId())));
                }
            }

            if (archId != null) {
                final ServicioArchivoVO srar = new ServicioArchivoVO();

                srar.setSrvcId(srvc.getId());
                srar.setArchId(archId);

                srarDAO.insert(srar);
            }

            insertPostOperations(session, srvc, ssrvList, ssssList);

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
    protected abstract void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList);

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final @NonNull ServicioVO srvcVO) throws ModelException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);

            for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
                itdtVO.setItemId(srvcVO.getId());
                srdtDAO.update(itdtVO);
            }

            // TODO Actualizar datos del servicio??

            updatePostOperations(session, srvcVO);

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
    protected abstract void updatePostOperations(final SqlSession session, final ServicioVO srvcVO)
            throws ModelException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void duplicate(final @NonNull ServicioVO srvcVO) throws ModelException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

            final IgBO igBO = new IgBO();
            final Map<Long, Long> ssrvIds = new HashMap<>();

            // Busqueda de los elementos a duplicar
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            srvcCriterioVO.setId(srvcVO.getId());
            ssrvCriterioVO.setSrvc(srvcCriterioVO);

            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);
            final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);
            final List<SubservicioSubservicioVO> ssssList = ssssDAO.selectList(ssrvCriterioVO);

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

            srvcVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

            for (final SubservicioVO ssrvVO : ssrvList) {
                final Long ssrvIdActual = ssrvVO.getId();

                ssrvVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
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
                ssssDAO.insert(new SubservicioSubservicioVO(ssrvIds.get(ssssVO.getSsrvPadreId()), ssrvIds.get(ssssVO
                        .getSsrvHijoId())));
            }

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
    protected abstract void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO)
            throws ModelException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void delete(final @NonNull Long srvcId) throws ModelException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final ServicioArchivoDAO srarDAO = session.getMapper(ServicioArchivoDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            srvcCriterioVO.setId(srvcId);
            ssrvCriterioVO.setSrvc(srvcCriterioVO);

            ssssDAO.delete(ssrvCriterioVO);
            ssdtDAO.delete(ssrvCriterioVO);
            ssrvDAO.deleteList(ssrvCriterioVO);
            srdtDAO.delete(srvcCriterioVO);
            srarDAO.deleteList(srvcId);

            final int updated = srvcDAO.delete(srvcId);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcId);
            }

            deletePostOperations(session, srvcId);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param srvcId
     *            the srvc id
     * @throws ModelException
     *             the model exception
     */
    protected abstract void deletePostOperations(final SqlSession session, final Long srvcId) throws ModelException;

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
}
