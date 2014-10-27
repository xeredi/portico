package xeredi.integra.model.servicio.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.dao.ServicioDatoDAO;
import xeredi.integra.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioBO.
 */
public class ServicioBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioBO.class);

    /** The srvc dao. */
    ServicioDAO srvcDAO;

    /** The srsc dao. */
    ServicioSecuenciaDAO srscDAO;

    /** The srdt dao. */
    ServicioDatoDAO srdtDAO;

    /** The ssrv dao. */
    SubservicioDAO ssrvDAO;

    /** The ssdt dao. */
    SubservicioDatoDAO ssdtDAO;

    /** The ssss dao. */
    SubservicioSubservicioDAO ssssDAO;

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
    public final ServicioVO select(final Long srvcId, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(srvcId);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            srvcDAO = session.getMapper(ServicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);
            srvcCriterioVO.setIdioma(idioma);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
            }

            fillDependencies(session, Arrays.asList(new ServicioVO[] { srvcVO }), srvcCriterioVO, true);

            return srvcVO;
        }
    }

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(srvcCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            srvcDAO = session.getMapper(ServicioDAO.class);

            final int count = srvcDAO.selectCount(srvcCriterioVO);
            final List<ServicioVO> srvcList = new ArrayList<>();

            if (count > offset) {
                srvcCriterioVO.setOffset(offset);
                srvcCriterioVO.setLimit(limit);

                srvcList.addAll(srvcDAO.selectPaginatedList(srvcCriterioVO));
                fillDependencies(session, srvcList, srvcCriterioVO, true);
            }

            return new PaginatedList<>(srvcList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    public final List<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO) {
        Preconditions.checkNotNull(srvcCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            srvcDAO = session.getMapper(ServicioDAO.class);

            final List<ServicioVO> srvcList = srvcDAO.selectList(srvcCriterioVO);

            fillDependencies(session, srvcList, srvcCriterioVO, false);

            return srvcList;
        }
    }

    /**
     * Select lupa list.
     *
     * @param srvcLupaCriterioVO
     *            the srvc lupa criterio vo
     * @return the list
     */
    public final List<ServicioVO> selectLupaList(final ServicioLupaCriterioVO srvcLupaCriterioVO, final int limit) {
        Preconditions.checkNotNull(srvcLupaCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            srvcDAO = session.getMapper(ServicioDAO.class);

            return srvcDAO.selectLupaList(srvcLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param srvcVO
     *            the srvc vo
     * @param tpsrVO
     *            the tpsr vo
     * @param ssrvList
     *            the ssrv list
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final ServicioVO srvcVO, final TipoServicioVO tpsrVO, final List<SubservicioVO> ssrvList)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(srvcVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            srdtDAO = session.getMapper(ServicioDatoDAO.class);
            ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

            if (tpsrVO.getEntdList() != null && !tpsrVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpsrVO.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!srvcVO.getItdtMap().containsKey(tpdtId) && !srvcVO.getItdtMap().containsKey(tpdtId.toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        srvcVO.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            final IgBO igBO = new IgBO();

            srscDAO.incrementarSecuencia(srvcVO);

            final Integer secuencia = srscDAO.obtenerSecuencia(srvcVO);

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + srvcVO);
            }

            srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

            if (srvcDAO.exists(srvcVO)) {
                throw new DuplicateInstanceException(ServicioVO.class.getName(), srvcVO);
            }

            srvcVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            srvcDAO.insert(srvcVO);

            if (srvcVO.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
                    itdtVO.setItemId(srvcVO.getId());
                    srdtDAO.insert(itdtVO);
                }
            }

            if (ssrvList != null) {
                for (final SubservicioVO ssrvVO : ssrvList) {
                    ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                    ssrvVO.setSrvc(srvcVO);
                    ssrvDAO.insert(ssrvVO);
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

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param srvcVO
     *            the srvc vo
     */
    public final void update(final ServicioVO srvcVO) {
        Preconditions.checkNotNull(srvcVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srdtDAO = session.getMapper(ServicioDatoDAO.class);

            for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
                srdtDAO.update(itdtVO);
            }

            // TODO Actualizar datos del servicio??

            session.commit();
        }
    }

    /**
     * Duplicate.
     *
     * @param srvcVO
     *            the srvc vo
     */
    public final void duplicate(final ServicioVO srvcVO) {
        Preconditions.checkNotNull(srvcVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            srdtDAO = session.getMapper(ServicioDatoDAO.class);
            ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

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

            srvcVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

            for (final SubservicioVO ssrvVO : ssrvList) {
                final Long ssrvIdActual = ssrvVO.getId();

                ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                ssrvVO.setSrvc(srvcVO);

                ssrvIds.put(ssrvIdActual, ssrvVO.getId());
            }

            srvcDAO.insert(srvcVO);

            for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
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

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long srvcId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            srdtDAO = session.getMapper(ServicioDatoDAO.class);
            ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            srvcCriterioVO.setId(srvcId);
            ssrvCriterioVO.setSrvc(srvcCriterioVO);

            ssssDAO.delete(ssrvCriterioVO);
            ssdtDAO.delete(ssrvCriterioVO);
            ssrvDAO.delete(ssrvCriterioVO);
            srdtDAO.delete(srvcCriterioVO);

            final int updated = srvcDAO.delete(srvcId);

            if (updated == 0) {
                throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
            }

            session.commit();
        }
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
    private final void fillDependencies(final SqlSession session, final List<ServicioVO> srvcList,
            final ServicioCriterioVO srvcCriterioVO, final boolean useIds) {
        Preconditions.checkNotNull(srvcList);
        Preconditions.checkNotNull(srvcCriterioVO);

        srdtDAO = session.getMapper(ServicioDatoDAO.class);

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
