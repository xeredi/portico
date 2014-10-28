package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.dao.CargoDAO;
import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.dao.ServicioCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionAgregadaDAO;
import xeredi.integra.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.integra.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.integra.model.facturacion.dao.ValoracionTemporalDAO;
import xeredi.integra.model.facturacion.dao.ValoradorContextoDAO;
import xeredi.integra.model.facturacion.grammar.ConditionSqlGenerator;
import xeredi.integra.model.facturacion.grammar.FormulaSqlGenerator;
import xeredi.integra.model.facturacion.grammar.PathSqlGenerator;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ServicioCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionAgregadaVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaAgregadaVO;
import xeredi.integra.model.facturacion.vo.ValoracionTemporalVO;
import xeredi.integra.model.facturacion.vo.ValoradorContextoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.proceso.dao.ProcesoDAO;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.grammar.ConditionLexer;
import xeredi.integra.model.util.grammar.ConditionParser;
import xeredi.integra.model.util.grammar.FormulaLexer;
import xeredi.integra.model.util.grammar.FormulaParser;
import xeredi.integra.model.util.grammar.PathLexer;
import xeredi.integra.model.util.grammar.PathParser;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoradorBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorBO.class);

    /** The srvc dao. */
    ServicioDAO srvcDAO;

    /** The crgo dao. */
    CargoDAO crgoDAO;

    /** The prbt dao. */
    ProcesoDAO prbtDAO;

    /** The rgla dao. */
    ReglaDAO rglaDAO;

    /** The vlrt dao. */
    ValoracionTemporalDAO vlrtDAO;

    /** The aspc dao. */
    AspectoDAO aspcDAO;

    /** The vlra dao. */
    ValoracionAgregadaDAO vlraDAO;

    /** The vlrc dao. */
    ValoracionDAO vlrcDAO;

    /** The vlrl dao. */
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    ValoracionDetalleDAO vlrdDAO;

    /** The vlri dao. */
    ValoracionImpuestoDAO vlriDAO;

    /** The contexto dao. */
    ValoradorContextoDAO contextoDAO;

    /** The srcr dao. */
    ServicioCargoDAO srcrDAO;

    /** The vlrg dao. */
    ValoracionCargoDAO vlrgDAO;

    /**
     * Valorar servicio.
     *
     * @param srvcId
     *            the srvc id
     * @param crgoIds
     *            the crgo ids
     * @param fechaLiquidacion
     *            the fecha liquidacion
     * @param prbtId
     *            the prbt id
     */
    public void valorarServicio(final Long srvcId, final Set<Long> crgoIds, final Date fechaLiquidacion,
            final Long prbtId) {
        LOG.info("Valoracion - srvcId: " + srvcId + ", crgoIds: " + crgoIds + ", fechaLiquidacion: " + fechaLiquidacion
                + ", prbtId: " + prbtId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            prbtDAO = session.getMapper(ProcesoDAO.class);
            crgoDAO = session.getMapper(CargoDAO.class);
            contextoDAO = session.getMapper(ValoradorContextoDAO.class);
            aspcDAO = session.getMapper(AspectoDAO.class);

            Preconditions.checkNotNull(srvcId);
            Preconditions.checkNotNull(crgoIds);
            Preconditions.checkNotNull(fechaLiquidacion);
            Preconditions.checkNotNull(prbtId);

            final ValoradorContextoVO contextoVO = new ValoradorContextoVO();
            final ProcesoVO prbt = prbtDAO.select(prbtId);
            final ServicioVO srvc = srvcDAO.select(srvcId);

            if (prbt == null) {
                throw new Error("Proceso Batch no encontrado: " + prbt);
            }
            if (srvc == null) {
                throw new Error("Servicio no encontrado: " + srvc);
            }

            contextoVO.setFliquidacion(fechaLiquidacion);
            contextoVO.setPrbt(prbt);
            contextoVO.setSrvc(srvc);
            contextoVO.setTpsr(TipoServicioProxy.select(contextoVO.getSrvc().getEntiId()));

            for (final Long crgoId : crgoIds) {
                // Obtencion de los cargos, y los cargos dependientes
                final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

                crgoCriterioVO.setId(crgoId);
                crgoCriterioVO.setFechaVigencia(fechaLiquidacion);
                crgoCriterioVO.setSoloPrincipales(true);

                final CargoVO crgo = crgoDAO.selectObject(crgoCriterioVO);

                if (crgo == null) {
                    throw new Error("No se encuentra el cargo: " + crgoCriterioVO);
                }

                LOG.info("Cargo principal: " + crgo.getCodigo());

                final List<CargoVO> crgoList = new ArrayList<>();

                crgoList.add(crgo);

                final CargoCriterioVO crgoDepCriterioVO = new CargoCriterioVO();

                crgoDepCriterioVO.setPadreId(crgoId);
                crgoDepCriterioVO.setFechaVigencia(fechaLiquidacion);
                crgoDepCriterioVO.setSoloDependientes(true);

                contextoVO.setCrgo(crgo);

                final Date fref = contextoDAO.selectFref(contextoVO);

                if (fref == null) {
                    throw new Error("No se encuentra fecha de referencia para el contexto: " + contextoVO);
                }

                contextoVO.setFref(fref);

                LOG.info("fref: " + fref);

                crgoList.addAll(crgoDAO.selectList(crgoDepCriterioVO));

                for (final CargoVO crgoServicio : crgoList) {
                    contextoVO.setCrgo(crgoServicio);
                    valorarCargoServicio(session, contextoVO);
                }

                final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

                aspcCriterioVO.setFechaVigencia(fref);
                aspcCriterioVO.setSrvcId(srvcId);

                final List<AspectoVO> aspcList = aspcDAO.selectList(aspcCriterioVO);

                if (aspcList.isEmpty()) {
                    throw new Error("No se encuentran aspectos para: " + aspcCriterioVO);
                }

                for (final AspectoVO aspc : aspcList) {
                    contextoVO.setAspc(aspc);

                    aplicarAspecto(session, contextoVO);
                }

                if (vlrtDAO.existsPendiente(contextoVO)) {
                    throw new Error("No se ha podido aplicar aspecto a todos los elementos del servicio valorado: "
                            + contextoVO);
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
     * @param contextoVO
     *            the contexto vo
     */
    private void aplicarAspecto(final SqlSession session, final ValoradorContextoVO contextoVO) {
        vlraDAO = session.getMapper(ValoracionAgregadaDAO.class);
        vlrcDAO = session.getMapper(ValoracionDAO.class);
        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
        vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
        vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
        vlrtDAO = session.getMapper(ValoracionTemporalDAO.class);
        srcrDAO = session.getMapper(ServicioCargoDAO.class);

        final IgBO igBO = new IgBO();

        generateSql(contextoVO.getAspc());

        final List<ValoracionAgregadaVO> vlraList = vlraDAO.selectList(contextoVO);
        final Set<Long> vlrcIds = new HashSet<Long>();

        for (final ValoracionAgregadaVO vlra : vlraList) {
            vlra.getVlrc().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            vlra.getVlrc().setAspc(contextoVO.getAspc());
            vlra.getVlrc().setFalta(Calendar.getInstance().getTime());

            LOG.info("vlrc: " + vlra.getVlrc());

            vlrcIds.add(vlra.getVlrc().getId());

            Long vlrlPadreId = null;

            for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
                vlrl.getVlrl().setVlrcId(vlra.getVlrc().getId());
                vlrl.getVlrl().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                if (vlrl.getVlrl().getRgla().getRglv().getTipo() == ReglaTipo.T) {
                    vlrlPadreId = vlrl.getVlrl().getId();
                }

                vlrl.getVlrl().setPadreId(vlrlPadreId);

                for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
                    vlrd.setVlrcId(vlra.getVlrc().getId());
                    vlrd.setVlrlId(vlrl.getVlrl().getId());
                    vlrd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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

        for (final ValoracionAgregadaVO vlra : vlraList) {
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(vlra.getVlrc().getId());

            final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectGenerateList(vlrcCriterioVO);

            for (final ValoracionImpuestoVO vlri : vlriList) {
                vlriDAO.insert(vlri);
            }

            vlrgDAO.insertGenerate(vlrcCriterioVO);
        }

        if (!vlrcIds.isEmpty()) {
            final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

            srcrCriterioVO.setVlrcIds(vlrcIds);
            srcrDAO.insertMarcarValorado(srcrCriterioVO);
            vlrtDAO.deleteList(contextoVO);
        }
    }

    /**
     * Valorar cargo servicio.
     *
     * @param session
     *            the session
     * @param contextoVO
     *            the contexto vo
     */
    private void valorarCargoServicio(final SqlSession session, final ValoradorContextoVO contextoVO) {
        contextoDAO = session.getMapper(ValoradorContextoDAO.class);
        rglaDAO = session.getMapper(ReglaDAO.class);
        vlrtDAO = session.getMapper(ValoracionTemporalDAO.class);

        LOG.info("Cargo: " + contextoVO.getCrgo().getCodigo());

        if (LOG.isDebugEnabled()) {
            LOG.debug("Contexto: " + contextoVO);
        }

        final Date fini = contextoDAO.selectFini(contextoVO);
        final Date ffin = contextoDAO.selectFfin(contextoVO);

        contextoVO.setFini(fini);
        contextoVO.setFfin(ffin);

        // Obtener Reglas de Tipo Precio

        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(contextoVO.getCrgo().getId());
        rglaCriterioVO.setFechaVigencia(contextoVO.getFref());

        final IgBO igBO = new IgBO();

        {
            // Aplicar procedimientos de tipo precio
            rglaCriterioVO.setTipo(ReglaTipo.T);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getRglv().getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getRglv().getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaServicio(contextoVO));

                    break;
                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaSubservicio(contextoVO));

                    break;
                }

                final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                    vlrt.setPadreId(vlrt.getId());

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(contextoVO.getFref());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());

                    if (contextoVO.getCrgo().getCrgv().getTemporal()) {
                        vlrt.setFinicio(contextoVO.getFini());
                        vlrt.setFfin(contextoVO.getFfin());
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
            rglaCriterioVO.setTipo(ReglaTipo.C);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getRglv().getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getRglv().getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(contextoVO));

                    break;
                }

                boolean incompatibilidadFound = false;

                final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(contextoVO.getFref());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());

                    if (contextoVO.getCrgo().getCrgv().getTemporal()) {
                        vlrt.setFinicio(contextoVO.getFini());
                        vlrt.setFfin(contextoVO.getFfin());
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

                    vlrtDAO.updateRecalcularCargo(contextoVO);
                }
            }
        }

        {
            // Aplicar procedimientos de tipo bonificacion
            rglaCriterioVO.setTipo(ReglaTipo.D);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getRglv().getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getRglv().getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(contextoVO));

                    break;
                }

                boolean incompatibilidadFound = false;

                final List<ValoracionTemporalVO> vlrtListGanadores = new ArrayList<ValoracionTemporalVO>();

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    vlrt.setRgla(rgla);
                    vlrt.setFreferencia(contextoVO.getFref());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());

                    if (contextoVO.getCrgo().getCrgv().getTemporal()) {
                        vlrt.setFinicio(contextoVO.getFini());
                        vlrt.setFfin(contextoVO.getFfin());
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

                    vlrtDAO.updateRecalcularCargo(contextoVO);
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
        rgla.getRglv().setPathImpuestoSql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathImpuesto(), false));
        rgla.getRglv().setPathPagadorSql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathPagador(), false));
        rgla.getRglv().setPathEsSujPasivoSql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathEsSujPasivo(), false));
        rgla.getRglv().setPathCodExenSql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCodExen(), false));

        rgla.getRglv().setPathInfo1Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo1(), true));
        rgla.getRglv().setPathInfo2Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo2(), true));
        rgla.getRglv().setPathInfo3Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo3(), true));
        rgla.getRglv().setPathInfo4Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo4(), true));
        rgla.getRglv().setPathInfo5Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo5(), true));
        rgla.getRglv().setPathInfo6Sql(generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathInfo6(), true));

        rgla.getRglv().setPathCuant1Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant1(), false));
        rgla.getRglv().setPathCuant2Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant2(), false));
        rgla.getRglv().setPathCuant3Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant3(), false));
        rgla.getRglv().setPathCuant4Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant4(), false));
        rgla.getRglv().setPathCuant5Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant5(), false));
        rgla.getRglv().setPathCuant6Sql(
                generateSqlPath(rgla.getRglv().getEnti(), rgla.getRglv().getPathCuant6(), false));

        rgla.getRglv().setCondicionSql(generateSqlCondition(rgla, rgla.getRglv().getCondicion()));
        rgla.getRglv().setFormulaSql(generateSqlFormula(rgla, rgla.getRglv().getFormula()));
    }

    /**
     * Generate sql.
     *
     * @param aspc
     *            the aspc
     */
    private void generateSql(final AspectoVO aspc) {
        aspc.getAspv().setCpathInfo1Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo1(), true));
        aspc.getAspv().setCpathInfo2Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo2(), true));
        aspc.getAspv().setCpathInfo3Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo3(), true));
        aspc.getAspv().setCpathInfo4Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo4(), true));
        aspc.getAspv().setCpathInfo5Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo5(), true));
        aspc.getAspv().setCpathInfo6Sql(generateSqlPath(aspc.getTpsr(), aspc.getAspv().getCpathInfo6(), true));
    }

    /**
     * Generate sql path.
     *
     * @param enti
     *            the enti
     * @param expression
     *            the expression
     * @param generateLabel
     *            the generate label
     * @return the string
     */
    private String generateSqlPath(final EntidadVO enti, final String expression, final boolean generateLabel) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final PathSqlGenerator pathSqlGenerator = new PathSqlGenerator(enti, generateLabel);

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
     * @param reglaVO
     *            the regla vo
     * @param expression
     *            the expression
     * @return the string
     */
    private String generateSqlCondition(final ReglaVO reglaVO, final String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final ConditionSqlGenerator conditionSqlGenerator = new ConditionSqlGenerator(reglaVO);

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
     * @param reglaVO
     *            the regla vo
     * @param expression
     *            the expression
     * @return the string
     */
    private String generateSqlFormula(final ReglaVO reglaVO, final String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final FormulaSqlGenerator formulaSqlGenerator = new FormulaSqlGenerator(reglaVO);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final FormulaLexer lexer = new FormulaLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final FormulaParser parser = new FormulaParser(tokens);
        final ParseTree tree = parser.formula();

        return formulaSqlGenerator.visit(tree).toString();
    }
}
