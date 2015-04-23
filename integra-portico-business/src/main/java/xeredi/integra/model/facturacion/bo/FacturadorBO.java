package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.dao.FacturaAgregadaDAO;
import xeredi.integra.model.facturacion.dao.FacturaDAO;
import xeredi.integra.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.integra.model.facturacion.dao.FacturaLineaDAO;
import xeredi.integra.model.facturacion.dao.FacturaSerieDAO;
import xeredi.integra.model.facturacion.dao.FacturaServicioDAO;
import xeredi.integra.model.facturacion.dao.ServicioCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.integra.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturaAgregadaVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.integra.model.facturacion.vo.FacturaEstado;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturadorContextoVO;
import xeredi.integra.model.facturacion.vo.ServicioCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.proceso.ProcesoTemplate;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorBO.
 */
public class FacturadorBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorBO.class);

    /** The proceso template. */
    private final ProcesoTemplate procesoTemplate;

    /**
     * Instantiates a new facturador bo.
     *
     * @param aprocesoTemplate
     *            the aproceso template
     */
    public FacturadorBO(final ProcesoTemplate aprocesoTemplate) {
        super();
        procesoTemplate = aprocesoTemplate;
    }

    /**
     * Facturar valoraciones.
     *
     * @param vlrcIds
     *            the vlrc ids
     * @param aspcId
     *            the aspc id
     * @param fcsrId
     *            the fcsr id
     * @param fechaFacturacion
     *            the fecha facturacion
     * @param prbtId
     *            the prbt id
     */
    public void facturarValoraciones(final Set<Long> vlrcIds, final Long aspcId, final Long fcsrId,
            final Date fechaFacturacion) {
        LOG.info("Facturacion de las valoraciones: " + vlrcIds);

        LOG.info("Validar parametros");
        Preconditions.checkNotNull(vlrcIds);
        Preconditions.checkArgument(!vlrcIds.isEmpty());
        Preconditions.checkNotNull(fcsrId);
        Preconditions.checkNotNull(fechaFacturacion);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final FacturaAgregadaDAO fctaDAO = session.getMapper(FacturaAgregadaDAO.class);
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);
            final FacturaDetalleDAO fctdDAO = session.getMapper(FacturaDetalleDAO.class);
            final FacturaServicioDAO fctsDAO = session.getMapper(FacturaServicioDAO.class);
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ServicioCargoDAO srcrDAO = session.getMapper(ServicioCargoDAO.class);

            final FacturadorContextoVO contextoVO = new FacturadorContextoVO();

            contextoVO.setVlrcIds(vlrcIds);
            contextoVO.setPrbt(procesoTemplate.getPrbt());

            final FacturaSerieVO fcsr = fcsrDAO.select(fcsrId);

            if (fcsr == null) {
                throw new Error("Serie de factura no encontrada: " + fcsrId);
            }

            contextoVO.setFcsr(fcsr);

            if (aspcId != null) {
                final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

                aspcCriterioVO.setId(aspcId);
                aspcCriterioVO.setFechaVigencia(fechaFacturacion);

                final AspectoVO aspc = aspcDAO.selectObject(aspcCriterioVO);

                if (aspc == null) {
                    throw new Error("Aspecto de agrupacion de facturas no encontrado: " + aspcId);
                }

                if (!aspc.getVersion().isAgrupaCabeceras()) {
                    throw new Error("No es un aspecto de agrupacion: " + aspc);
                }

                contextoVO.setAspc(aspc);

                // Validar que todas las valoraciones encajan con el aspecto seleccionado
                if (aspcDAO.isInaplicable(contextoVO)) {
                    throw new Error("Aspecto seleccionado no es aplicable para todas las valoraciones: " + aspc);
                }
            }

            LOG.info("Busqueda de Facturas");
            final List<FacturaAgregadaVO> fctrList = fctaDAO.selectList(contextoVO);

            final IgBO igBO = new IgBO();

            final List<FacturaServicioVO> fctsList = new ArrayList<>();
            final List<FacturaLineaVO> fctlList = new ArrayList<>();
            final List<FacturaDetalleVO> fctdList = new ArrayList<>();

            LOG.info("Busqueda de lineas y detalles de valoraciones a facturar");
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

            vlrcCriterioVO.setIds(vlrcIds);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterioVO);
            final List<ValoracionDetalleVO> vlrdList = vlrdDAO.selectList(vlrdCriterioVO);

            LOG.info("Preparacion de Facturas");
            final Map<Long, Long> generatedIds = new HashMap<>();
            final Map<Long, FacturaServicioVO> generatedFcts = new HashMap<>();

            for (final FacturaAgregadaVO fctr : fctrList) {
                fcsrDAO.updateIncrementar(fcsrId);

                fctr.getFctr().setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                fctr.getFctr().setFcsr(fcsr);
                fctr.getFctr().setNumero(fcsrDAO.select(fcsrId).getNumeroUltimo());
                fctr.getFctr().setFalta(Calendar.getInstance().getTime());
                fctr.getFctr().setFref(fechaFacturacion);
                fctr.getFctr().setEstado(FacturaEstado.NO);

                if (contextoVO.getAspc() == null) {
                    final FacturaServicioVO fcts = fctr.getFctsList().iterator().next();

                    fctr.getFctr().setAspc(fcts.getAspc());
                } else {
                    fctr.getFctr().setAspc(contextoVO.getAspc());
                }

                for (final FacturaServicioVO fcts : fctr.getFctsList()) {
                    final Long fctsOldId = fcts.getId();

                    generatedIds.put(fcts.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                    fcts.setId(generatedIds.get(fcts.getId()));
                    fcts.setFctrId(fctr.getFctr().getId());

                    generatedFcts.put(fctsOldId, fcts);

                    fctsList.add(fcts);
                }
            }

            for (final ValoracionLineaVO vlrl : vlrlList) {
                generatedIds.put(vlrl.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                final FacturaLineaVO fctl = new FacturaLineaVO();

                fctl.setId(generatedIds.get(vlrl.getId()));
                fctl.setPadreId(generatedIds.get(vlrl.getPadreId()));

                final FacturaServicioVO fcts = new FacturaServicioVO();

                fcts.setId(generatedIds.get(vlrl.getVlrcId()));

                fctl.setFcts(fcts);
                fctl.setFctrId(generatedFcts.get(vlrl.getVlrcId()).getFctrId());

                fctl.setFini(vlrl.getFini());
                fctl.setFfin(vlrl.getFfin());
                fctl.setImpuesto(vlrl.getImpuesto());
                fctl.setRgla(vlrl.getRgla());
                fctl.setSsrv(vlrl.getSsrv());

                fctl.setCuant1(vlrl.getCuant1());
                fctl.setCuant2(vlrl.getCuant2());
                fctl.setCuant3(vlrl.getCuant3());
                fctl.setCuant4(vlrl.getCuant4());
                fctl.setCuant5(vlrl.getCuant5());
                fctl.setCuant6(vlrl.getCuant6());
                fctl.setInfo1(vlrl.getInfo1());
                fctl.setInfo2(vlrl.getInfo2());
                fctl.setInfo3(vlrl.getInfo3());
                fctl.setInfo4(vlrl.getInfo4());
                fctl.setInfo5(vlrl.getInfo5());
                fctl.setInfo6(vlrl.getInfo6());

                fctlList.add(fctl);
            }

            for (final ValoracionDetalleVO vlrd : vlrdList) {
                final FacturaDetalleVO fctd = new FacturaDetalleVO();

                fctd.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                fctd.setFctlId(generatedIds.get(vlrd.getVlrlId()));
                fctd.setFctrId(generatedFcts.get(vlrd.getVlrcId()).getFctrId());

                fctd.setFini(vlrd.getFini());
                fctd.setFfin(vlrd.getFfin());
                fctd.setSsrv(vlrd.getSsrv());
                fctd.setImporteBase(vlrd.getImporteBase());
                fctd.setImporte(vlrd.getImporte());

                fctd.setCuant1(vlrd.getCuant1());
                fctd.setCuant2(vlrd.getCuant2());
                fctd.setCuant3(vlrd.getCuant3());
                fctd.setCuant4(vlrd.getCuant4());
                fctd.setCuant5(vlrd.getCuant5());
                fctd.setCuant6(vlrd.getCuant6());
                fctd.setInfo1(vlrd.getInfo1());
                fctd.setInfo2(vlrd.getInfo2());
                fctd.setInfo3(vlrd.getInfo3());
                fctd.setInfo4(vlrd.getInfo4());
                fctd.setInfo5(vlrd.getInfo5());
                fctd.setInfo6(vlrd.getInfo6());

                fctdList.add(fctd);
            }

            LOG.info("Insercion de Facturas");
            for (final FacturaAgregadaVO fctr : fctrList) {
                fctrDAO.insert(fctr.getFctr());
            }

            for (final FacturaServicioVO fcts : fctsList) {
                fctsDAO.insert(fcts);
            }

            for (final FacturaLineaVO fctl : fctlList) {
                fctlDAO.insert(fctl);
            }

            for (final FacturaDetalleVO fctd : fctdList) {
                fctdDAO.insert(fctd);
            }

            for (final FacturaAgregadaVO fctr : fctrList) {
                final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

                fctrCriterioVO.setId(fctr.getFctr().getId());
                Preconditions.checkNotNull(fctrCriterioVO.getId());
            }

            LOG.info("Marcar como facturado en servicio_cargo");
            // FIXME Marcar como facturado en servicio_cargo

            final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

            srcrCriterioVO.setVlrcIds(vlrcIds);

            srcrDAO.deleteValoracion(srcrCriterioVO);

            LOG.info("Borrado de Valoraciones");
            vlrdDAO.deleteList(vlrdCriterioVO);
            vlrlDAO.delete(vlrlCriterioVO);
            vlrcDAO.delete(vlrcCriterioVO);

            session.commit();
        }
    }
}
