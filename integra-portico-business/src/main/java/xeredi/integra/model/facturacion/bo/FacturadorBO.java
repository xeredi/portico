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
import xeredi.integra.model.facturacion.vo.FacturaLineaAgregadaVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioAgregadaVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturadorContextoVO;
import xeredi.integra.model.facturacion.vo.ServicioCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
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

        LOG.info("Preparacion de Facturas");
        for (final FacturaAgregadaVO fctr : fctrList) {
            final Map<Long, Long> generatedIds = new HashMap<>();

            fcsrDAO.updateIncrementar(fcsrId);

            fctr.getFctr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            fctr.getFctr().setFcsr(fcsr);
            fctr.getFctr().setNumero(fcsrDAO.select(fcsrId).getNumeroUltimo());
            fctr.getFctr().setFalta(Calendar.getInstance().getTime());
            fctr.getFctr().setFref(fechaFacturacion);
            fctr.getFctr().setEstado(FacturaEstado.NO);

            if (contextoVO.getAspc() == null) {
                final FacturaServicioVO fcts = fctr.getFctsList().iterator().next().getFcts();

                fctr.getFctr().setAspc(fcts.getAspc());
            } else {
                fctr.getFctr().setAspc(contextoVO.getAspc());
            }

            for (final FacturaServicioAgregadaVO fcts : fctr.getFctsList()) {
                fcts.getFcts().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                fcts.getFcts().setFctrId(fctr.getFctr().getId());

                fctsList.add(fcts.getFcts());

                for (final FacturaLineaAgregadaVO fctl : fcts.getFctlList()) {
                    generatedIds.put(fctl.getFctl().getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

                    fctl.getFctl().setId(generatedIds.get(fctl.getFctl().getId()));
                    fctl.getFctl().setPadreId(generatedIds.get(fctl.getFctl().getPadreId()));
                    fctl.getFctl().setFctrId(fcts.getFcts().getFctrId());
                    fctl.getFctl().setFctsId(fcts.getFcts().getId());

                    fctlList.add(fctl.getFctl());

                    for (final FacturaDetalleVO fctd : fctl.getFctdList()) {
                        fctd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                        fctd.setFctrId(fctl.getFctl().getFctrId());
                        fctd.setFctlId(fctl.getFctl().getId());

                        fctdList.add(fctd);
                    }
                }
            }
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
        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
        final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
        final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

        vlrcCriterioVO.setIds(vlrcIds);
        vlrlCriterioVO.setVlrc(vlrcCriterioVO);
        vlrdCriterioVO.setVlrl(vlrlCriterioVO);

        vlrdDAO.delete(vlrdCriterioVO);
        vlrlDAO.delete(vlrlCriterioVO);
        vlriDAO.delete(vlrcCriterioVO);
        vlrgDAO.delete(vlrcCriterioVO);
        vlrcDAO.delete(vlrcCriterioVO);
    }
}
