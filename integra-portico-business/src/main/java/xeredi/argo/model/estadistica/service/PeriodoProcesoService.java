package xeredi.argo.model.estadistica.service;

import java.io.ByteArrayOutputStream;
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

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.ArchivoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.estadistica.dao.CuadroMesDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaAgregadoDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.argo.model.estadistica.dao.PeriodoProcesoDAO;
import xeredi.argo.model.estadistica.io.EstadisticaFileType;
import xeredi.argo.model.estadistica.io.OppeFileExport;
import xeredi.argo.model.estadistica.vo.CuadroMesConcepto;
import xeredi.argo.model.estadistica.vo.CuadroMesParametroVO;
import xeredi.argo.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaAgregadoVO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoService.
 */
@Singleton
@Transactional
public class PeriodoProcesoService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PeriodoProcesoService.class);

	/** The pepr DAO. */
	@Inject
	private PeriodoProcesoDAO peprDAO;

	/** The arch DAO. */
	@Inject
	private ArchivoDAO archDAO;

	/** The srvc DAO. */
	@Inject
	private ServicioDAO srvcDAO;

	/** The cdms DAO. */
	@Inject
	private CuadroMesDAO cdmsDAO;

	/** The estd DAO. */
	@Inject
	private EstadisticaDAO estdDAO;

	/** The esdt DAO. */
	@Inject
	private EstadisticaDatoDAO esdtDAO;

	/** The esag DAO. */
	@Inject
	private EstadisticaAgregadoDAO esagDAO;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * Exists.
	 *
	 * @param peprVO
	 *            the pepr VO
	 * @return true, if successful
	 */
	public boolean exists(PeriodoProcesoVO peprVO) {
		return peprDAO.exists(peprVO);
	}

	/**
	 * Select.
	 *
	 * @param peprId
	 *            the pepr id
	 * @param idioma
	 *            the idioma
	 * @return the periodo proceso VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public PeriodoProcesoVO select(Long peprId, String idioma) throws InstanceNotFoundException {
		final PeriodoProcesoCriterioVO peprCriterio = new PeriodoProcesoCriterioVO();

		peprCriterio.setId(peprId);
		peprCriterio.setIdioma(idioma);

		final PeriodoProcesoVO peprVO = peprDAO.selectObject(peprCriterio);

		if (peprVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.pepr, peprId);
		}

		return peprVO;
	}

	/**
	 * Select list.
	 *
	 * @param peprCriterioVO
	 *            the pepr criterio VO
	 * @return the list
	 */
	public List<PeriodoProcesoVO> selectList(PeriodoProcesoCriterioVO peprCriterioVO) {
		return peprDAO.selectList(peprCriterioVO);
	}

	/**
	 * Select list.
	 *
	 * @param peprCriterioVO
	 *            the pepr criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<PeriodoProcesoVO> selectList(PeriodoProcesoCriterioVO peprCriterioVO, int offset, int limit) {
		final int count = peprDAO.count(peprCriterioVO);

		return new PaginatedList<>(
				count > offset ? peprDAO.selectList(peprCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Delete.
	 *
	 * @param pepr
	 *            the pepr
	 */
	public void delete(PeriodoProcesoVO pepr) {
		Preconditions.checkNotNull(pepr.getAnio());
		Preconditions.checkNotNull(pepr.getMes());
		Preconditions.checkNotNull(pepr.getSprt());
		Preconditions.checkNotNull(pepr.getSprt().getId());

		final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

		peprCriterioVO.setAnio(pepr.getAnio());
		peprCriterioVO.setMes(pepr.getMes());
		peprCriterioVO.setSprtId(pepr.getSprt().getId());

		final PeriodoProcesoVO peprActualVO = peprDAO.selectObject(peprCriterioVO);

		if (peprActualVO != null) {
			final EstadisticaCriterioVO estdCriterio = new EstadisticaCriterioVO();

			estdCriterio.setPepr(new PeriodoProcesoCriterioVO());
			estdCriterio.getPepr().setId(peprActualVO.getId());

			if (LOG.isDebugEnabled()) {
				LOG.debug("Borrado período de proceso: " + peprActualVO.getId());
				LOG.debug("Desasociar servicios");
			}

			srvcDAO.updatePeprDesasociar(peprActualVO.getId());

			if (LOG.isDebugEnabled()) {
				LOG.debug("Borrado esdt");
			}
			esdtDAO.deleteList(estdCriterio);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Borrado estd");
			}
			estdDAO.deleteList(estdCriterio);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Borrado cdms");
			}
			cdmsDAO.deleteList(estdCriterio.getPepr());

			if (LOG.isDebugEnabled()) {
				LOG.debug("Borrado pepr");
			}
			peprDAO.delete(peprActualVO);
		}
	}

	/**
	 * Generar cuadro mensual.
	 *
	 * @param peprId
	 *            the pepr id
	 * @param removeIfExists
	 *            the remove if exists
	 */
	public void generarCuadroMensual(Long peprId, boolean removeIfExists) {
		int orden = 0;

		if (LOG.isDebugEnabled()) {
			LOG.debug(Entidad.ACTIVIDAD_PESQUERA);
		}

		cdmsDAO.insert_CM_PESCAF(new CuadroMesParametroVO(peprId, Entidad.ACTIVIDAD_PESQUERA, CuadroMesConcepto.PESCAF,
				orden++, TipoDato.ENTERO_01, "**", "**", "ZZ", null, null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(Entidad.AVITUALLAMIENTO);
		}

		cdmsDAO.insert_CM_AVPPET(new CuadroMesParametroVO(peprId, Entidad.AVITUALLAMIENTO, CuadroMesConcepto.AVPPET,
				orden++, TipoDato.ENTERO_01, "**", "**", "ZZ", null, null, null));
		cdmsDAO.insert_CM_AVOTRO(new CuadroMesParametroVO(peprId, Entidad.AVITUALLAMIENTO, CuadroMesConcepto.AVOTRO,
				orden++, TipoDato.ENTERO_01, "**", "**", "ZZ", null, null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(Entidad.AGREGACION_ESCALA);
		}

		cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(peprId, Entidad.AGREGACION_ESCALA,
				CuadroMesConcepto.BUQUNI, orden++, TipoDato.ENTERO_01, "**", "**", "ES", null, null, null));
		cdmsDAO.insert_CM_BUQUNI_BUQGT_ES(new CuadroMesParametroVO(peprId, Entidad.AGREGACION_ESCALA,
				CuadroMesConcepto.BUQGT, orden++, TipoDato.ENTERO_02, "**", "**", "ES", null, null, null));
		cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(peprId, Entidad.AGREGACION_ESCALA,
				CuadroMesConcepto.BUQUNI, orden++, TipoDato.ENTERO_01, "**", "**", "ZZ", null, null, null));
		cdmsDAO.insert_CM_BUQUNI_BUQGT_ZZ(new CuadroMesParametroVO(peprId, Entidad.AGREGACION_ESCALA,
				CuadroMesConcepto.BUQGT, orden++, TipoDato.ENTERO_02, "**", "**", "ZZ", null, null, null));
		cdmsDAO.insert_CM_CRUBUQ(new CuadroMesParametroVO(peprId, Entidad.AGREGACION_ESCALA, CuadroMesConcepto.CRUBUQ,
				orden++, TipoDato.ENTERO_01, "**", "**", "ZZ", null, null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(Entidad.MOVIMIENTO_MERCANCIA);
			LOG.debug(CuadroMesConcepto.GLPETR);
		}

		// Campo Adicional contiene un codigo de U.C.
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "12"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPETR, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "12"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.GLGASN);
		}

		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "11"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLGASN, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "11"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.GLPREF);
		}

		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "13"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLPREF, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "13"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.GLOTRO);
		}

		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "19"));
		cdmsDAO.insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GLOTRO, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "19"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.GSIESP);
		}

		// Campo Adicional contiene un codigo de Instalacion Especial
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSIESP, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSIESP, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSIESP, orden++,
						TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSIESP, orden++,
						TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSIESP, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSIESP, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSIESP, orden++,
						TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSIESP, orden++,
						TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "**************S"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSIESP, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "**************S"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.GSNIES);
		}
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSNIES, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSNIES, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSNIES, orden++,
						TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSNIES, orden++,
						TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSNIES, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSNIES, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSNIES, orden++,
						TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.GSNIES, orden++,
						TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "**************N"));
		cdmsDAO.insert_CM_GSIESP_GSNIES(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.GSNIES, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "**************N"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.MG);
		}

		// Campo Adicional contiene el tipo de mercancia de una unidad de carga
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "M%"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.MG, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "M%"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.PASAJE);
		}

		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "E", "C", "ZZ", "E", "C%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "D", "C", "ZZ", "D", "C%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "ET", "C", "ZZ", "ET", "C%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "DT", "C", "ZZ", "DT", "C%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "E", "E", "ZZ", "E", "E%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "D", "E", "ZZ", "D", "E%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "ET", "E", "ZZ", "ET", "E%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "DT", "E", "ZZ", "DT", "E%", "PS"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASAJE, orden++, TipoDato.ENTERO_01, "T", "E", "ZZ", "T%", null, "PS"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.VET2);
		}

		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "E", "C", "ZZ", "E", "C%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "D", "C", "ZZ", "D", "C%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "ET", "C", "ZZ", "ET", "C%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "DT", "C", "ZZ", "DT", "C%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "E", "E", "ZZ", "E", "E%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "D", "E", "ZZ", "D", "E%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "ET", "E", "ZZ", "ET", "E%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "DT", "E", "ZZ", "DT", "E%", "PA"));
		cdmsDAO.insert_CM_MG_PASAJE_VET2(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.VET2, orden++, TipoDato.ENTERO_01, "T", "E", "ZZ", "T%", null, "PA"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.PASCRU);
		}

		// Campo Adicional contiene el codigo de mercancia
		cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASCRU, orden++, TipoDato.ENTERO_01, "E", "C", "ZZ", "E", "C%", "'0001X', '0002X'"));
		cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASCRU, orden++, TipoDato.ENTERO_01, "D", "C", "ZZ", "D", "C%", "'0001X', '0002X'"));
		cdmsDAO.insert_CM_PASCRU(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.PASCRU, orden++,
						TipoDato.ENTERO_01, "ET", "C", "ZZ", "E%", "C%", "'0001C', '0002C'"));
		cdmsDAO.insert_CM_PASCRU(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.PASCRU, orden++,
						TipoDato.ENTERO_01, "DT", "C", "ZZ", "D%", "C%", "'0001C', '0002C'"));
		cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASCRU, orden++, TipoDato.ENTERO_01, "E", "E", "ZZ", "E", "E%", "'0001X', '0002X'"));
		cdmsDAO.insert_CM_PASCRU(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.PASCRU, orden++, TipoDato.ENTERO_01, "D", "E", "ZZ", "D", "E%", "'0001X', '0002X'"));
		cdmsDAO.insert_CM_PASCRU(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.PASCRU, orden++,
						TipoDato.ENTERO_01, "ET", "E", "ZZ", "E$", "E%", "'0001C', '0002C'"));
		cdmsDAO.insert_CM_PASCRU(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.PASCRU, orden++,
						TipoDato.ENTERO_01, "DT", "E", "ZZ", "D$", "E%", "'0001C', '0002C'"));
		cdmsDAO.insert_CM_PASCRU(
				new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA, CuadroMesConcepto.PASCRU, orden++,
						TipoDato.ENTERO_01, "T", "E", "ZZ", "T%", null, "'0001X', '0002X', '0001C', '0002C'"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.CNUMCA);
		}

		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "E", "C", "ZZ", "E", "C%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "D", "C", "ZZ", "D", "C%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "ET", "C", "ZZ", "ET", "C%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "DT", "C", "ZZ", "DT", "C%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "E", "E", "ZZ", "E", "E%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "D", "E", "ZZ", "D", "E%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "ET", "E", "ZZ", "ET", "E%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "DT", "E", "ZZ", "DT", "E%", null));
		cdmsDAO.insert_CM_CNUMCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMCA, orden++, TipoDato.ENTERO_01, "T", "E", "ZZ", "T%", null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.CTONCA);
		}

		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", null));
		cdmsDAO.insert_CM_CTONCA(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONCA, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.CNUMVA);
		}

		// Campo Adicional contiene codigo de mercancia
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "E", "C", "ZZ", "E", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "D", "C", "ZZ", "D", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "ET", "C", "ZZ", "ET", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "DT", "C", "ZZ", "DT", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "E", "E", "ZZ", "E", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "D", "E", "ZZ", "D", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "ET", "E", "ZZ", "ET", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "DT", "E", "ZZ", "DT", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CNUMVA, orden++, TipoDato.ENTERO_01, "T", "E", "ZZ", "T%", null, "8609*"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.CTONVA);
		}

		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", "8609*"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTONVA, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, "8609*"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.CTEUS);
		}

		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "E", "C", "ZZ", "E", "C%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "D", "C", "ZZ", "D", "C%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "ET", "C", "ZZ", "ET", "C%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "DT", "C", "ZZ", "DT", "C%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "E", "E", "ZZ", "E", "E%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "D", "E", "ZZ", "D", "E%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "ET", "E", "ZZ", "ET", "E%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "DT", "E", "ZZ", "DT", "E%", "8609%"));
		cdmsDAO.insert_CM_CNUMVA_CTONVA_CTEUS(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.CTEUS, orden++, TipoDato.DECIMAL_02, "T", "E", "ZZ", "T%", null, "8609%"));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.RRTEUS);
		}

		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "E", "C", "ZZ", "E", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "D", "C", "ZZ", "D", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "ET", "C", "ZZ", "ET", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "DT", "C", "ZZ", "DT", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "E", "E", "ZZ", "E", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "D", "E", "ZZ", "D", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "ET", "E", "ZZ", "ET", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "DT", "E", "ZZ", "DT", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTEUS, orden++, TipoDato.DECIMAL_02, "T", "E", "ZZ", "T%", null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.RRTONC);
		}

		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", null));
		cdmsDAO.insert_CM_RRTEUS_RRTONC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONC, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.RRTONO);
		}

		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "E", "C", "ZZ", "E", "C%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "D", "C", "ZZ", "D", "C%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "ET", "C", "ZZ", "ET", "C%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "DT", "C", "ZZ", "DT", "C%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "E", "E", "ZZ", "E", "E%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "D", "E", "ZZ", "D", "E%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "ET", "E", "ZZ", "ET", "E%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "DT", "E", "ZZ", "DT", "E%", null));
		cdmsDAO.insert_CM_RRTONO(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.RRTONO, orden++, TipoDato.DECIMAL_01, "T", "E", "ZZ", "T%", null, null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.TRALOC);
		}

		cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.TRALOC, orden++, TipoDato.DECIMAL_01, "E", "I", "ZZ", "E", "I%", null));
		cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.TRALOC, orden++, TipoDato.DECIMAL_01, "D", "I", "ZZ", "D", "I%", null));
		cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.TRALOC, orden++, TipoDato.DECIMAL_01, "ET", "I", "ZZ", "%T", "I%", null));
		cdmsDAO.insert_CM_TRALOC(new CuadroMesParametroVO(peprId, Entidad.MOVIMIENTO_MERCANCIA,
				CuadroMesConcepto.TRALOC, orden++, TipoDato.DECIMAL_01, "T", "I", "ZZ", "T%", "I%", null));

		if (LOG.isDebugEnabled()) {
			LOG.debug(CuadroMesConcepto.MCONV);
		}

		// CONSULTAS RESUMEN DE LA PROPIA TABLA DE CUADRO MES
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "E", "C",
				"ZZ", "E", "C", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "D", "C",
				"ZZ", "D", "C", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "ET",
				"C", "ZZ", "ET", "C", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "DT",
				"C", "ZZ", "DT", "C", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "E", "E",
				"ZZ", "E", "E", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "D", "E",
				"ZZ", "D", "E", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "ET",
				"E", "ZZ", "ET", "E", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "DT",
				"E", "ZZ", "DT", "E", null));
		cdmsDAO.insert_CM_MCONV(new CuadroMesParametroVO(peprId, null, CuadroMesConcepto.MCONV, orden++, null, "T", "E",
				"ZZ", "T", "E", null));
	}

	/**
	 * Cargar archivo.
	 *
	 * @param pepr
	 *            the pepr
	 * @param prtoMap
	 *            the prto map
	 * @param estdList
	 *            the estd list
	 * @param removeIfExists
	 *            the remove if exists
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void cargarArchivo(PeriodoProcesoVO pepr, Map<String, PuertoVO> prtoMap, List<EstadisticaVO> estdList,
			boolean removeIfExists) throws DuplicateInstanceException {

		final Date falta = Calendar.getInstance().getTime();

		// Si el periodo proceso ya existe
		if (peprDAO.exists(pepr)) {
			if (removeIfExists) {
				delete(pepr);
			} else {
				throw new DuplicateInstanceException(MessageI18nKey.pepr, pepr);
			}
		}

		// Obtener secuencias
		if (LOG.isDebugEnabled()) {
			LOG.debug("Obtencion de secuencias");
		}

		IgUtilBO.assignNextVal(pepr);
		pepr.setFalta(falta);

		for (final EstadisticaVO estd : estdList) {
			IgUtilBO.assignNextVal(estd);
			estd.setPepr(pepr);
		}

		for (final EstadisticaVO estd : estdList) {
			for (final ItemDatoVO itdt : estd.getItdtMap().values()) {
				// FIXME Validamos si los datos pasados son correctos??
				itdt.setItemId(estd.getId());
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Insercion de datos");
		}

		// Insertar
		peprDAO.insert(pepr);

		for (final EstadisticaVO estd : estdList) {
			estdDAO.insert(estd);
		}

		for (final EstadisticaVO estd : estdList) {
			for (final ItemDatoVO itdt : estd.getItdtMap().values()) {
				esdtDAO.insert(itdt);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Generacion de cuadro mensual");
		}

		generarCuadroMensual(pepr.getId(), removeIfExists);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Commit datos");
		}
	}

	/**
	 * Agregar servicios.
	 *
	 * @param pepr
	 *            the pepr
	 * @param removeIfExists
	 *            the remove if exists
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void agregarServicios(PeriodoProcesoVO pepr, boolean removeIfExists)
			throws DuplicateInstanceException, IOException {
		Preconditions.checkNotNull(pepr.getSprt());
		Preconditions.checkNotNull(pepr.getSprt().getId());
		Preconditions.checkNotNull(pepr.getAnio());
		Preconditions.checkNotNull(pepr.getMes());

		// Si el periodo proceso ya existe
		if (peprDAO.exists(pepr)) {
			if (removeIfExists) {
				if (LOG.isDebugEnabled()) {
					LOG.debug("Borrado del periodo de proceso existente");
				}

				delete(pepr);
			} else {
				throw new DuplicateInstanceException(MessageI18nKey.pepr, pepr);
			}
		}

		IgUtilBO.assignNextVal(pepr);
		pepr.setFalta(Calendar.getInstance().getTime());

		if (LOG.isDebugEnabled()) {
			LOG.debug("Busqueda de datos agregados");
		}

		final Calendar finicio = Calendar.getInstance();

		finicio.setTimeInMillis(0);
		finicio.set(Calendar.YEAR, pepr.getAnio());
		finicio.set(Calendar.MONTH, pepr.getMes() - 1);
		finicio.set(Calendar.DAY_OF_MONTH, 1);

		final Calendar ffin = Calendar.getInstance();

		ffin.setTimeInMillis(0);
		ffin.set(Calendar.YEAR, pepr.getAnio());
		ffin.set(Calendar.MONTH, pepr.getMes());
		ffin.set(Calendar.DAY_OF_MONTH, 1);

		final EstadisticaAgregadoCriterioVO esagCriterioVO = new EstadisticaAgregadoCriterioVO(pepr.getId(),
				pepr.getSprt().getId(), finicio.getTime(), ffin.getTime());

		final Map<Entidad, List<EstadisticaVO>> estdMap = new HashMap<Entidad, List<EstadisticaVO>>();

		if (LOG.isDebugEnabled()) {
			LOG.debug("Actividad Pesquera - update");
		}

		esagDAO.updateSrvcActividadPesquera(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Actividad Pesquera - select");
		}

		estdMap.put(Entidad.ACTIVIDAD_PESQUERA, obtenerEstadisticas(pepr, Entidad.ACTIVIDAD_PESQUERA.getId(),
				esagDAO.selectActividadPesquera(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Avituallamiento - update");
		}

		esagDAO.updateSrvcAvituallamiento(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Avituallamiento - select");
		}

		estdMap.put(Entidad.AVITUALLAMIENTO, obtenerEstadisticas(pepr, Entidad.AVITUALLAMIENTO.getId(),
				esagDAO.selectAvituallamiento(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Agregacion Superficie - update");
		}

		esagDAO.updateSrvcAgregacionSuperficie(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Agregacion Superficie - select");
		}

		estdMap.put(Entidad.AGREGACION_SUPERFICIE, obtenerEstadisticas(pepr, Entidad.AGREGACION_SUPERFICIE.getId(),
				esagDAO.selectAgregacionSuperficie(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Agregacion Escala - update");
		}

		esagDAO.updateSrvcAgregacionEscala(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Agregacion Escala - select");
		}

		estdMap.put(Entidad.AGREGACION_ESCALA, obtenerEstadisticas(pepr, Entidad.AGREGACION_ESCALA.getId(),
				esagDAO.selectAgregacionEscala(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Movimiento Tipo Buque EEE - update");
		}

		esagDAO.updateSrvcMovimientoTipoBuqueEEE(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Movimiento Tipo Buque EEE - select");
		}

		estdMap.put(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE, obtenerEstadisticas(pepr,
				Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId(), esagDAO.selectMovimientoTipoBuqueEEE(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Buque Fondeado Atracado - update");
		}

		esagDAO.updateSrvcBuqueFondeadoAtracado(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Buque Fondeado Atracado - select");
		}

		estdMap.put(Entidad.BUQUE_FONDEADO_ATRACADO, obtenerEstadisticas(pepr, Entidad.BUQUE_FONDEADO_ATRACADO.getId(),
				esagDAO.selectBuqueFondeadoAtracado(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Movimiento Mercancia - update");
		}

		esagDAO.updateSrvcMovimientoMercancia(esagCriterioVO);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Movimiento Mercancia - select");
		}

		estdMap.put(Entidad.MOVIMIENTO_MERCANCIA, obtenerEstadisticas(pepr, Entidad.MOVIMIENTO_MERCANCIA.getId(),
				esagDAO.selectMovimientoMercancia(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Movimiento Mercancia EEE - select");
		}

		estdMap.put(Entidad.MOVIMIENTO_MERCANCIA_EEE, obtenerEstadisticas(pepr,
				Entidad.MOVIMIENTO_MERCANCIA_EEE.getId(), esagDAO.selectMovimientoMercanciaEEE(esagCriterioVO)));

		if (LOG.isDebugEnabled()) {
			LOG.debug("Generacion de archivo de OPPE");
		}

		final byte[] buffer = generarArchivo(pepr, estdMap);

		final ArchivoVO arch = new ArchivoVO();
		final ArchivoInfoVO arin = new ArchivoInfoVO();

		IgUtilBO.assignNextVal(arin);
		arin.setNombre(pepr.getFilename() + ".zip");
		arin.setSentido(ArchivoSentido.S);
		arin.setFalta(Calendar.getInstance().getTime());
		arin.setTamanio((long) buffer.length);

		arch.setArin(arin);
		arch.setArchivo(buffer);

		pepr.setArin(arin);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Grabacion de Datos Agregados");
		}

		archDAO.insert(arch);
		peprDAO.insert(pepr);

		for (final Entidad entidad : estdMap.keySet()) {
			for (final EstadisticaVO estdVO : estdMap.get(entidad)) {
				estdDAO.insert(estdVO);
			}
		}

		for (final Entidad entidad : estdMap.keySet()) {
			for (final EstadisticaVO estdVO : estdMap.get(entidad)) {
				if (estdVO.getItdtMap() != null) {
					for (final ItemDatoVO itdtVO : estdVO.getItdtMap().values()) {
						itdtVO.setItemId(estdVO.getId());

						esdtDAO.insert(itdtVO);
					}
				}
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Cuadro Mensual");
		}

		generarCuadroMensual(pepr.getId(), removeIfExists);
	}

	/**
	 * Generar archivo.
	 *
	 * @param pepr
	 *            the pepr
	 * @param estdMap
	 *            the estd map
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private byte[] generarArchivo(@NonNull final PeriodoProcesoVO pepr,
			@NonNull final Map<Entidad, List<EstadisticaVO>> estdMap) throws IOException {
		final OppeFileExport export = new OppeFileExport();

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();
				final ZipOutputStream zipOutputStream = new ZipOutputStream(baos)) {

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAP));
			export.generarEAP(zipOutputStream, estdMap.get(Entidad.ACTIVIDAD_PESQUERA));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAV));
			export.generarEAV(zipOutputStream, estdMap.get(Entidad.AVITUALLAMIENTO));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAE));
			export.generarEAE(zipOutputStream, estdMap.get(Entidad.AGREGACION_ESCALA));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EMM));
			export.generarEMM(zipOutputStream, estdMap.get(Entidad.MOVIMIENTO_MERCANCIA));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EME));
			export.generarEME(zipOutputStream, estdMap.get(Entidad.MOVIMIENTO_MERCANCIA_EEE));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EMT));
			export.generarEMT(zipOutputStream, estdMap.get(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE));
			zipOutputStream.closeEntry();

			zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EPP));
			export.generarEPP(zipOutputStream, pepr, Calendar.getInstance().getTime());
			zipOutputStream.closeEntry();

			zipOutputStream.flush();
			zipOutputStream.close();

			return baos.toByteArray();
		}
	}

	/**
	 * Obtener estadisticas.
	 *
	 * @param pepr
	 *            the pepr
	 * @param tpesId
	 *            the tpes id
	 * @param esagList
	 *            the esag list
	 * @return the list
	 */
	private List<EstadisticaVO> obtenerEstadisticas(@NonNull final PeriodoProcesoVO pepr, @NonNull final Long tpesId,
			@NonNull final List<EstadisticaAgregadoVO> esagList) {

		final TipoEstadisticaDetailVO tpesDetail = entiProxy.selectTpes(tpesId);
		final List<EstadisticaVO> estdList = new ArrayList<>();

		for (final EstadisticaAgregadoVO esag : esagList) {
			final EstadisticaVO estd = new EstadisticaVO();

			IgUtilBO.assignNextVal(estd);

			estd.setEntiId(tpesId);
			estd.setPrto(esag.getPrto());
			estd.setPepr(pepr);
			estd.setItdtMap(new HashMap<Long, ItemDatoVO>());

			if (tpesDetail.getEntdList() != null) {
				for (final Long tpdtId : tpesDetail.getEntdList()) {
					final EntidadTipoDatoVO entd = tpesDetail.getEntdMap().get(tpdtId);
					final Object value = esag.getEsdtMap().get(entd.getTpdt().getCodigo());
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(entd.getTpdt().getId());
					estd.getItdtMap().put(entd.getTpdt().getId(), itdt);

					if (value == null) {
						if (entd.getTpdt().getTipoElemento() == TipoElemento.BO) {
							itdt.setCantidadEntera(0L);
						}
					} else {
						switch (entd.getTpdt().getTipoElemento()) {
						case BO:
						case NE:
							if (value instanceof BigDecimal) {
								itdt.setCantidadEntera(((BigDecimal) value).longValue());
							} else if (value instanceof Long) {
								itdt.setCantidadEntera(((Long) value).longValue());
							} else {
								itdt.setCantidadEntera(((Double) value).longValue());
							}

							break;
						case ND:
							if (value instanceof BigDecimal) {
								itdt.setCantidadDecimal(((BigDecimal) value).doubleValue());
							} else {
								itdt.setCantidadDecimal(((Double) value).doubleValue());
							}

							break;
						case PR:
							final ParametroVO prmt = new ParametroVO();

							if (value instanceof BigDecimal) {
								prmt.setId(((BigDecimal) value).longValue());
							} else {
								prmt.setId(((Long) value).longValue());
							}

							prmt.setParametro(
									String.valueOf(esag.getEsdtMap().get(entd.getTpdt().getCodigo() + "_prmt")));

							itdt.setPrmt(prmt);

							break;
						case SR:
							final ServicioVO srvc = new ServicioVO();

							if (value instanceof BigDecimal) {
								srvc.setId(((BigDecimal) value).longValue());
							} else {
								srvc.setId(((Long) value).longValue());
							}

							itdt.setSrvc(srvc);

							break;
						case CR:
						case TX:
							itdt.setCadena((String) value);

							break;
						case FE:
						case FH:
							/*
							 * if (value instanceof TIMESTAMP) {
							 * itdtVO.setFecha(((TIMESTAMP) value).dateValue());
							 * } else { itdtVO.setFecha((Date) value); }
							 */
							itdt.setFecha((Date) value);

							break;

						default:
							throw new Error("TipoElemento no encontrado: " + entd.getTpdt().getTipoElemento());
						}
					}
				}
			}

			estdList.add(estd);
		}

		return estdList;
	}
}
