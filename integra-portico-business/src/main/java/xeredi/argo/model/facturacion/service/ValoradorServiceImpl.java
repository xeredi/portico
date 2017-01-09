package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.dao.CargoDAO;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionAgregadaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionTemporalDAO;
import xeredi.argo.model.facturacion.dao.ValoradorContextoDAO;
import xeredi.argo.model.facturacion.grammar.ExpressionLexer;
import xeredi.argo.model.facturacion.grammar.ExpressionParser;
import xeredi.argo.model.facturacion.grammar.ExpressionSqlGenerator;
import xeredi.argo.model.facturacion.grammar.PathType;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.AspectoVersionVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ReglaVersionVO;
import xeredi.argo.model.facturacion.vo.ValoracionAgregadaVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaAgregadaVO;
import xeredi.argo.model.facturacion.vo.ValoracionTemporalVO;
import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.service.TipoServicioProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorServiceImpl.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class ValoradorServiceImpl implements ValoradorService {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ValoradorServiceImpl.class);

	/** The aspc DAO. */
	@Inject
	private AspectoDAO aspcDAO;

	/** The vlrt DAO. */
	@Inject
	private ValoracionTemporalDAO vlrtDAO;

	/** The srvc DAO. */
	@Inject
	private ServicioDAO srvcDAO;

	/** The crgo DAO. */
	@Inject
	private CargoDAO crgoDAO;

	/** The contexto DAO. */
	@Inject
	private ValoradorContextoDAO contextoDAO;

	/** The vlrc DAO. */
	@Inject
	private ValoracionDAO vlrcDAO;

	/** The vlrl DAO. */
	@Inject
	private ValoracionLineaDAO vlrlDAO;

	/** The vlrd DAO. */
	@Inject
	private ValoracionDetalleDAO vlrdDAO;

	/** The vlra DAO. */
	@Inject
	private ValoracionAgregadaDAO vlraDAO;

	/** The rgla DAO. */
	@Inject
	private ReglaDAO rglaDAO;

	/** The tpsr proxy. */
	@Inject
	private TipoServicioProxyService tpsrProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Long> valorarServicio(@NonNull final ProcesoVO prbt, @NonNull final Long srvcId,
			@NonNull final Set<Long> crgoIds, @NonNull final Date fechaLiquidacion) throws ModelException {
		LOG.info(
				"Valoracion - srvcId: " + srvcId + ", crgoIds: " + crgoIds + ", fechaLiquidacion: " + fechaLiquidacion);

		Preconditions.checkNotNull(srvcId);
		Preconditions.checkNotNull(crgoIds);
		Preconditions.checkNotNull(fechaLiquidacion);

		final List<Long> vlrcIds = new ArrayList<>();

		final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

		srvcCriterio.setId(srvcId);

		final ServicioVO srvc = srvcDAO.selectObject(srvcCriterio);

		if (srvc == null) {
			throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcId);
		}

		if (crgoIds.isEmpty()) {
			final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

			crgoCriterio.setFechaVigencia(fechaLiquidacion);
			crgoCriterio.setSrvcId(srvcId);
			crgoCriterio.setSoloPrincipales(true);

			for (final CargoVO crgo : crgoDAO.selectList(crgoCriterio)) {
				crgoIds.add(crgo.getId());
			}
		}

		final TipoServicioDetailVO tpsr = tpsrProxy.select(srvc.getEntiId());

		if (!tpsr.getEnti().getEstadosVlrcSet().contains(srvc.getEstado())) {
			throw new Error("Servicio en estado no facturable: " + srvc.getEstado());
		}

		final ValoradorContextoVO vldrContexto = new ValoradorContextoVO();

		vldrContexto.setFliquidacion(fechaLiquidacion);
		vldrContexto.setPrbt(prbt);
		vldrContexto.setSrvc(srvc);
		vldrContexto.setTpsr(tpsr.getEnti());

		for (final Long crgoId : crgoIds) {
			// Obtencion de los cargos, y los cargos dependientes
			final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

			crgoCriterio.setId(crgoId);
			crgoCriterio.setFechaVigencia(fechaLiquidacion);

			final CargoVO crgo = crgoDAO.selectObject(crgoCriterio);

			if (crgo == null) {
				throw new InstanceNotFoundException(MessageI18nKey.crgo, crgoId);
			}

			LOG.info("Cargo principal: " + crgo.getCodigo());

			final List<CargoVO> crgoList = new ArrayList<>();

			crgoList.add(crgo);

			vldrContexto.setCrgo(crgo);

			final Date fref = contextoDAO.selectFref(vldrContexto);

			if (fref == null) {
				throw new Error("No se encuentra fecha de referencia para el contexto: " + vldrContexto);
			}

			vldrContexto.setFref(fref);

			LOG.info("fref: " + fref);

			if (crgo.getVersion().getTemporal()) {
				vldrContexto.setFini(contextoDAO.selectFini(vldrContexto));
				vldrContexto.setFfin(contextoDAO.selectFfin(vldrContexto));

				LOG.info("fini: " + vldrContexto.getFini());
				LOG.info("ffin: " + vldrContexto.getFfin());

				if (vldrContexto.getFini() == null) {
					throw new Error("No se encuentra fecha de inicio para el contexto: " + vldrContexto);
				}
				if (vldrContexto.getFfin() == null) {
					throw new Error("No se encuentra fecha de fin para el contexto: " + vldrContexto);
				}
			}

			LOG.info("Busqueda de cargos dependientes de: " + crgo.getCodigo());

			final CargoCriterioVO crgoDepCriterio = new CargoCriterioVO();

			crgoDepCriterio.setPadreId(crgoId);
			crgoDepCriterio.setFechaVigencia(fechaLiquidacion);
			crgoDepCriterio.setSoloDependientes(true);

			crgoList.addAll(crgoDAO.selectList(crgoDepCriterio));

			for (final CargoVO crgoServicio : crgoList) {
				LOG.info("Cargo: " + crgoServicio.getCodigo());

				vldrContexto.setCrgo(crgoServicio);
				valorarCargoServicio(vldrContexto);
			}

			final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

			aspcCriterio.setFechaVigencia(fref);
			aspcCriterio.setSrvcId(srvcId);

			final List<AspectoVO> aspcList = aspcDAO.selectList(aspcCriterio);

			if (aspcList.isEmpty()) {
				throw new InstanceNotFoundException(MessageI18nKey.aspc, aspcCriterio);
			}

			for (final AspectoVO aspc : aspcList) {
				vldrContexto.setAspc(aspc);

				vlrcIds.addAll(aplicarAspecto(vldrContexto));
			}

			if (vlrtDAO.existsPendiente(vldrContexto)) {
				throw new Error(
						"No se ha podido aplicar aspecto a todos los elementos del servicio valorado: " + vldrContexto);
			}

			if (LOG.isDebugEnabled()) {
				LOG.debug("Fin Valoracion");
			}
		}

		return vlrcIds;
	}

	/**
	 * Aplicar aspecto.
	 *
	 * @param vldrContexto
	 *            the vldr contexto
	 * @return the list
	 */
	private List<Long> aplicarAspecto(final ValoradorContextoVO vldrContexto) {
		generateSql(vldrContexto.getAspc());

		final List<ValoracionAgregadaVO> vlraList = vlraDAO.selectList(vldrContexto);
		final List<Long> vlrcIds = new ArrayList<>();
		final Map<Long, Long> vlrtIdMap = new HashMap<>();

		for (final ValoracionAgregadaVO vlra : vlraList) {
			IgUtilBO.assignNextVal(vlra.getVlrc());

			vlra.getVlrc().setAspc(vldrContexto.getAspc());
			vlra.getVlrc().setFalta(Calendar.getInstance().getTime());

			vlra.getVlrc().setFini(vldrContexto.getFini());
			vlra.getVlrc().setFfin(vldrContexto.getFfin());

			LOG.info("vlrc: " + vlra.getVlrc());

			vlrcIds.add(vlra.getVlrc().getId());

			Long vlrlPadreId = null;

			for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
				vlrl.getVlrl().setVlrcId(vlra.getVlrc().getId());

				// Asignacion de fechas
				if (vlrl.getVlrl().getFini() != null && (vlra.getVlrc().getFini() == null
						|| vlrl.getVlrl().getFini().before(vlra.getVlrc().getFini()))) {
					vlra.getVlrc().setFini(vlrl.getVlrl().getFini());
				}
				if (vlrl.getVlrl().getFfin() != null && (vlra.getVlrc().getFfin() == null
						|| vlrl.getVlrl().getFfin().after(vlra.getVlrc().getFfin()))) {
					vlra.getVlrc().setFfin(vlrl.getVlrl().getFfin());
				}

				IgUtilBO.assignNextVal(vlrl.getVlrl());

				if (vlrl.getVlrl().getRgla().getTipo() == ReglaTipo.T) {
					vlrlPadreId = vlrl.getVlrl().getId();
				} else {
					vlrl.getVlrl().setInfo1(null);
					vlrl.getVlrl().setInfo2(null);
					vlrl.getVlrl().setInfo3(null);
					vlrl.getVlrl().setInfo4(null);
					vlrl.getVlrl().setInfo5(null);
					vlrl.getVlrl().setInfo6(null);

					vlrl.getVlrl().setImpuesto(null);
					vlrl.getVlrl().setSsrv(null);
				}

				vlrl.getVlrl().setPadreId(vlrlPadreId);

				// LOG.debug("vlrl: " + vlrl.getVlrl());

				for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
					Preconditions.checkNotNull(vlrd.getId());
					Preconditions.checkNotNull(vlrd.getPadreId());

					// LOG.debug("vlrd: " + vlrd);

					final ValoracionDetalleVO vlrdNew = new ValoracionDetalleVO();

					IgUtilBO.assignNextVal(vlrdNew);

					final Long vlrtId = vlrd.getId();
					final Long vlrtPadreId = vlrd.getPadreId();

					vlrtIdMap.put(vlrtId, vlrdNew.getId());

					Preconditions.checkNotNull(vlrtIdMap.get(vlrd.getId()));
					Preconditions.checkNotNull(vlrtIdMap.get(vlrd.getPadreId()));

					vlrd.setVlrcId(vlra.getVlrc().getId());
					vlrd.setVlrlId(vlrl.getVlrl().getId());
					vlrd.setId(vlrtIdMap.get(vlrtId));
					vlrd.setPadreId(vlrtIdMap.get(vlrtPadreId));
				}
			}
		}

		for (final ValoracionAgregadaVO vlra : vlraList) {
			vlrcDAO.insert(vlra.getVlrc());
		}

		for (final ValoracionAgregadaVO vlra : vlraList) {
			for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
				vlrlDAO.insert(vlrl.getVlrl());
			}
		}

		for (final ValoracionAgregadaVO vlra : vlraList) {
			for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
				for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
					vlrdDAO.insert(vlrd);
				}
			}

			vlrcDAO.updateImporte(vlra.getVlrc().getId());
		}

		if (!vlrcIds.isEmpty()) {
			vlrtDAO.deleteList(vldrContexto);
		}

		return vlrcIds;
	}

	/**
	 * Valorar cargo servicio.
	 *
	 * @param vldrContexto
	 *            the vldr contexto
	 */
	private void valorarCargoServicio(final ValoradorContextoVO vldrContexto) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Contexto: " + vldrContexto);
		}

		final Date fini = contextoDAO.selectFini(vldrContexto);
		final Date ffin = contextoDAO.selectFfin(vldrContexto);

		vldrContexto.setFini(fini);
		vldrContexto.setFfin(ffin);

		// Obtener Reglas de Tipo Precio

		final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

		rglaCriterio.setCrgoId(vldrContexto.getCrgo().getId());
		rglaCriterio.setFechaVigencia(vldrContexto.getFref());

		{
			// Aplicar procedimientos de tipo precio
			rglaCriterio.setTipo(ReglaTipo.T);

			final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

			for (final ReglaVO rgla : rglaList) {
				try {
					LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

					generateSql(rgla);
					vldrContexto.setRgla(rgla);

					final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

					switch (rgla.getEnti().getTipo()) {
					case T:
						vldrContexto.setEstadosVlrcSet(
								TipoServicioProxy.select(rgla.getEnti().getId()).getEnti().getEstadosVlrcSet());

						vlrtList.addAll(vlrtDAO.selectAplicarReglaServicio(vldrContexto));

						break;
					default:
						vldrContexto.setEstadosVlrcSet(
								TipoSubservicioProxy.select(rgla.getEnti().getId()).getEnti().getEstadosVlrcSet());

						vlrtList.addAll(vlrtDAO.selectAplicarReglaSubservicio(vldrContexto));

						break;
					}

					final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

					for (final ValoracionTemporalVO vlrt : vlrtList) {
						IgUtilBO.assignNextVal(vlrt);

						vlrt.setPadreId(vlrt.getId());

						vlrt.setRgla(rgla);
						vlrt.setFreferencia(vldrContexto.getFref());
						vlrt.setFliquidacion(vldrContexto.getFliquidacion());

						if (vlrt.getImporte() == -0.0) {
							vlrt.setImporte(+0.0);
						}

						if (vlrt.getImporteInc() == null) {
							vlrtListGanadores.add(vlrt);

						} else if (vlrt.getImporte() < vlrt.getImporteInc()) {
							vlrtListGanadores.add(vlrt);

							vlrtDAO.deleteIncompatibilidadList(vlrt);
						}
					}

					for (final ValoracionTemporalVO vlrt : vlrtListGanadores) {
						vlrtDAO.insert(vlrt);
					}
				} catch (final Throwable ex) {
					throw new Error(rgla.getCodigo() + " - " + ex.getMessage(), ex);
				}
			}
		}

		{
			// Aplicar procedimientos de tipo coeficiente
			rglaCriterio.setTipo(ReglaTipo.C);

			final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

			for (final ReglaVO rgla : rglaList) {
				try {
					LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

					generateSql(rgla);
					vldrContexto.setRgla(rgla);

					final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

					switch (rgla.getEnti().getTipo()) {
					case T:
						vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(vldrContexto));

						break;

					default:
						vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(vldrContexto));

						break;
					}

					boolean incompatibilidadFound = false;

					final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

					for (final ValoracionTemporalVO vlrt : vlrtList) {
						IgUtilBO.assignNextVal(vlrt);

						vlrt.setRgla(rgla);
						vlrt.setFreferencia(vldrContexto.getFref());
						vlrt.setFliquidacion(vldrContexto.getFliquidacion());

						if (vlrt.getImporte() == -0.0) {
							vlrt.setImporte(+0.0);
						}

						if (vlrt.getImporteInc() == null) {
							vlrtListGanadores.add(vlrt);
						} else if (vlrt.getImporte() < vlrt.getImporteInc()) {
							incompatibilidadFound = true;

							vlrtListGanadores.add(vlrt);
							vlrtDAO.deleteIncompatibilidadList(vlrt);
						}
					}

					for (final ValoracionTemporalVO vlrt : vlrtListGanadores) {
						vlrtDAO.insert(vlrt);
					}

					if (incompatibilidadFound) {
						LOG.info("Incompatibilidades. Recalcular Importes!!");

						vlrtDAO.updateRecalcularCargo(vldrContexto);
					}
				} catch (final Throwable ex) {
					throw new Error(rgla.getCodigo() + " - " + ex.getMessage(), ex);
				}
			}
		}

		{
			// Aplicar procedimientos de tipo bonificacion
			rglaCriterio.setTipo(ReglaTipo.D);

			final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

			for (final ReglaVO rgla : rglaList) {
				try {
					LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

					generateSql(rgla);
					vldrContexto.setRgla(rgla);

					final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

					switch (rgla.getEnti().getTipo()) {
					case T:
						vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(vldrContexto));

						break;

					default:
						vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(vldrContexto));

						break;
					}

					boolean incompatibilidadFound = false;

					final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

					for (final ValoracionTemporalVO vlrt : vlrtList) {
						IgUtilBO.assignNextVal(vlrt);

						vlrt.setRgla(rgla);
						vlrt.setFreferencia(vldrContexto.getFref());
						vlrt.setFliquidacion(vldrContexto.getFliquidacion());

						if (vlrt.getImporte() == -0.0) {
							vlrt.setImporte(+0.0);
						}

						if (vlrt.getImporteInc() == null) {
							vlrtListGanadores.add(vlrt);
						} else if (vlrt.getImporte() < vlrt.getImporteInc()) {
							incompatibilidadFound = true;

							vlrtListGanadores.add(vlrt);
							vlrtDAO.deleteIncompatibilidadList(vlrt);
						}
					}

					for (final ValoracionTemporalVO vlrt : vlrtListGanadores) {
						vlrtDAO.insert(vlrt);
					}

					if (incompatibilidadFound) {
						LOG.info("Incompatibilidades. Recalcular Importes!!");

						vlrtDAO.updateRecalcularCargo(vldrContexto);
					}
				} catch (final Throwable ex) {
					throw new Error(rgla.getCodigo() + " - " + ex.getMessage(), ex);
				}
			}
		}
	}

	/**
	 * Generate sql.
	 *
	 * @param rgla
	 *            the rgla
	 */
	private void generateSql(@NonNull final ReglaVO rgla) {
		Preconditions.checkNotNull(rgla.getEnti());
		Preconditions.checkNotNull(rgla.getEnti().getId());
		Preconditions.checkNotNull(rgla.getVersion());

		final Long entiId = rgla.getEnti().getId();
		final ReglaVersionVO rglv = rgla.getVersion();

		rglv.setPathImpuestoSql(generateSqlExpression(entiId, rglv.getPathImpuesto(), PathType.ID));
		rglv.setPathPagadorSql(generateSqlExpression(entiId, rglv.getPathPagador(), PathType.ID));
		rglv.setPathEsSujPasivoSql(generateSqlExpression(entiId, rglv.getPathEsSujPasivo(), PathType.ID));
		rglv.setPathCodExenSql(generateSqlExpression(entiId, rglv.getPathCodExen(), PathType.ID));

		rglv.setPathInfo1Sql(generateSqlExpression(entiId, rglv.getPathInfo1(), PathType.LABEL));
		rglv.setPathInfo2Sql(generateSqlExpression(entiId, rglv.getPathInfo2(), PathType.LABEL));
		rglv.setPathInfo3Sql(generateSqlExpression(entiId, rglv.getPathInfo3(), PathType.LABEL));
		rglv.setPathInfo4Sql(generateSqlExpression(entiId, rglv.getPathInfo4(), PathType.LABEL));
		rglv.setPathInfo5Sql(generateSqlExpression(entiId, rglv.getPathInfo5(), PathType.LABEL));
		rglv.setPathInfo6Sql(generateSqlExpression(entiId, rglv.getPathInfo6(), PathType.LABEL));

		rglv.setPathCuant1Sql(generateSqlExpression(entiId, rglv.getPathCuant1(), PathType.ID));
		rglv.setPathCuant2Sql(generateSqlExpression(entiId, rglv.getPathCuant2(), PathType.ID));
		rglv.setPathCuant3Sql(generateSqlExpression(entiId, rglv.getPathCuant3(), PathType.ID));
		rglv.setPathCuant4Sql(generateSqlExpression(entiId, rglv.getPathCuant4(), PathType.ID));
		rglv.setPathCuant5Sql(generateSqlExpression(entiId, rglv.getPathCuant5(), PathType.ID));
		rglv.setPathCuant6Sql(generateSqlExpression(entiId, rglv.getPathCuant6(), PathType.ID));

		rglv.setCondicionSql(generateSqlExpression(entiId, rglv.getCondicion(), PathType.CODE));
		rglv.setValorBaseSql(generateSqlExpression(entiId, rglv.getValorBase(), PathType.ID));
		rglv.setFormulaSql(generateSqlExpression(entiId, rglv.getFormula(), PathType.ID));
	}

	/**
	 * Generate sql.
	 *
	 * @param aspc
	 *            the aspc
	 */
	private void generateSql(@NonNull final AspectoVO aspc) {
		Preconditions.checkNotNull(aspc.getTpsr());
		Preconditions.checkNotNull(aspc.getTpsr().getId());
		Preconditions.checkNotNull(aspc.getVersion());

		final AspectoVersionVO aspv = aspc.getVersion();
		final Long entiId = aspc.getTpsr().getId();

		aspv.setCpathInfo1Sql(generateSqlExpression(entiId, aspv.getCpathInfo1(), PathType.LABEL));
		aspv.setCpathInfo2Sql(generateSqlExpression(entiId, aspv.getCpathInfo2(), PathType.LABEL));
		aspv.setCpathInfo3Sql(generateSqlExpression(entiId, aspv.getCpathInfo3(), PathType.LABEL));
		aspv.setCpathInfo4Sql(generateSqlExpression(entiId, aspv.getCpathInfo4(), PathType.LABEL));
		aspv.setCpathInfo5Sql(generateSqlExpression(entiId, aspv.getCpathInfo5(), PathType.LABEL));
		aspv.setCpathInfo6Sql(generateSqlExpression(entiId, aspv.getCpathInfo6(), PathType.LABEL));
	}

	/**
	 * Generate sql expression.
	 *
	 * @param entiId
	 *            the enti id
	 * @param expression
	 *            the expression
	 * @param pathType
	 *            the path type
	 * @return the string
	 */
	private String generateSqlExpression(@NonNull final Long entiId, final String expression, final PathType pathType) {
		if (expression == null || expression.isEmpty()) {
			return null;
		}

		final ExpressionSqlGenerator sqlGenerator = new ExpressionSqlGenerator(entiId, pathType);

		final ANTLRInputStream input = new ANTLRInputStream(expression);
		final ExpressionLexer lexer = new ExpressionLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final ExpressionParser parser = new ExpressionParser(tokens);
		final ParseTree tree = parser.expression();

		return sqlGenerator.visit(tree).toString();
	}
}
