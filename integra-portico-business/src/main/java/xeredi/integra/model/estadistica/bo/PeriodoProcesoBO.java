package xeredi.integra.model.estadistica.bo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.dao.CuadroMesDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaAgregadoDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.integra.model.estadistica.dao.EstadisticaExportDAO;
import xeredi.integra.model.estadistica.dao.PeriodoProcesoDAO;
import xeredi.integra.model.estadistica.vo.CuadroMesConcepto;
import xeredi.integra.model.estadistica.vo.CuadroMesParametroVO;
import xeredi.integra.model.estadistica.vo.CuadroMesVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaExportVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.TipoDato;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
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

    /** The pepr dao. */
    PeriodoProcesoDAO peprDAO;

    /** The esdt dao. */
    EstadisticaDatoDAO esdtDAO;

    /** The estd dao. */
    EstadisticaDAO estdDAO;

    /** The cdms dao. */
    CuadroMesDAO cdmsDAO;

    /** The esex dao. */
    EstadisticaExportDAO esexDAO;

    /** The esag dao. */
    EstadisticaAgregadoDAO esagDAO;

    /**
     * Exists.
     *
     * @param peprVO
     *            the pepr vo
     * @return true, if successful
     */
    public final boolean exists(final PeriodoProcesoVO peprVO) {
        Preconditions.checkNotNull(peprVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);

        try {
            return peprDAO.exists(peprVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);

        try {
            final PeriodoProcesoVO peprVO = peprDAO.select(peprId);

            if (peprVO == null) {
                throw new InstanceNotFoundException(PeriodoProcesoVO.class.getName(), peprId);
            }

            return peprVO;
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);

        try {
            return peprDAO.selectList(peprCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);

        try {
            final int count = peprDAO.selectCount(peprCriterioVO);
            final List<PeriodoProcesoVO> peprList = new ArrayList<>();

            if (count > offset) {
                peprList.addAll(peprDAO.selectList(peprCriterioVO));
            }

            return new PaginatedList<>(peprList, offset, limit, count);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);
        cdmsDAO = session.getMapper(CuadroMesDAO.class);
        estdDAO = session.getMapper(EstadisticaDAO.class);
        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

        try {
            cdmsDAO.delete(peprId);
            esdtDAO.delete(peprId);
            estdDAO.delete(peprId);
            peprDAO.delete(peprId);

            session.commit();
        } finally {
            session.close();
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
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);
        cdmsDAO = session.getMapper(CuadroMesDAO.class);
        estdDAO = session.getMapper(EstadisticaDAO.class);
        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

        peprCriterioVO.setAnio(peprVO.getAnio());
        peprCriterioVO.setMes(peprVO.getMes());
        peprCriterioVO.setAutpId(peprVO.getAutp().getId());

        final PeriodoProcesoVO peprActualVO = peprDAO.selectObject(peprCriterioVO);

        if (peprActualVO == null) {
            throw new Error("Deberia haber encontrado un periodo de proceso: " + peprCriterioVO);
        }

        esdtDAO.delete(peprActualVO.getId());
        estdDAO.delete(peprActualVO.getId());
        cdmsDAO.delete(peprActualVO.getId());
        peprDAO.delete(peprActualVO.getId());
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);
        cdmsDAO = session.getMapper(CuadroMesDAO.class);
        estdDAO = session.getMapper(EstadisticaDAO.class);
        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            final Date falta = Calendar.getInstance().getTime();

            // Si el periodo proceso ya existe
            if (peprDAO.exists(peprVO)) {
                if (removeIfExists) {
                    delete(session, peprVO);
                } else {
                    throw new DuplicateInstanceException(PeriodoProcesoVO.class.getName(), peprVO);
                }
            }

            // Obtener secuencias
            if (LOG.isDebugEnabled()) {
                LOG.debug("Obtencion de secuencias");
            }

            peprVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            peprVO.setFalta(falta);

            for (final EstadisticaVO estdVO : estdList) {
                estdVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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

            // generarCuadroMensual(session, peprVO.getId(), removeIfExists);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Commit datos");
            }

            session.commit();
        } finally {
            session.close();
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
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void agregarServicios(final PeriodoProcesoVO peprVO, final boolean removeIfExists)
            throws DuplicateInstanceException, IOException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getAnio());
        Preconditions.checkNotNull(peprVO.getMes());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        peprDAO = session.getMapper(PeriodoProcesoDAO.class);
        cdmsDAO = session.getMapper(CuadroMesDAO.class);
        estdDAO = session.getMapper(EstadisticaDAO.class);
        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);
        esagDAO = session.getMapper(EstadisticaAgregadoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            // Si el periodo proceso ya existe
            if (peprDAO.exists(peprVO)) {
                if (removeIfExists) {
                    delete(session, peprVO);
                } else {
                    throw new DuplicateInstanceException(PeriodoProcesoVO.class.getName(), peprVO);
                }
            }

            final Map<Long, List<EstadisticaVO>> estdMap = new HashMap<>();

            peprVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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

            esagCriterioVO.setFinicio(finicio.getTime());
            esagCriterioVO.setFfin(ffin.getTime());

            estdMap.put(
                    Entidad.ACTIVIDAD_PESQUERA.getId(),
                    obtenerEstadisticas(peprVO, Entidad.ACTIVIDAD_PESQUERA.getId(),
                            esagDAO.selectActividadPesquera(esagCriterioVO)));
            estdMap.put(
                    Entidad.AVITUALLAMIENTO.getId(),
                    obtenerEstadisticas(peprVO, Entidad.AVITUALLAMIENTO.getId(),
                            esagDAO.selectAvituallamiento(esagCriterioVO)));
            estdMap.put(
                    Entidad.AGREGACION_SUPERFICIE.getId(),
                    obtenerEstadisticas(peprVO, Entidad.AGREGACION_SUPERFICIE.getId(),
                            esagDAO.selectAgregacionSuperficie(esagCriterioVO)));
            estdMap.put(
                    Entidad.AGREGACION_ESCALA.getId(),
                    obtenerEstadisticas(peprVO, Entidad.AGREGACION_ESCALA.getId(),
                            esagDAO.selectAgregacionEscala(esagCriterioVO)));
            estdMap.put(
                    Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId(),
                    obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId(),
                            esagDAO.selectMovimientoTipoBuqueEEE(esagCriterioVO)));
            estdMap.put(
                    Entidad.BUQUE_FONDEADO_ATRACADO.getId(),
                    obtenerEstadisticas(peprVO, Entidad.BUQUE_FONDEADO_ATRACADO.getId(),
                            esagDAO.selectBuqueFondeadoAtracado(esagCriterioVO)));
            estdMap.put(
                    Entidad.MOVIMIENTO_MERCANCIA.getId(),
                    obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_MERCANCIA.getId(),
                            esagDAO.selectMovimientoMercancia(esagCriterioVO)));
            estdMap.put(
                    Entidad.MOVIMIENTO_MERCANCIA_EEE.getId(),
                    obtenerEstadisticas(peprVO, Entidad.MOVIMIENTO_MERCANCIA_EEE.getId(),
                            esagDAO.selectMovimientoMercanciaEEE(esagCriterioVO)));

            if (LOG.isDebugEnabled()) {
                LOG.debug("Grabacion de Datos Agregados");
            }

            for (final Long tpesId : estdMap.keySet()) {
                insertEstadisticaAgregadoList(session, peprVO, tpesId, estdMap.get(tpesId));
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("Cuadro Mensual");
            }

            generarCuadroMensual(session, peprVO.getId(), removeIfExists);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Generacion de archivo de OPPE");
            }

            // generarArchivo(peprVO);

            session.commit();
        } finally {
            session.close();
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
        final IgBO igBO = new IgBO();
        final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(tpesId);
        final List<EstadisticaVO> estdList = new ArrayList<>();

        for (final EstadisticaAgregadoVO esagVO : esagList) {
            final EstadisticaVO estdVO = new EstadisticaVO();
            final ParametroVO autpVO = new ParametroVO();

            autpVO.setId(esagVO.getSubpId());

            estdVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            estdVO.setSubp(autpVO);
            estdVO.setPepr(peprVO);

            if (tpesVO.getEntdMap() != null) {
                for (final EntidadTipoDatoVO entdVO : tpesVO.getEntdMap().values()) {
                    final Object value = esagVO.getEsdtMap().get(entdVO.getTpdt().getCodigo());
                    final ItemDatoVO itdtVO = new ItemDatoVO();

                    itdtVO.setTpdtId(entdVO.getTpdt().getId());
                    estdVO.getItdtMap().put(entdVO.getTpdt().getId(), itdtVO);

                    if (value == null) {
                        if (entdVO.getTpdt().getTipoElemento() == TipoElemento.BO) {
                            itdtVO.setCantidadEntera(0L);
                        }
                    } else {
                        switch (entdVO.getTpdt().getTipoElemento()) {
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
                             * if (value instanceof TIMESTAMP) { itdtVO.setFecha(((TIMESTAMP) value).dateValue()); }
                             * else { itdtVO.setFecha((Date) value); }
                             */
                            itdtVO.setFecha((Date) value);

                            break;

                        default:
                            throw new Error("TipoElemento no encontrado: " + entdVO.getTpdt().getTipoElemento());
                        }
                    }
                }
            }

            estdList.add(estdVO);
        }

        return estdList;
    }

    /**
     * Generar archivo.
     *
     * @param session
     *            the session
     * @param peprVO
     *            the pepr vo
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private final void generarArchivo(final SqlSession session, final PeriodoProcesoVO peprVO) throws IOException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getId());

        esexDAO = session.getMapper(EstadisticaExportDAO.class);

        final String fileName = peprVO.getAutp().getParametro()
                + StringUtils.leftPad(peprVO.getAnio().toString(), 4, '0')
                + StringUtils.leftPad(peprVO.getMes().toString(), 2, '0');

        try (final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/xeredi/" + fileName + ".zip"));) {
            // Fichero de Actividad Pesquera
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectActividadPesquera(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EAP_TipoCaptura.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.TIPO_CAPTURA_PESCA.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAP_Kilos.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EAP_Euros.generateStringValue(new Double((Double) esexVO
                            .getEsdtMap().get(TipoDato.DECIMAL_01.name()) * 100).longValue(), '0'));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EAP"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }

            // Fichero de Avituallamiento
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectAvituallamiento(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EAV_TipoSuministro.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_SUM.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAV_Toneladas.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EAV"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }

            // Fichero de Agregacion de Escala
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectAgregacionEscala(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EAE_TipoBuque.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.TIPO_BUQUE_GT.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAE_TipoNavEntrada.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_NAV.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAE_TipoNavSalida.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.TIPO_NAV_2.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAE_Bandera.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.PAIS.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EAE_TipoActividad.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.TIPO_ACT_EST.name()), ' '));

                    buffer.append(EstadisticaFileKeyword.EAE_NumEscalas.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EAE_NumGTs.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_02.name()), '0'));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EAE"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }

            // Fichero de Movimiento de Mercancia
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectMovimientoMercancia(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EMM_TipoOperacion.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.TIPO_OP_BL.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_UnloOrigen.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.UNLOCODE_3.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_UnloDestino.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.UNLOCODE_4.name()), ' '));

                    buffer.append(0 == (Long) esexVO.getEsdtMap().get("ALIN_DEPARTICULARES") ? "1" : "2");

                    buffer.append(EstadisticaFileKeyword.EMM_Mercancia.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.MERCANCIA.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_TipoNavegacion.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_NAV.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_Roro.generateStringValue(1 == (Long) esexVO.getEsdtMap()
                            .get(TipoDato.BOOLEANO_01.name()) ? "S" : "N", ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_UnidadCarga.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.UNIDAD_CARGA.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_InstEspecial.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.INST_ESP.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMM_TipoTransporte.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_TRANSPORTE.name()), ' '));

                    buffer.append(EstadisticaFileKeyword.EMM_Toneladas.generateStringValue(
                            Math.round((Double) esexVO.getEsdtMap().get(TipoDato.DECIMAL_01.name())), '0'));
                    buffer.append(EstadisticaFileKeyword.EMM_Unidades.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EMM_Teus.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.DECIMAL_02.name()), '0'));

                    buffer.append(esexVO.getEsdtMap().get(TipoDato.UNLOCODE.name()));
                    buffer.append(esexVO.getEsdtMap().get(TipoDato.UNLOCODE_2.name()));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EMM"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }

            // Fichero de Movimiento de Mercancia EEE
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectMovimientoMercanciaEEE(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EME_UnloCargaDescarga.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.UNLOCODE.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EME_UnidadCarga.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.UNIDAD_CARGA.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EME_Mercancia.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.MERCANCIA.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EME_RegistroBuqueEEE.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.REG_TBUQUE_EEE.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EME_DireccionTransporte.generateStringValue(esexVO
                            .getEsdtMap().get(TipoDato.DIREC_MERC.name()), ' '));

                    buffer.append(EstadisticaFileKeyword.EME_Toneladas.generateStringValue(
                            Math.round((Double) esexVO.getEsdtMap().get(TipoDato.DECIMAL_01.name())), '0'));
                    buffer.append(EstadisticaFileKeyword.EME_Pasajeros.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EME_UCLlenas.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_04.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EME_UCVacias.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_05.name()), '0'));

                    buffer.append(EstadisticaFileKeyword.EME_Roro.generateStringValue(1 == (Long) esexVO.getEsdtMap()
                            .get(TipoDato.BOOLEANO_01.name()) ? "S" : "N", ' '));

                    buffer.append(EstadisticaFileKeyword.EME_PasajerosCrucero.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.ENTERO_02.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EME_PasajerosInicioFinLinea.generateStringValue(esexVO
                            .getEsdtMap().get(TipoDato.ENTERO_03.name()), '0'));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EME"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }

            // Fichero de Movimiento de Tipo Buque EEE
            {
                final List<EstadisticaExportVO> esexList = esexDAO.selectMovimientoTipoBuqueEEE(peprVO.getId());
                final List<StringBuffer> stringBuffers = new ArrayList<>();

                for (final EstadisticaExportVO esexVO : esexList) {
                    final StringBuffer buffer = new StringBuffer();

                    buffer.append(EstadisticaFileKeyword.Anio.generateStringValue(peprVO.getAnio(), '0'));
                    buffer.append(EstadisticaFileKeyword.Mes.generateStringValue(peprVO.getMes(), '0'));
                    buffer.append(EstadisticaFileKeyword.Autp.generateStringValue(esexVO.getAutp(), '0'));

                    buffer.append(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_BUQUE_EEE.name()), ' '));
                    buffer.append(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE.generateStringValue(esexVO.getEsdtMap()
                            .get(TipoDato.TIPO_BUQUE_GT_EEE.name()), ' '));

                    buffer.append(EstadisticaFileKeyword.EMT_NumeroBuques.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_01.name()), '0'));
                    buffer.append(EstadisticaFileKeyword.EMT_NumeroGTs.generateStringValue(
                            esexVO.getEsdtMap().get(TipoDato.ENTERO_02.name()), '0'));

                    stringBuffers.add(buffer);
                }

                zos.putNextEntry(new ZipEntry(fileName + ".EMT"));
                IOUtils.writeLines(stringBuffers, null, zos);
                zos.closeEntry();
            }
        }
    }

    /**
     * Insert estadistica agregado list.
     *
     * @param session
     *            the session
     * @param peprVO
     *            the pepr vo
     * @param tpesId
     *            the tpes id
     * @param estdList
     *            the estd list
     */
    private final void insertEstadisticaAgregadoList(final SqlSession session, final PeriodoProcesoVO peprVO,
            final Long tpesId, final List<EstadisticaVO> estdList) {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(tpesId);
        Preconditions.checkNotNull(estdList);

        estdDAO = session.getMapper(EstadisticaDAO.class);
        esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

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
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    private final void generarCuadroMensual(final SqlSession session, final Long peprId, final boolean sobreescribir)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(peprId);

        final IgBO igBO = new IgBO();

        if (cdmsDAO.exists(peprId)) {
            if (sobreescribir) {
                cdmsDAO.delete(peprId);
            } else {
                throw new DuplicateInstanceException(CuadroMesVO.class.getName(), peprId);
            }
        }

        cdmsDAO.insert_CM_PESCAF(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PESCAF, "**", "**", "ZZ", null, null, null));

        cdmsDAO.insert_CM_AVPPET(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.AVPPET, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_AVOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.AVOTRO, "**", "**", "ZZ", null, null, null));

        cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.BUQUNI, "**", "**", "ES", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_02, CuadroMesConcepto.BUQGT, "**", "**", "ES", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.BUQUNI, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_02, CuadroMesConcepto.BUQGT, "**", "**", "ZZ", null, null, null));
        cdmsDAO.insert_CM_CRUBUQ(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CRUBUQ, "**", "**", "ZZ", null, null, null));

        // Campo Adicional contiene un codigo de U.C.
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "E", "C", "ZZ", "E", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "D", "C", "ZZ", "D", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "ET", "C", "ZZ", "ET", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "DT", "C", "ZZ", "DT", "C%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "E", "E", "ZZ", "E", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "D", "E", "ZZ", "D", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "ET", "E", "ZZ", "ET", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "DT", "E", "ZZ", "DT", "E%", "12"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPETR, "T", "E", "ZZ", "T%", null, "12"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "E", "C", "ZZ", "E", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "D", "C", "ZZ", "D", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "ET", "C", "ZZ", "ET", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "DT", "C", "ZZ", "DT", "C%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "E", "E", "ZZ", "E", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "D", "E", "ZZ", "D", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "ET", "E", "ZZ", "ET", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "DT", "E", "ZZ", "DT", "E%", "11"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLGASN, "T", "E", "ZZ", "T%", null, "11"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "E", "C", "ZZ", "E", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "D", "C", "ZZ", "D", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "ET", "C", "ZZ", "ET", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "DT", "C", "ZZ", "DT", "C%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "E", "E", "ZZ", "E", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "D", "E", "ZZ", "D", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "ET", "E", "ZZ", "ET", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "DT", "E", "ZZ", "DT", "E%", "13"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLPREF, "T", "E", "ZZ", "T%", null, "13"));

        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "E", "C", "ZZ", "E", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "D", "C", "ZZ", "D", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "ET", "C", "ZZ", "ET", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "DT", "C", "ZZ", "DT", "C%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "E", "E", "ZZ", "E", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "D", "E", "ZZ", "D", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "ET", "E", "ZZ", "ET", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "DT", "E", "ZZ", "DT", "E%", "19"));
        cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA),
                peprId, TipoDato.DECIMAL_01, CuadroMesConcepto.GLOTRO, "T", "E", "ZZ", "T%", null, "19"));

        // Campo Adicional contiene un codigo de Instalacion Especial
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "E", "C", "ZZ", "E", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "D", "C", "ZZ", "D", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "ET", "C", "ZZ", "ET", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "DT", "C", "ZZ", "DT", "C%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "E", "E", "ZZ", "E", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "D", "E", "ZZ", "D", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "ET", "E", "ZZ", "ET", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "DT", "E", "ZZ", "DT", "E%", "**************S"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSIESP, "T", "E", "ZZ", "T%", null, "**************S"));

        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "E", "C", "ZZ", "E", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "D", "C", "ZZ", "D", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "ET", "C", "ZZ", "ET", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "DT", "C", "ZZ", "DT", "C%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "E", "E", "ZZ", "E", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "D", "E", "ZZ", "D", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "ET", "E", "ZZ", "ET", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "DT", "E", "ZZ", "DT", "E%", "**************N"));
        cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.GSNIES, "T", "E", "ZZ", "T%", null, "**************N"));

        // Campo Adicional contiene el tipo de mercancia de una unidad de carga
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "E", "C", "ZZ", "E", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "D", "C", "ZZ", "D", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "ET", "C", "ZZ", "ET", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "DT", "C", "ZZ", "DT", "C%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "E", "E", "ZZ", "E", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "D", "E", "ZZ", "D", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "ET", "E", "ZZ", "ET", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "DT", "E", "ZZ", "DT", "E%", "M%"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.MG, "T", "E", "ZZ", "T%", null, "M%"));

        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "E", "C", "ZZ", "E", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "D", "C", "ZZ", "D", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "ET", "C", "ZZ", "ET", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "DT", "C", "ZZ", "DT", "C%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "E", "E", "ZZ", "E", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "D", "E", "ZZ", "D", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "ET", "E", "ZZ", "ET", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "DT", "E", "ZZ", "DT", "E%", "PS"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASAJE, "T", "E", "ZZ", "T%", null, "PS"));

        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "E", "C", "ZZ", "E", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "D", "C", "ZZ", "D", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "ET", "C", "ZZ", "ET", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "DT", "C", "ZZ", "DT", "C%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "E", "E", "ZZ", "E", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "D", "E", "ZZ", "D", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "ET", "E", "ZZ", "ET", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "DT", "E", "ZZ", "DT", "E%", "PA"));
        cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.VET2, "T", "E", "ZZ", "T%", null, "PA"));

        // Campo Adicional contiene el codigo de mercancia
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "E", "C", "ZZ", "E", "C%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "D", "C", "ZZ", "D", "C%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "ET", "C", "ZZ", "E%", "C%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "DT", "C", "ZZ", "D%", "C%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "E", "E", "ZZ", "E", "E%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "D", "E", "ZZ", "D", "E%", "'0001X', '0002X'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "ET", "E", "ZZ", "E$", "E%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "DT", "E", "ZZ", "D$", "E%", "'0001C', '0002C'"));
        cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.PASCRU, "T", "E", "ZZ", "T%", null,
                "'0001X', '0002X', '0001C', '0002C'"));

        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMCA, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONCA, "T", "E", "ZZ", "T%", null, null));

        // Campo Adicional contiene codigo de mercancia
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "E", "C", "ZZ", "E", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "D", "C", "ZZ", "D", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "ET", "C", "ZZ", "ET", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "DT", "C", "ZZ", "DT", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "E", "E", "ZZ", "E", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "D", "E", "ZZ", "D", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "ET", "E", "ZZ", "ET", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "DT", "E", "ZZ", "DT", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.ENTERO_01, CuadroMesConcepto.CNUMVA, "T", "E", "ZZ", "T%", null, "8609*"));

        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "E", "C", "ZZ", "E", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "D", "C", "ZZ", "D", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "ET", "C", "ZZ", "ET", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "DT", "C", "ZZ", "DT", "C%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "E", "E", "ZZ", "E", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "D", "E", "ZZ", "D", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "ET", "E", "ZZ", "ET", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "DT", "E", "ZZ", "DT", "E%", "8609*"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.CTONVA, "T", "E", "ZZ", "T%", null, "8609*"));

        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "E", "C", "ZZ", "E", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "D", "C", "ZZ", "D", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "ET", "C", "ZZ", "ET", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "DT", "C", "ZZ", "DT", "C%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "E", "E", "ZZ", "E", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "D", "E", "ZZ", "D", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "ET", "E", "ZZ", "ET", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "DT", "E", "ZZ", "DT", "E%", "8609%"));
        cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.CTEUS, "T", "E", "ZZ", "T%", null, "8609%"));

        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_02, CuadroMesConcepto.RRTEUS, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONC, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "E", "C", "ZZ", "E", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "D", "C", "ZZ", "D", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "ET", "C", "ZZ", "ET", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "DT", "C", "ZZ", "DT", "C%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "E", "E", "ZZ", "E", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "D", "E", "ZZ", "D", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "ET", "E", "ZZ", "ET", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "DT", "E", "ZZ", "DT", "E%", null));
        cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.RRTONO, "T", "E", "ZZ", "T%", null, null));

        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.TRALOC, "E", "I", "ZZ", "E", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.TRALOC, "D", "I", "ZZ", "D", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.TRALOC, "ET", "I", "ZZ", "%T", "I%", null));
        cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId,
                TipoDato.DECIMAL_01, CuadroMesConcepto.TRALOC, "T", "I", "ZZ", "T%", "I%", null));

        // CONSULTAS RESUMEN DE LA PROPIA TABLA DE CUADRO MES
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "E", "C", "ZZ", "E", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "D", "C", "ZZ", "D", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "ET", "C", "ZZ", "ET", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "DT", "C", "ZZ", "DT", "C", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "E", "E", "ZZ", "E", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "D", "E", "ZZ", "D", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "ET", "E", "ZZ", "ET", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "DT", "E", "ZZ", "DT", "E", null));
        cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(igBO.nextVal(GlobalNames.SQ_INTEGRA), peprId, null,
                CuadroMesConcepto.MCONV, "T", "E", "ZZ", "T", "E", null));
    }

}
