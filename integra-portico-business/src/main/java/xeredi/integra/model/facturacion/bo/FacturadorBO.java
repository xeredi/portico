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
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.dao.FacturaAgregadaDAO;
import xeredi.integra.model.facturacion.dao.FacturaCargoDAO;
import xeredi.integra.model.facturacion.dao.FacturaDAO;
import xeredi.integra.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.integra.model.facturacion.dao.FacturaImpuestoDAO;
import xeredi.integra.model.facturacion.dao.FacturaLineaDAO;
import xeredi.integra.model.facturacion.dao.FacturaSerieDAO;
import xeredi.integra.model.facturacion.dao.FacturaServicioDAO;
import xeredi.integra.model.facturacion.dao.ServicioCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.integra.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturaAgregadaVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.integra.model.facturacion.vo.FacturaEstado;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
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
import xeredi.integra.model.proceso.dao.ProcesoDAO;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorBO.
 */
@Singleton
public class FacturadorBO implements Facturador {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorBO.class);

    /** The fcsr dao. */
    @Inject
    FacturaSerieDAO fcsrDAO;

    /** The prbt dao. */
    @Inject
    ProcesoDAO prbtDAO;

    /** The aspc dao. */
    @Inject
    AspectoDAO aspcDAO;

    /** The fcta dao. */
    @Inject
    FacturaAgregadaDAO fctaDAO;

    /** The fctr dao. */
    @Inject
    FacturaDAO fctrDAO;

    /** The fctl dao. */
    @Inject
    FacturaLineaDAO fctlDAO;

    /** The fctd dao. */
    @Inject
    FacturaDetalleDAO fctdDAO;

    /** The fcts dao. */
    @Inject
    FacturaServicioDAO fctsDAO;

    /** The fcti dao. */
    @Inject
    FacturaImpuestoDAO fctiDAO;

    /** The fctg dao. */
    @Inject
    FacturaCargoDAO fctgDAO;

    /** The vlrc dao. */
    @Inject
    ValoracionDAO vlrcDAO;

    /** The vlri dao. */
    @Inject
    ValoracionImpuestoDAO vlriDAO;

    /** The vlrg dao. */
    @Inject
    ValoracionCargoDAO vlrgDAO;

    /** The vlrl dao. */
    @Inject
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    @Inject
    ValoracionDetalleDAO vlrdDAO;

    /** The srcr dao. */
    @Inject
    ServicioCargoDAO srcrDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void facturarValoraciones(final Set<Long> vlrcIds, final Long aspcId, final Long fcsrId,
            final Date fechaFacturacion, final Long prbtId) {
        LOG.info("Facturacion de las valoraciones: " + vlrcIds);

        LOG.info("Validar parametros");
        Preconditions.checkNotNull(vlrcIds);
        Preconditions.checkArgument(!vlrcIds.isEmpty());
        Preconditions.checkNotNull(fcsrId);
        Preconditions.checkNotNull(fechaFacturacion);
        Preconditions.checkNotNull(prbtId);

        final FacturadorContextoVO contextoVO = new FacturadorContextoVO();

        contextoVO.setVlrcIds(vlrcIds);

        final ProcesoVO prbt = prbtDAO.select(prbtId);

        if (prbt == null) {
            throw new Error("Proceso batch no encontrado: " + prbtId);
        }

        contextoVO.setPrbt(prbt);

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

            if (!aspc.getAspv().isAgrupaCabeceras()) {
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

            fctr.getFctr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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

                generatedIds.put(fcts.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

                fcts.setId(generatedIds.get(fcts.getId()));
                fcts.setFctrId(fctr.getFctr().getId());

                generatedFcts.put(fctsOldId, fcts);

                fctsList.add(fcts);
            }
        }

        for (final ValoracionLineaVO vlrl : vlrlList) {
            generatedIds.put(vlrl.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

            final FacturaLineaVO fctl = new FacturaLineaVO();

            fctl.setId(generatedIds.get(vlrl.getId()));
            fctl.setPadreId(generatedIds.get(vlrl.getPadreId()));
            fctl.setFctsId(generatedIds.get(vlrl.getVlrcId()));
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

            fctd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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

            final List<FacturaImpuestoVO> fctiList = fctiDAO.selectGenerateList(fctrCriterioVO);

            for (final FacturaImpuestoVO fcti : fctiList) {
                fctiDAO.insert(fcti);
            }

            fctgDAO.insertGenerate(fctrCriterioVO);
        }

        LOG.info("Marcar como facturado en servicio_cargo");
        // FIXME Marcar como facturado en servicio_cargo

        final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

        srcrCriterioVO.setVlrcIds(vlrcIds);

        srcrDAO.deleteValoracion(srcrCriterioVO);

        LOG.info("Borrado de Valoraciones");
        vlrdDAO.delete(vlrdCriterioVO);
        vlrlDAO.delete(vlrlCriterioVO);
        vlriDAO.delete(vlrcCriterioVO);
        vlrgDAO.delete(vlrcCriterioVO);
        vlrcDAO.delete(vlrcCriterioVO);
    }
}