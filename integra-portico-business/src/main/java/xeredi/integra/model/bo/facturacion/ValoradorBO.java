package xeredi.integra.model.bo.facturacion;

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
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.facturacion.AspectoDAO;
import xeredi.integra.model.dao.facturacion.CargoDAO;
import xeredi.integra.model.dao.facturacion.ReglaDAO;
import xeredi.integra.model.dao.facturacion.ValoracionAgregadaDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDetalleDAO;
import xeredi.integra.model.dao.facturacion.ValoracionImpuestoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionLineaDAO;
import xeredi.integra.model.dao.facturacion.ValoracionTemporalDAO;
import xeredi.integra.model.dao.proceso.ProcesoDAO;
import xeredi.integra.model.dao.servicio.ServicioDAO;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.grammar.ConditionLexer;
import xeredi.integra.model.util.grammar.ConditionParser;
import xeredi.integra.model.util.grammar.ConditionSqlGenerator;
import xeredi.integra.model.util.grammar.FormulaLexer;
import xeredi.integra.model.util.grammar.FormulaParser;
import xeredi.integra.model.util.grammar.FormulaSqlGenerator;
import xeredi.integra.model.util.grammar.PathLexer;
import xeredi.integra.model.util.grammar.PathParser;
import xeredi.integra.model.util.grammar.PathSqlGenerator;
import xeredi.integra.model.vo.facturacion.AspectoCriterioVO;
import xeredi.integra.model.vo.facturacion.AspectoVO;
import xeredi.integra.model.vo.facturacion.CargoCriterioVO;
import xeredi.integra.model.vo.facturacion.CargoVO;
import xeredi.integra.model.vo.facturacion.ReglaCriterioVO;
import xeredi.integra.model.vo.facturacion.ReglaTipo;
import xeredi.integra.model.vo.facturacion.ReglaVO;
import xeredi.integra.model.vo.facturacion.ValoracionAgregadaVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaAgregadaVO;
import xeredi.integra.model.vo.facturacion.ValoracionTemporalVO;
import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;

