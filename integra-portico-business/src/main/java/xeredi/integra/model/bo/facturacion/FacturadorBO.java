package xeredi.integra.model.bo.facturacion;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.dao.facturacion.AspectoDAO;
import xeredi.integra.model.dao.facturacion.FacturaAgregadaDAO;
import xeredi.integra.model.dao.facturacion.FacturaCargoDAO;
import xeredi.integra.model.dao.facturacion.FacturaDAO;
import xeredi.integra.model.dao.facturacion.FacturaDetalleDAO;
import xeredi.integra.model.dao.facturacion.FacturaImpuestoDAO;
import xeredi.integra.model.dao.facturacion.FacturaLineaDAO;
import xeredi.integra.model.dao.facturacion.FacturaSerieDAO;
import xeredi.integra.model.dao.facturacion.FacturaServicioDAO;
import xeredi.integra.model.dao.proceso.ProcesoDAO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.facturacion.AspectoCriterioVO;
import xeredi.integra.model.vo.facturacion.AspectoVO;
import xeredi.integra.model.vo.facturacion.FacturaAgregadaVO;
import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaDetalleVO;
import xeredi.integra.model.vo.facturacion.FacturaImpuestoVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaAgregadaVO;
import xeredi.integra.model.vo.facturacion.FacturaSerieVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioAgregadaVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioVO;
import xeredi.integra.model.vo.facturacion.FacturadorContextoVO;
import xeredi.integra.model.vo.proceso.ProcesoVO;

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

    /** The fctc dao. */
    @Inject
    FacturaCargoDAO fctcDAO;

    /** The fcti dao. */
    @Inject
    FacturaImpuestoDAO fctiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void facturarValoraciones(final Set<Long> vlrcIds, final Long aspcId, final Long fcsrId,
            final Date fechaFacturacion, final Long prbtId) {
        Preconditions.checkNotNull(vlrcIds);
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

        final List<FacturaAgregadaVO> fctrList = fctaDAO.selectList(contextoVO);

        final IgBO igBO = new IgBO();

        // Preparar Facturas
        for (final FacturaAgregadaVO fctr : fctrList) {
            fcsrDAO.updateIncrementar(fcsrId);

            fctr.getFctr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            fctr.getFctr().setFcsr(fcsr);
            fctr.getFctr().setNumero(fcsrDAO.select(fcsrId).getNumeroUltimo());

            if (contextoVO.getAspc() == null) {
                final FacturaServicioVO fcts = fctr.getFctsList().iterator().next().getFcts();

                fctr.getFctr().setAspc(fcts.getAspc());
            } else {
                fctr.getFctr().setAspc(contextoVO.getAspc());
            }

            for (final FacturaServicioAgregadaVO fcts : fctr.getFctsList()) {
                fcts.getFcts().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                fcts.getFcts().setFctrId(fctr.getFctr().getId());

                for (final FacturaLineaAgregadaVO fctl : fcts.getFctlList()) {
                    fctl.getFctl().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                    fctl.getFctl().setFctrId(fcts.getFcts().getFctrId());
                    fctl.getFctl().setFctsId(fcts.getFcts().getId());

                    for (final FacturaDetalleVO fctd : fctl.getFctdList()) {
                        fctd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                        fctd.setFctrId(fctl.getFctl().getFctrId());
                        fctd.setFctlId(fctl.getFctl().getId());
                    }
                }
            }
        }

        // Guardar Facturas
        for (final FacturaAgregadaVO fctr : fctrList) {
            fctrDAO.insert(fctr.getFctr());
        }

        for (final FacturaAgregadaVO fctr : fctrList) {
            for (final FacturaServicioAgregadaVO fcts : fctr.getFctsList()) {
                fctsDAO.insert(fcts.getFcts());
            }
        }

        for (final FacturaAgregadaVO fctr : fctrList) {
            for (final FacturaServicioAgregadaVO fcts : fctr.getFctsList()) {
                for (final FacturaLineaAgregadaVO fctl : fcts.getFctlList()) {
                    fctlDAO.insert(fctl.getFctl());
                }
            }
        }

        for (final FacturaAgregadaVO fctr : fctrList) {
            for (final FacturaServicioAgregadaVO fcts : fctr.getFctsList()) {
                for (final FacturaLineaAgregadaVO fctl : fcts.getFctlList()) {
                    for (final FacturaDetalleVO fctd : fctl.getFctdList()) {
                        fctdDAO.insert(fctd);
                    }
                }
            }
        }

        for (final FacturaAgregadaVO fctr : fctrList) {
            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

            fctrCriterioVO.setId(fctr.getFctr().getId());

            final List<FacturaImpuestoVO> fctiList = fctiDAO.selectGenerateList(fctrCriterioVO);

            for (final FacturaImpuestoVO fcti : fctiList) {
                fctiDAO.insert(fcti);
            }
        }

        // TODO Calcular los cargos de cada facturacion

        // Borrado de las valoraciones enviadas a facturar
        final Valoracion vlrcBO = BOFactory.getInjector().getInstance(Valoracion.class);

        vlrcBO.delete(vlrcIds);
    }

}
