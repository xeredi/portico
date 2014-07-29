package xeredi.integra.model.bo.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.facturacion.CargoDAO;
import xeredi.integra.model.dao.facturacion.ReglaDAO;
import xeredi.integra.model.dao.facturacion.ValoracionTemporalDAO;
import xeredi.integra.model.dao.proceso.ProcesoDAO;
import xeredi.integra.model.dao.servicio.ServicioDAO;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.util.grammar.PathLexer;
import xeredi.integra.model.util.grammar.PathParser;
import xeredi.integra.model.util.grammar.PathSqlGenerator;
import xeredi.integra.model.vo.facturacion.CargoCriterioVO;
import xeredi.integra.model.vo.facturacion.CargoVO;
import xeredi.integra.model.vo.facturacion.ReglaCriterioVO;
import xeredi.integra.model.vo.facturacion.ReglaTipo;
import xeredi.integra.model.vo.facturacion.ReglaVO;
import xeredi.integra.model.vo.facturacion.ValoracionTemporalVO;
import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;

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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void valorarServicio(Long srvcId, Set<Long> crgoIds, Date fechaLiquidacion, final Long prbtId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Valoracion - srvcId: " + srvcId + ", crgoIds: " + crgoIds + ", fechaLiquidacion: "
                    + fechaLiquidacion + ", prbtId: " + prbtId);
        }

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

        if (LOG.isDebugEnabled()) {
            LOG.debug("crgoList: " + crgoList);
        }

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

        if (LOG.isDebugEnabled()) {
            LOG.debug("Fin Valoracion");
        }
    }

    /**
     * Valorar cargo servicio.
     *
     * @param contextoVO
     *            the contexto vo
     */
    private void valorarCargoServicio(final ValoradorContextoVO contextoVO) {
        LOG.info(contextoVO);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Contexto: " + contextoVO);
        }

        // Obtener Reglas de Tipo Precio

        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(contextoVO.getCrgo().getId());
        rglaCriterioVO.setFechaVigencia(contextoVO.getFinicio());

        {
            // Aplicaro procedimientos de tipo precio
            rglaCriterioVO.setTipo(ReglaTipo.T);

            final List<ReglaVO> rglaList = rglaDAO.selectList(rglaCriterioVO);

            for (final ReglaVO rgla : rglaList) {
                generateSql(rgla);
                contextoVO.setRgla(rgla);

                final List<ValoracionTemporalVO> vlrtList = new ArrayList<>();

                LOG.info(contextoVO);

                switch (rgla.getEnti().getTipo()) {
                case T:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaServicio(contextoVO));

                    break;

                default:
                    vlrtList.addAll(vlrtDAO.selectAplicarReglaSubservicio(contextoVO));

                    break;
                }

                for (final ValoracionTemporalVO vlrt : vlrtList) {
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
        rgla.getRglv().setPathImpuestoSql(generateSqlPath(rgla, rgla.getRglv().getPathImpuesto(), false));
        rgla.getRglv().setPathPagadorSql(generateSqlPath(rgla, rgla.getRglv().getPathPagador(), false));
        rgla.getRglv().setPathEsSujPasivoSql(generateSqlPath(rgla, rgla.getRglv().getPathEsSujPasivo(), false));
        rgla.getRglv().setPathCodExenSql(generateSqlPath(rgla, rgla.getRglv().getPathCodExen(), false));

        rgla.getRglv().setPathInfo1Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo1(), true));
        rgla.getRglv().setPathInfo2Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo2(), true));
        rgla.getRglv().setPathInfo3Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo3(), true));
        rgla.getRglv().setPathInfo4Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo4(), true));
        rgla.getRglv().setPathInfo5Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo5(), true));
        rgla.getRglv().setPathInfo6Sql(generateSqlPath(rgla, rgla.getRglv().getPathInfo6(), true));

        rgla.getRglv().setPathCuant1Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant1(), false));
        rgla.getRglv().setPathCuant2Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant2(), false));
        rgla.getRglv().setPathCuant3Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant3(), false));
        rgla.getRglv().setPathCuant4Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant4(), false));
        rgla.getRglv().setPathCuant5Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant5(), false));
        rgla.getRglv().setPathCuant6Sql(generateSqlPath(rgla, rgla.getRglv().getPathCuant6(), false));
    }

    /**
     * Generate sql path.
     *
     * @param rgla
     *            the rgla
     * @param expression
     *            the expression
     * @return the string
     */
    private String generateSqlPath(final ReglaVO rgla, final String expression, final boolean generateLabel) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }

        final PathSqlGenerator pathSqlGenerator = new PathSqlGenerator(rgla, generateLabel);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final PathLexer lexer = new PathLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokens);
        final ParseTree tree = parser.value();

        return pathSqlGenerator.visit(tree).toString();
    }
}
