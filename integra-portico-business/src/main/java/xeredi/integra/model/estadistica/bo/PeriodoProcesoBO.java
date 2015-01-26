package xeredi.integra.model.estadistica.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.estadistica.dao.CuadroMesDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaAgregadoDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.integra.model.estadistica.dao.PeriodoProcesoDAO;
import xeredi.integra.model.estadistica.vo.CuadroMesConcepto;
import xeredi.integra.model.estadistica.vo.CuadroMesParametroVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoBO.
 */
public class PeriodoProcesoBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PeriodoProcesoBO.class);

    /**
     * Exists.
     *
     * @param peprVO
     *            the pepr vo
     * @return true, if successful
     */
    public final boolean exists(final PeriodoProcesoVO peprVO) {
        Preconditions.checkNotNull(peprVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);

            return peprDAO.exists(peprVO);
        }
    }

    /**
     * Select.
     *
     * @param peprId
     *            the pepr id
     * @return the periodo proceso vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final PeriodoProcesoVO select(final Long peprId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(peprId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);
            final PeriodoProcesoVO peprVO = peprDAO.select(peprId);

            if (peprVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.pepr, peprId);
            }

            return peprVO;
        }
    }

    /**
     * Select list.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @return the list
     */
    public final List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO) {
        Preconditions.checkNotNull(peprCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);

            return peprDAO.selectList(peprCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(peprCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);
            final int count = peprDAO.selectCount(peprCriterioVO);
            final List<PeriodoProcesoVO> peprList = new ArrayList<>();

            if (count > offset) {
                peprList.addAll(peprDAO.selectPaginatedList(peprCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(peprList, offset, limit, count);
        }
    }

    /**
     * Delete.
     *
     * @param peprId
     *            the pepr id
     */
    public final void delete(final Long peprId) {
        Preconditions.checkNotNull(peprId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);

            final PeriodoProcesoVO peprVO = peprDAO.select(peprId);

            if (peprVO != null) {
                delete(session, peprVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param peprVO
     *            the pepr vo
     */
    private final void delete(final SqlSession session, final PeriodoProcesoVO peprVO) {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getAnio());
        Preconditions.checkNotNull(peprVO.getMes());
        Preconditions.checkNotNull(peprVO.getAutp());
        Preconditions.checkNotNull(peprVO.getAutp().getId());

        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);
        final CuadroMesDAO cdmsDAO = session.getMapper(CuadroMesDAO.class);
        final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
        final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);
        final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);

        peprCriterioVO.setAnio(peprVO.getAnio());
        peprCriterioVO.setMes(peprVO.getMes());
        peprCriterioVO.setAutpId(peprVO.getAutp().getId());

        final PeriodoProcesoVO peprActualVO = peprDAO.selectObject(peprCriterioVO);

        if (peprActualVO != null) {
            srvcDAO.updatePeprDesasociar(peprActualVO.getId());
            esdtDAO.delete(peprActualVO.getId());
            estdDAO.delete(peprActualVO.getId());
            cdmsDAO.delete(peprActualVO.getId());
            peprDAO.delete(peprActualVO.getId());
        }
    }

    /**
     * Cargar archivo.
     *
     * @param peprVO
     *            the pepr vo
     * @param autpMap
     *            the autp map
     * @param estdList
     *            the estd list
     * @param removeIfExists
     *            the remove if exists
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void cargarArchivo(final PeriodoProcesoVO peprVO, final Map<String, ParametroVO> autpMap,
            final List<EstadisticaVO> estdList, final boolean removeIfExists) throws DuplicateInstanceException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(autpMap);
        Preconditions.checkNotNull(estdList);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);
            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

            final IgBO igBO = new IgBO();

            final Date falta = Calendar.getInstance().getTime();

            // Si el periodo proceso ya existe
            if (peprDAO.exists(peprVO)) {
                if (removeIfExists) {
                    delete(session, peprVO);
                } else {
                    throw new DuplicateInstanceException(MessageI18nKey.pepr, peprVO);
                }
            }

            // Obtener secuencias
            if (LOG.isDebugEnabled()) {
                LOG.debug("Obtencion de secuencias");
            }

            peprVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            peprVO.setFalta(falta);

            for (final EstadisticaVO estdVO : estdList) {
                estdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                estdVO.setPepr(peprVO);
            }

            for (final EstadisticaVO estdVO : estdList) {
                for (final ItemDatoVO itdtVO : estdVO.getItdtMap().values()) {
                    // FIXME Validamos si los datos pasados son correctos??
                    itdtVO.setItemId(estdVO.getId());
                }
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("Insercion de datos");
            }

            // Insertar
            peprDAO.insert(peprVO);

            for (final EstadisticaVO estdVO : estdList) {
                estdDAO.insert(estdVO);
            }

            for (final EstadisticaVO estdVO : estdList) {
                for (final ItemDatoVO itdtVO : estdVO.getItdtMap().values()) {
                    esdtDAO.insert(itdtVO);
                }
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("Generacion de cuadro mensual");
            }

            generarCuadroMensual(session, peprVO.getId(), removeIfExists);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Commit datos");
            }

            session.commit();
        }
    }

    /**
     * Select subp ids.
     *
     * @param autpId
     *            the autp id
     * @param fref
     *            the fref
     * @return the list
     */
    public List<Long> selectSubpIds(final Long autpId, final Date fref) {
        Preconditions.checkNotNull(autpId);
        Preconditions.checkNotNull(fref);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EstadisticaAgregadoDAO esagDAO = session.getMapper(EstadisticaAgregadoDAO.class);

            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(autpId);
            prmtCriterioVO.setFechaVigencia(fref);

            return esagDAO.selectSubpIds(prmtCriterioVO);
        }
    }

    /**
     * Agregar servicios.
     *
     * @param peprVO
     *            the pepr vo
     * @param removeIfExists
     *            the remove if exists
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void agregarServicios(final PeriodoProcesoVO peprVO, final List<Long> subpIds,
            final boolean removeIfExists) throws DuplicateInstanceException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getAutp());
        Preconditions.checkNotNull(peprVO.getAnio());
        Preconditions.checkNotNull(peprVO.getMes());
        Preconditions.checkNotNull(subpIds);
        Preconditions.checkArgument(!subpIds.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);
            final EstadisticaAgregadoDAO esagDAO = session.getMapper(EstadisticaAgregadoDAO.class);

            final IgBO igBO = new IgBO();

            // Si el periodo proceso ya existe
            if (peprDAO.exists(peprVO)) {
                if (removeIfExists) {
                    delete(session, peprVO);
                } else {
                    throw new DuplicateInstanceException(MessageI18nKey.pepr, peprVO);
                }
            }

            peprVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            peprVO.setFalta(Calendar.getInstance().getTime());
            peprDAO.insert(peprVO);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Busqueda de datos agregados");
            }

            final EstadisticaAgregadoCriterioVO esagCriterioVO = new EstadisticaAgregadoCriterioVO();

            final Calendar finicio = Calendar.getInstance();
            finicio.setTimeInMillis(0);
            finicio.set(Calendar.YEAR, peprVO.getAnio());
            finicio.set(Calendar.MONTH, peprVO.getMes() - 1);
            finicio.set(Calendar.DAY_OF_MONTH, 1);

            final Calendar ffin = Calendar.getInstance();
            ffin.setTimeInMillis(0);
            ffin.set(Calendar.YEAR, peprVO.getAnio());
            ffin.set(Calendar.MONTH, peprVO.getMes());
            ffin.set(Calendar.DAY_OF_MONTH, 1);

            esagCriterioVO.setFini(finicio.getTime());
            esagCriterioVO.setFfin(ffin.getTime());
            esagCriterioVO.setSubpIds(subpIds);
            esagCriterioVO.setPeprId(peprVO.getId());

            final List<EstadisticaVO> estdList = new ArrayList<>();

            esagDAO.updateSrvcActividadPesquera(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.ACTIVIDAD_PESQUERA.getId(),
                    esagDAO.selectActividadPesquera(esagCriterioVO)));

            esagDAO.updateSrvcAvituallamiento(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.AVITUALLAMIENTO.getId(),
                    esagDAO.selectAvituallamiento(esagCriterioVO)));

            esagDAO.updateSrvcAgregacionSuperficie(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.AGREGACION_SUPERFICIE.getId(),
                    esagDAO.selectAgregacionSuperficie(esagCriterioVO)));

            esagDAO.updateSrvcAgregacionEscala(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.AGREGACION_ESCALA.getId(),
                    esagDAO.selectAgregacionEscala(esagCriterioVO)));

            esagDAO.updateSrvcMovimientoTipoBuqueEEE(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId(),
                    esagDAO.selectMovimientoTipoBuqueEEE(esagCriterioVO)));

            esagDAO.updateSrvcBuqueFondeadoAtracado(esagCriterioVO);
            estdList.addAll(obtenerEstadisticas(peprVO, Entidad.BUQUE_FONDEADO_ATRACADO.getId(),
                    esagDAO.selectBuqueFondeadoAtracado(esagCriterioVO)));
            // estdList.addAll(obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_MERCANCIA.getId(),
            // esagDAO.selectMovimientoMercancia(esagCriterioVO)));
            // estdList.addAll(obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_MERCANCIA_EEE.getId(),
            // esagDAO.selectMovimientoMercanciaEEE(esagCriterioVO)));

            if (LOG.isDebugEnabled()) {
                LOG.debug("Grabacion de Datos Agregados");
            }

            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

            for (final EstadisticaVO estdVO : estdList) {
                estdDAO.insert(estdVO);
            }

            for (final EstadisticaVO estdVO : estdList) {
                if (estdVO.getItdtMap() != null) {
                    for (final ItemDatoVO itdtVO : estdVO.getItdtMap().values()) {
                        itdtVO.setItemId(estdVO.getId());

                        esdtDAO.insert(itdtVO);
                    }
                }
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("Cuadro Mensual");
            }

            generarCuadroMensual(session, peprVO.getId(), removeIfExists);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Generacion de archivo de OPPE");
            }

            session.commit();
        }
    }

    /**
     * Obtener estadisticas.
     *
     * @param peprVO
     *            the pepr vo
     * @param tpesId
     *            the tpes id
     * @param esagList
     *            the esag list
     * @return the list
     */
    private final List<EstadisticaVO> obtenerEstadisticas(final PeriodoProcesoVO peprVO, final Long tpesId,
            final List<EstadisticaAgregadoVO> esagList) {
        try {
            final IgBO igBO = new IgBO();
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(tpesId);
            final List<EstadisticaVO> estdList = new ArrayList<>();

            for (final EstadisticaAgregadoVO esagVO : esagList) {
                final EstadisticaVO estdVO = new EstadisticaVO();
                final ParametroVO autpVO = new ParametroVO();

                autpVO.setId(esagVO.getSubpId());

                estdVO.setEntiId(tpesId);
                estdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                estdVO.setSubp(autpVO);
                estdVO.setPepr(peprVO);
                estdVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

                if (tpesVO.getEntdList() != null) {
                    for (final EntidadTipoDatoVO entd : tpesVO.getEntdList()) {
                        final Object value = esagVO.getEsdtMap().get(entd.getTpdt().getCodigo());
                        final ItemDatoVO itdtVO = new ItemDatoVO();

                        itdtVO.setTpdtId(entd.getTpdt().getId());
                        estdVO.getItdtMap().put(entd.getTpdt().getId(), itdtVO);

                        if (value == null) {
                            if (entd.getTpdt().getTipoElemento() == TipoElemento.BO) {
                                itdtVO.setCantidadEntera(0L);
                            }
                        } else {
                            switch (entd.getTpdt().getTipoElemento()) {
                            case BO:
                            case NE:
                                if (value instanceof BigDecimal) {
                                    itdtVO.setCantidadEntera(((BigDecimal) value).longValue());
                                } else if (value instanceof Long) {
                                    itdtVO.setCantidadEntera(((Long) value).longValue());
                                } else {
                                    itdtVO.setCantidadEntera(((Double) value).longValue());
                                }

                                break;
                            case ND:
                                if (value instanceof BigDecimal) {
                                    itdtVO.setCantidadDecimal(((BigDecimal) value).doubleValue());
                                } else {
                                    itdtVO.setCantidadDecimal(((Double) value).doubleValue());
                                }

                                break;
                            case PR:
                                final ParametroVO prmtVO = new ParametroVO();

                                if (value instanceof BigDecimal) {
                                    prmtVO.setId(((BigDecimal) value).longValue());
                                } else {
                                    prmtVO.setId(((Long) value).longValue());
                                }

                                itdtVO.setPrmt(prmtVO);

                                break;
                            case SR:
                                final ServicioVO srvcVO = new ServicioVO();

                                if (value instanceof BigDecimal) {
                                    srvcVO.setId(((BigDecimal) value).longValue());
                                } else {
                                    srvcVO.setId(((Long) value).longValue());
                                }

                                itdtVO.setSrvc(srvcVO);

                                break;
                            case CR:
                            case TX:
                                itdtVO.setCadena((String) value);

                                break;
                            case FE:
                            case FH:
                                /*
                                 * if (value instanceof TIMESTAMP) { itdtVO.setFecha(((TIMESTAMP)
                                 * value).dateValue()); } else { itdtVO.setFecha((Date) value); }
                                 */
                                itdtVO.setFecha((Date) value);

                                break;

                            default:
                                throw new Error("TipoElemento no encontrado: " + entd.getTpdt().getTipoElemento());
                            }
                        }
                    }
                }

                estdList.add(estdVO);
            }

            return estdList;
        } catch (final InstanceNotFoundException ex) {
            throw new Error(ex);
        }
    }

    /**
     * Generar cuadro mensual.
     *
     * @param session
     *            the session
     * @param peprId
     *            the pepr id
     * @param sobreescribir
     *            the sobreescribir
     */
    private final void generarCuadroMensual(final SqlSession session, final Long peprId, final boolean sobreescribir) {
        Preconditions.checkNotNull(peprId);

        final IgBO igBO = new IgBO();
        final CuadroMesDAO cdmsDAO = session.getMapper(CuadroMesDAO.class);

        cdmsDAO.insert_CM_PESCAF(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PESCAF, "**", "**", "ZZ", null, null, null));

        cdmsDAO.insert_CM_AVPPET(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.AVPPET, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_AVOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.AVOTRO, "**", "**", "ZZ", null, null, null));

        cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.BUQUNI, "**", "**", "ES", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_02, CuadroMesConcepto.BUQGT, "**", "**", "ES", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.BUQUNI, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_02, CuadroMesConcepto.BUQGT, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_CRUBUQ(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CRUBUQ, "**", "**", "ZZ", null, null, null));

        // Campo Adicional contiene un codigo de U.C.
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "E", "C", "ZZ", "E", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "D", "C", "ZZ", "D", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "ET", "C", "ZZ", "ET", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "DT", "C", "ZZ", "DT", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "E", "E", "ZZ", "E", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "D", "E", "ZZ", "D", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "ET", "E", "ZZ", "ET", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "DT", "E", "ZZ", "DT", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "T", "E", "ZZ", "T%", null, "12"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "E", "C", "ZZ", "E", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "D", "C", "ZZ", "D", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "ET", "C", "ZZ", "ET", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "DT", "C", "ZZ", "DT", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "E", "E", "ZZ", "E", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "D", "E", "ZZ", "D", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "ET", "E", "ZZ", "ET", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "DT", "E", "ZZ", "DT", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "T", "E", "ZZ", "T%", null, "11"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "E", "C", "ZZ", "E", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "D", "C", "ZZ", "D", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "ET", "C", "ZZ", "ET", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "DT", "C", "ZZ", "DT", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "E", "E", "ZZ", "E", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "D", "E", "ZZ", "D", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "ET", "E", "ZZ", "ET", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "DT", "E", "ZZ", "DT", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "T", "E", "ZZ", "T%", null, "13"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "E", "C", "ZZ", "E", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "D", "C", "ZZ", "D", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "ET", "C", "ZZ", "ET", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "DT", "C", "ZZ", "DT", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "E", "E", "ZZ", "E", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "D", "E", "ZZ", "D", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "ET", "E", "ZZ", "ET", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "DT", "E", "ZZ", "DT", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "T", "E", "ZZ", "T%", null, "19"));

        // Campo Adicional contiene un codigo de Instalacion Especial
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "E", "C", "ZZ", "E", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "D", "C", "ZZ", "D", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "ET", "C", "ZZ", "ET", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "DT", "C", "ZZ", "DT", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "E", "E", "ZZ", "E", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "D", "E", "ZZ", "D", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "ET", "E", "ZZ", "ET", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "DT", "E", "ZZ", "DT", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "T", "E", "ZZ", "T%", null, "**************S"));

        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "E", "C", "ZZ", "E", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "D", "C", "ZZ", "D", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "ET", "C", "ZZ", "ET", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "DT", "C", "ZZ", "DT", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "E", "E", "ZZ", "E", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "D", "E", "ZZ", "D", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "ET", "E", "ZZ", "ET", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "DT", "E", "ZZ", "DT", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "T", "E", "ZZ", "T%", null, "**************N"));

        // Campo Adicional contiene el tipo de mercancia de una unidad de carga
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "E", "C", "ZZ", "E", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "D", "C", "ZZ", "D", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "ET", "C", "ZZ", "ET", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "DT", "C", "ZZ", "DT", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "E", "E", "ZZ", "E", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "D", "E", "ZZ", "D", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "ET", "E", "ZZ", "ET", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "DT", "E", "ZZ", "DT", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "T", "E", "ZZ", "T%", null, "M%"));

        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "E", "C", "ZZ", "E", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "D", "C", "ZZ", "D", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "ET", "C", "ZZ", "ET", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "DT", "C", "ZZ", "DT", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "E", "E", "ZZ", "E", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "D", "E", "ZZ", "D", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "ET", "E", "ZZ", "ET", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "DT", "E", "ZZ", "DT", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "T", "E", "ZZ", "T%", null, "PS"));

        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "E", "C", "ZZ", "E", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "D", "C", "ZZ", "D", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "ET", "C", "ZZ", "ET", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "DT", "C", "ZZ", "DT", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "E", "E", "ZZ", "E", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "D", "E", "ZZ", "D", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "ET", "E", "ZZ", "ET", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "DT", "E", "ZZ", "DT", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "T", "E", "ZZ", "T%", null, "PA"));

        // Campo Adicional contiene el codigo de mercancia
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "E", "C", "ZZ", "E", "C%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "D", "C", "ZZ", "D", "C%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "ET", "C", "ZZ", "E%", "C%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "DT", "C", "ZZ", "D%", "C%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "E", "E", "ZZ", "E", "E%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "D", "E", "ZZ", "D", "E%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "ET", "E", "ZZ", "E$", "E%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "DT", "E", "ZZ", "D$", "E%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.PASCRU, "T", "E", "ZZ", "T%", null, "'0001X', '0002X', '0001C', '0002C'"));

        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.ENTERO_01,
                CuadroMesConcepto.CNUMCA, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.CTONCA, "T", "E", "ZZ", "T%", null, null));

        // Campo Adicional contiene codigo de mercancia
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "E", "C", "ZZ", "E", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "D", "C", "ZZ", "D", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "ET", "C", "ZZ", "ET", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "DT", "C", "ZZ", "DT", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "E", "E", "ZZ", "E", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "D", "E", "ZZ", "D", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "ET", "E", "ZZ", "ET", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "DT", "E", "ZZ", "DT", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "T", "E", "ZZ", "T%", null, "8609*"));

        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "E", "C", "ZZ", "E", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "D", "C", "ZZ", "D", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "ET", "C", "ZZ", "ET", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "DT", "C", "ZZ", "DT", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "E", "E", "ZZ", "E", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "D", "E", "ZZ", "D", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "ET", "E", "ZZ", "ET", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "DT", "E", "ZZ", "DT", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "T", "E", "ZZ", "T%", null, "8609*"));

        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "E", "C", "ZZ", "E", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "D", "C", "ZZ", "D", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "ET", "C", "ZZ", "ET", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "DT", "C", "ZZ", "DT", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "E", "E", "ZZ", "E", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "D", "E", "ZZ", "D", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "ET", "E", "ZZ", "ET", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "DT", "E", "ZZ", "DT", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "T", "E", "ZZ", "T%", null, "8609%"));

        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.RRTONO, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.TRALOC, "E", "I", "ZZ", "E", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.TRALOC, "D", "I", "ZZ", "D", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.TRALOC, "ET", "I", "ZZ", "%T", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, TipoDato.DECIMAL_01,
                CuadroMesConcepto.TRALOC, "T", "I", "ZZ", "T%", "I%", null));

        // CONSULTAS RESUMEN DE LA PROPIA TABLA DE CUADRO MES
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "E", "C", "ZZ", "E", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "D", "C", "ZZ", "D", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "ET", "C", "ZZ", "ET", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "DT", "C", "ZZ", "DT", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "E", "E", "ZZ", "E", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "D", "E", "ZZ", "D", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "ET", "E", "ZZ", "ET", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "DT", "E", "ZZ", "DT", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(IgBO.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "T", "E", "ZZ", "T", "E", null));
    }
}
