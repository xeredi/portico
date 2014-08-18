package xeredi.integra.model.bo.facturacion;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.dao.facturacion.AspectoDAO;
import xeredi.integra.model.dao.facturacion.FacturaAgregadaDAO;
import xeredi.integra.model.dao.facturacion.FacturaDAO;
import xeredi.integra.model.dao.facturacion.FacturaDetalleDAO;
import xeredi.integra.model.dao.facturacion.FacturaLineaDAO;
import xeredi.integra.model.dao.facturacion.FacturaSerieDAO;
import xeredi.integra.model.dao.facturacion.FacturaServicioDAO;
import xeredi.integra.model.dao.proceso.ProcesoDAO;
import xeredi.integra.model.vo.facturacion.AspectoCriterioVO;
import xeredi.integra.model.vo.facturacion.AspectoVO;
import xeredi.integra.model.vo.facturacion.FacturaAgregadaVO;
import xeredi.integra.model.vo.facturacion.FacturaSerieVO;
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

    @Inject
    FacturaDAO fctrDAO;

    @Inject
    FacturaLineaDAO fctlDAO;

    @Inject
    FacturaDetalleDAO fctdDAO;

    @Inject
    FacturaServicioDAO fctsDAO;

    /**
     * {@inheritDoc}
     */
    @Override
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

        final List<FacturaAgregadaVO> fctaList = fctaDAO.selectList(contextoVO);

        for (final FacturaAgregadaVO fcta : fctaList) {

        }

        // TODO Auto-generated method stub

    }

}