import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
@Singleton
public class ValoradorBO implements Valorador {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorBO.class);

    /** The srvc dao. */
    @Inject
    ServicioDAO srvcDAO;

    /** The crgo dao. */
    @Inject
    CargoDAO crgoDAO;

    /** The prbt dao. */
    @Inject
    ProcesoDAO prbtDAO;

    /** The rgla dao. */
    @Inject
    ReglaDAO rglaDAO;

    /** The vlrt dao. */
    @Inject
    ValoracionTemporalDAO vlrtDAO;

    /** The aspc dao. */
    @Inject
    AspectoDAO aspcDAO;

    /** The vlra dao. */
    @Inject
    ValoracionAgregadaDAO vlraDAO;

    /** The vlrc dao. */
    @Inject
    ValoracionDAO vlrcDAO;

    /** The vlrl dao. */
    @Inject
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    @Inject
    ValoracionDetalleDAO vlrdDAO;

    /** The vlri dao. */
    @Inject
    ValoracionImpuestoDAO vlriDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void valorarServicio(Long srvcId, Set<Long> crgoIds, Date fechaLiquidacion, final Long prbtId) {
        LOG.info("Valoracion - srvcId: " + srvcId + ", crgoIds: " + crgoIds + ", fechaLiquidacion: " + fechaLiquidacion
                + ", prbtId: " + prbtId);

        final ValoradorContextoVO contextoVO = new ValoradorContextoVO();

        contextoVO.setFliquidacion(fechaLiquidacion);
        contextoVO.setPrbt(prbtDAO.select(prbtId));
        contextoVO.setSrvc(srvcDAO.select(srvcId));
        contextoVO.setTpsr(TipoServicioProxy.select(contextoVO.getSrvc().getEntiId()));

        // Obtencion de los cargos, y los cargos dependientes
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setIds(crgoIds);
        crgoCriterioVO.setFechaVigencia(fechaLiquidacion);
        crgoCriterioVO.setSoloPrincipales(true);

        final List<CargoVO> crgoList = crgoDAO.selectList(crgoCriterioVO);

        final CargoCriterioVO crgoDepCriterioVO = new CargoCriterioVO();

        crgoDepCriterioVO.setPadreIds(crgoIds);
        crgoDepCriterioVO.setFechaVigencia(fechaLiquidacion);
        crgoDepCriterioVO.setSoloDependientes(true);

        crgoList.addAll(crgoDAO.selectList(crgoDepCriterioVO));

        // Aplicacion de cargos del servicio

        for (final CargoVO crgo : crgoList) {
            contextoVO.setCrgo(crgo);

            // FIXME Obtener fechas de inicio / fin de valoracion

            Calendar calendar = Calendar.getInstance();

            contextoVO.setFfin(calendar.getTime());

            calendar.add(Calendar.DAY_OF_MONTH, -1);

            contextoVO.setFinicio(calendar.getTime());
            contextoVO.setFreferencia(contextoVO.getFinicio());

            valorarCargoServicio(contextoVO);
        }

        // Generacion de valoraciones a partir de los aspectos

        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setFechaVigencia(fechaLiquidacion);
        aspcCriterioVO.setSrvcId(srvcId);

        final List<AspectoVO> aspcList = aspcDAO.selectList(aspcCriterioVO);

        for (final AspectoVO aspc : aspcList) {
            contextoVO.setAspc(aspc);

            aplicarAspecto(contextoVO);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Fin Valoracion");
        }
    }

    /**
     * Aplicar aspecto.
     *
     * @param contextoVO
     *            the contexto vo
     */
    private void aplicarAspecto(final ValoradorContextoVO contextoVO) {
        final IgBO igBO = new IgBO();

        generateSql(contextoVO.getAspc());

        final List<ValoracionAgregadaVO> vlraList = vlraDAO.selectList(contextoVO);

        for (final ValoracionAgregadaVO vlra : vlraList) {
            final Set<Long> vlrgCrgoIds = new HashSet<Long>();

            vlra.getVlrc().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            vlra.getVlrc().setAspc(contextoVO.getAspc());
            vlra.getVlrc().setFalta(Calendar.getInstance().getTime());
            vlra.getVlrc().setImporte(0.0);
            vlra.getVlrc().setImpuesto(0.0);

            LOG.info("vlrc: " + vlra.getVlrc());

            for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
                vlrgCrgoIds.add(vlrl.getVlrl().getRgla().getCrgo().getId());

                vlrl.getVlrl().setVlrcId(vlra.getVlrc().getId());
                vlrl.getVlrl().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                vlrl.getVlrl().setImporteBase(0.0);
                vlrl.getVlrl().setImporte(0.0);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("vlrl: " + vlrl.getVlrl());
                }

                for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
                    vlrd.setVlrcId(vlra.getVlrc().getId());
                    vlrd.setVlrlId(vlrl.getVlrl().getId());
                    vlrd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("vlrd: " + vlrd);
                    }
                }
            }

            vlrcDAO.insert(vlra.getVlrc());

            for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
                vlrlDAO.insert(vlrl.getVlrl());
            }

            for (final ValoracionLineaAgregadaVO vlrl : vlra.getVlrlList()) {
                for (final ValoracionDetalleVO vlrd : vlrl.getVlrdList()) {
                    vlrdDAO.insert(vlrd);
                }
            }

            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(vlra.getVlrc().getId());

            final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectGenerateList(vlrcCriterioVO);

            for (final ValoracionImpuestoVO vlri : vlriList) {
                vlriDAO.insert(vlri);
            }

            vlrcDAO.insertGenerateCargos(vlrcCriterioVO);
            vlrcDAO.updateRecalcular(vlrcCriterioVO);
        }

        // vlraDAO.deleteTemporalList(vlraCriterioVO);
    }

    /**
     * Valorar cargo servicio.
     *
     * @param contextoVO
     *            the contexto vo
     */
    private void valorarCargoServicio(final ValoradorContextoVO contextoVO) {
        LOG.info("Cargo: " + contextoVO.getCrgo().getCodigo());

        if (LOG.isDebugEnabled()) {
            LOG.debug("Contexto: " + contextoVO);
        }

        // Obtener Reglas de Tipo Precio

        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(contextoVO.getCrgo().getId());
        rglaCriterioVO.setFechaVigencia(contextoVO.getFinicio());

        final IgBO igBO = new IgBO();

        {
            // Aplicaro procedimientos de tipo precio
            rglaCriterioVO.setTipo(ReglaTipo.T);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaSubservicio(contextoVO));

                    break;
                }

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    vlrt.setFreferencia(contextoVO.getFreferencia());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());
                    vlrt.setFinicio(contextoVO.getFinicio());
                    vlrt.setFfin(contextoVO.getFfin());

                    vlrtDAO.insert(vlrt);
                }
            }
        }

        {
            // Aplicaro procedimientos de tipo coeficiente
            rglaCriterioVO.setTipo(ReglaTipo.C);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(contextoVO));

                    break;
                }

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    vlrt.setFreferencia(contextoVO.getFreferencia());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());
                    vlrt.setFinicio(contextoVO.getFinicio());
                    vlrt.setFfin(contextoVO.getFfin());

                    vlrtDAO.insert(vlrt);
                }
            }
        }

        {
            // Aplicaro procedimientos de tipo bonificacion
            rglaCriterioVO.setTipo(ReglaTipo.D);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                LOG.info("Regla: " + rgla.getCodigo() + " - " + rgla.getTipo());

                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                switch (rgla.getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaDecoradorSubservicio(contextoVO));

                    break;
                }

                for (final ValoracionTemporalVO vlrt : vlrtList) {
                    vlrt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    vlrt.setFreferencia(contextoVO.getFreferencia());
                    vlrt.setFliquidacion(contextoVO.getFliquidacion());
                    vlrt.setFinicio(contextoVO.getFinicio());
                    vlrt.setFfin(contextoVO.getFfin());

                    vlrtDAO.insert(vlrt);
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
        rgla.getRglv().setPathImpuestoSql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathImpuesto(), false));
        rgla.getRglv().setPathPagadorSql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathPagador(), false));
        rgla.getRglv().setPathEsSujPasivoSql(
                generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathEsSujPasivo(), false));
        rgla.getRglv().setPathCodExenSql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCodExen(), false));

        rgla.getRglv().setPathInfo1Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo1(), true));
        rgla.getRglv().setPathInfo2Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo2(), true));
        rgla.getRglv().setPathInfo3Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo3(), true));
        rgla.getRglv().setPathInfo4Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo4(), true));
        rgla.getRglv().setPathInfo5Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo5(), true));
        rgla.getRglv().setPathInfo6Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathInfo6(), true));

        rgla.getRglv().setPathCuant1Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant1(), false));
        rgla.getRglv().setPathCuant2Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant2(), false));
        rgla.getRglv().setPathCuant3Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant3(), false));
        rgla.getRglv().setPathCuant4Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant4(), false));
        rgla.getRglv().setPathCuant5Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant5(), false));
        rgla.getRglv().setPathCuant6Sql(generateSqlPath(rgla.getEnti(), rgla.getRglv().getPathCuant6(), false));

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
