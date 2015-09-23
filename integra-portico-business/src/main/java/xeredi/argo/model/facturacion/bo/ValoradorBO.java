package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.dao.CargoDAO;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.dao.ServicioCargoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionAgregadaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionTemporalDAO;
import xeredi.argo.model.facturacion.dao.ValoradorContextoDAO;
import xeredi.argo.model.facturacion.grammar.ConditionLexer;
import xeredi.argo.model.facturacion.grammar.ConditionParser;
import xeredi.argo.model.facturacion.grammar.ConditionSqlGenerator;
import xeredi.argo.model.facturacion.grammar.FormulaLexer;
import xeredi.argo.model.facturacion.grammar.FormulaParser;
import xeredi.argo.model.facturacion.grammar.FormulaSqlGenerator;
import xeredi.argo.model.facturacion.grammar.PathLexer;
import xeredi.argo.model.facturacion.grammar.PathParser;
import xeredi.argo.model.facturacion.grammar.PathSqlGenerator;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ServicioCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionAgregadaVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaAgregadaVO;
import xeredi.argo.model.facturacion.vo.ValoracionTemporalVO;
import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.ProcesoTemplate;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoradorBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorBO.class);

    /** The prbt. */
    private final ProcesoTemplate proceso;

    /**
     * Instantiates a new valorador bo.
     *
     * @param aproceso
     *            the aproceso
     */
    public ValoradorBO(final ProcesoTemplate aproceso) {
        super();
        proceso = aproceso;
    }

    /**
     * Valorar servicio.
     *
     * @param srvcId
     *            the srvc id
     * @param crgoIds
     *            the crgo ids
     * @param fechaLiquidacion
     *            the fecha liquidacion
     * @throws ModelException
     *             the model exception
     */
    public void valorarServicio(final Long srvcId, final Set<Long> crgoIds, final Date fechaLiquidacion)
            throws ModelException {
        LOG.info(
                "Valoracion - srvcId: " + srvcId + ", crgoIds: " + crgoIds + ", fechaLiquidacion: " + fechaLiquidacion);

        Preconditions.checkNotNull(srvcId);
        Preconditions.checkNotNull(crgoIds);
        Preconditions.checkNotNull(fechaLiquidacion);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final ValoradorContextoDAO contextoDAO = session.getMapper(ValoradorContextoDAO.class);
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final ValoracionTemporalDAO vlrtDAO = session.getMapper(ValoracionTemporalDAO.class);

            final ValoradorContextoVO vldrContexto = new ValoradorContextoVO();
            final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

            srvcCriterio.setId(srvcId);

            final ServicioVO srvc = srvcDAO.selectObject(srvcCriterio);

            if (srvc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcId);
            }

            if (crgoIds.isEmpty()) {
                final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

                crgoCriterioVO.setFechaVigencia(fechaLiquidacion);
                crgoCriterioVO.setSrvcId(srvcId);

                for (final CargoVO crgo : crgoDAO.selectList(crgoCriterioVO)) {
                    crgoIds.add(crgo.getId());
                }
            }

            vldrContexto.setFliquidacion(fechaLiquidacion);
            vldrContexto.setPrbt(proceso.getPrbt());
            vldrContexto.setSrvc(srvc);
            vldrContexto.setTpsr(TipoServicioProxy.select(vldrContexto.getSrvc().getEntiId()).getEnti());

            for (final Long crgoId : crgoIds) {
                // Obtencion de los cargos, y los cargos dependientes
                final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

                crgoCriterio.setId(crgoId);
                crgoCriterio.setFechaVigencia(fechaLiquidacion);
                crgoCriterio.setSoloPrincipales(true);

                final CargoVO crgo = crgoDAO.selectObject(crgoCriterio);

                if (crgo == null) {
                    throw new InstanceNotFoundException(MessageI18nKey.crgo, crgoId);
                }

                LOG.info("Cargo principal: " + crgo.getCodigo());

                final List<CargoVO> crgoList = new ArrayList<>();

                crgoList.add(crgo);

                final CargoCriterioVO crgoDepCriterio = new CargoCriterioVO();

                crgoDepCriterio.setPadreId(crgoId);
                crgoDepCriterio.setFechaVigencia(fechaLiquidacion);
                crgoDepCriterio.setSoloDependientes(true);

                vldrContexto.setCrgo(crgo);

                final Date fref = contextoDAO.selectFref(vldrContexto);

                if (fref == null) {
                    throw new Error("No se encuentra fecha de referencia para el contexto: " + vldrContexto);
                }

                vldrContexto.setFref(fref);

                LOG.info("fref: " + fref);

                crgoList.addAll(crgoDAO.selectList(crgoDepCriterio));

                for (final CargoVO crgoServicio : crgoList) {
                    vldrContexto.setCrgo(crgoServicio);
                    valorarCargoServicio(session, vldrContexto);
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

                    aplicarAspecto(session, vldrContexto);
                }

                if (vlrtDAO.existsPendiente(vldrContexto)) {
                    throw new Error("No se ha podido aplicar aspecto a todos los elementos del servicio valorado: "
                            + vldrContexto);
                }

                if (LOG.isDebugEnabled()) {
                    LOG.debug("Fin Valoracion");
                }
            }

            session.commit();
        }
    }

    /**
     * Aplicar aspecto.
     *
     * @param session
     *            the session
     * @param vldrContexto
     *            the contexto vo
     */
    private void aplicarAspecto(final SqlSession session, final ValoradorContextoVO vldrContexto) {
        final ValoracionAgregadaDAO vlraDAO = session.getMapper(ValoracionAgregadaDAO.class);
        final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
        final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
        final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
        final ValoracionTemporalDAO vlrtDAO = session.getMapper(ValoracionTemporalDAO.class);
        final ServicioCargoDAO srcrDAO = session.getMapper(ServicioCargoDAO.class);

        final IgBO igBO = new IgBO();

        generateSql(vldrContexto.getAspc());

        final List<ValoracionAgregadaVO> vlraList = vlraDAO.selectList(vldrContexto);
        final Set<Long> vlrcIds = new HashSet<Long>();
        final Map<Long, Long> vlrtIdMap = new HashMap<>();

        for (final ValoracionAgregadaVO vlra : vlraList) {
            vlra.getVlrc().setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            vlra.getVlrc().setAspc(vldrContexto.getAspc());
            vlra.getVlrc().setFalta(Calendar.getInstance().getTime());

            LOG.info("vlrc: " + vlra.getVlrc());

            proceso.addPritSalida(vlra.getVlrc().getId());

            vlrcIds.add(vlra.getVlrc().getId());

            Long vlrlPadreId = null;

            for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
                vlrl.getVlrl().setVlrcId(vlra.getVlrc().getId());
                vlrl.getVlrl().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

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

                for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
                    final Long vlrtId = vlrd.getId();
                    final Long vlrtPadreId = vlrd.getPadreId();

                    vlrtIdMap.put(vlrtId, igBO.nextVal(IgBO.SQ_INTEGRA));

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
        }

        if (!vlrcIds.isEmpty()) {
            final ServicioCargoCriterioVO srcrCriterio = new ServicioCargoCriterioVO();

            srcrCriterio.setVlrcIds(vlrcIds);
            srcrDAO.insertMarcarValorado(srcrCriterio);
            vlrtDAO.deleteList(vldrContexto);
        }
    }

    /**
     * Valorar cargo servicio.
     *
     * @param session
     *            the session
     * @param vldrContexto
     *            the contexto vo
     */
    private void valorarCargoServicio(final SqlSession session, final ValoradorContextoVO vldrContexto) {
        final ValoradorContextoDAO contextoDAO = session.getMapper(ValoradorContextoDAO.class);
        final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
        final ValoracionTemporalDAO vlrtDAO = session.getMapper(ValoracionTemporalDAO.class);

        LOG.info("Cargo: " + vldrContexto.getCrgo().getCodigo());

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

        final IgBO igBO = new IgBO();

        {
            // Aplicar procedimientos de tipo precio
            rglaCriterio.setTipo(ReglaTipo.T);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

                generateSql(rgla);
                vldrContexto.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaServicio(vldrContexto));

                    break;
                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaSubservicio(vldrContexto));

                    break;
                }

                final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                    vlrt.setPadreId(vlrt.getId());

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(vldrContexto.getFref());
                    vlrt.setFliquidacion(vldrContexto.getFliquidacion());

                    if (vldrContexto.getCrgo().getVersion().getTemporal()) {
                        vlrt.setFinicio(vldrContexto.getFini());
                        vlrt.setFfin(vldrContexto.getFfin());
                    }

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
            }
        }

        {
            // Aplicar procedimientos de tipo coeficiente
            rglaCriterio.setTipo(ReglaTipo.C);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

            for (final ReglaVO rgla : rglaList) {
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
                    vlrt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(vldrContexto.getFref());
                    vlrt.setFliquidacion(vldrContexto.getFliquidacion());

                    if (vldrContexto.getCrgo().getVersion().getTemporal()) {
                        vlrt.setFinicio(vldrContexto.getFini());
                        vlrt.setFfin(vldrContexto.getFfin());
                    }

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
            }
        }

        {
            // Aplicar procedimientos de tipo bonificacion
            rglaCriterio.setTipo(ReglaTipo.D);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterio);

            for (final ReglaVO rgla : rglaList) {
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
                    vlrt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(vldrContexto.getFref());
                    vlrt.setFliquidacion(vldrContexto.getFliquidacion());

                    if (vldrContexto.getCrgo().getVersion().getTemporal()) {
                        vlrt.setFinicio(vldrContexto.getFini());
                        vlrt.setFfin(vldrContexto.getFfin());
                    }

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
            }
        }
    }

    /**
     * Generate sql.
     *
     * @param rgla
     *            the rgla
     */
    private void generateSql(final ReglaVO rgla) {
        final AbstractEntidadDetailVO entiDetail = EntidadProxy.select(rgla.getEnti().getId());

        rgla.getVersion().setPathImpuestoSql(generateSqlPath(entiDetail, rgla.getVersion().getPathImpuesto(), false));
        rgla.getVersion().setPathPagadorSql(generateSqlPath(entiDetail, rgla.getVersion().getPathPagador(), false));
        rgla.getVersion()
                .setPathEsSujPasivoSql(generateSqlPath(entiDetail, rgla.getVersion().getPathEsSujPasivo(), false));
        rgla.getVersion().setPathCodExenSql(generateSqlPath(entiDetail, rgla.getVersion().getPathCodExen(), false));

        rgla.getVersion().setPathInfo1Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo1(), true));
        rgla.getVersion().setPathInfo2Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo2(), true));
        rgla.getVersion().setPathInfo3Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo3(), true));
        rgla.getVersion().setPathInfo4Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo4(), true));
        rgla.getVersion().setPathInfo5Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo5(), true));
        rgla.getVersion().setPathInfo6Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathInfo6(), true));

        rgla.getVersion().setPathCuant1Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant1(), false));
        rgla.getVersion().setPathCuant2Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant2(), false));
        rgla.getVersion().setPathCuant3Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant3(), false));
        rgla.getVersion().setPathCuant4Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant4(), false));
        rgla.getVersion().setPathCuant5Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant5(), false));
        rgla.getVersion().setPathCuant6Sql(generateSqlPath(entiDetail, rgla.getVersion().getPathCuant6(), false));

        rgla.getVersion().setCondicionSql(generateSqlCondition(rgla, rgla.getVersion().getCondicion()));
        rgla.getVersion().setFormulaSql(generateSqlFormula(rgla, rgla.getVersion().getFormula()));
    }

    /**
     * Generate sql.
     *
     * @param aspc
     *            the aspc
     */
    private void generateSql(final AspectoVO aspc) {
        final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(aspc.getTpsr().getId());

        aspc.getVersion().setCpathInfo1Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo1(), true));
        aspc.getVersion().setCpathInfo2Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo2(), true));
        aspc.getVersion().setCpathInfo3Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo3(), true));
        aspc.getVersion().setCpathInfo4Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo4(), true));
        aspc.getVersion().setCpathInfo5Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo5(), true));
        aspc.getVersion().setCpathInfo6Sql(generateSqlPath(tpsrDetail, aspc.getVersion().getCpathInfo6(), true));
    }

    /**
     * Generate sql path.
     *
     * @param entidadDetail
     *            the entidad detail
     * @param expression
     *            the expression
     * @param generateLabel
     *            the generate label
     * @return the string
     */
    private String generateSqlPath(final AbstractEntidadDetailVO entidadDetail, final String expression,
            final boolean generateLabel) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final PathSqlGenerator pathSqlGenerator = new PathSqlGenerator(entidadDetail, generateLabel);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final PathLexer lexer = new PathLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokens);
        final ParseTree tree = parser.value();

        return pathSqlGenerator.visit(tree).toString();
    }

    /**
     * Generate sql condition.
     *
     * @param regla
     *            the regla
     * @param expression
     *            the expression
     * @return the string
     */
    private String generateSqlCondition(final ReglaVO regla, final String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final ConditionSqlGenerator conditionSqlGenerator = new ConditionSqlGenerator(regla);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final ConditionLexer lexer = new ConditionLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ConditionParser parser = new ConditionParser(tokens);
        final ParseTree tree = parser.condition();

        return conditionSqlGenerator.visit(tree).toString();
    }

    /**
     * Generate sql formula.
     *
     * @param regla
     *            the regla
     * @param expression
     *            the expression
     * @return the string
     */
    private String generateSqlFormula(final ReglaVO regla, final String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final FormulaSqlGenerator formulaSqlGenerator = new FormulaSqlGenerator(regla);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final FormulaLexer lexer = new FormulaLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final FormulaParser parser = new FormulaParser(tokens);
        final ParseTree tree = parser.formula();

        return formulaSqlGenerator.visit(tree).toString();
    }
}