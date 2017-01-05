package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.argo.model.facturacion.vo.FacturaCargoVO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleVO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.facturacion.vo.FacturaImpresionVO;
import xeredi.argo.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.argo.model.facturacion.vo.FacturaLineaVO;
import xeredi.argo.model.facturacion.vo.FacturaServicioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaTest.
 */
public final class FacturaTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturaTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final FacturaBO fctrBO = new FacturaBO();
            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

            LOG.info("Busqueda de facturas");
            final PaginatedList<FacturaVO> fctrList = fctrBO.selectList(fctrCriterioVO, 0, 20);

            if (!fctrList.getList().isEmpty()) {
                {
                    for (final FacturaVO fctr : fctrList.getList()) {
                        LOG.info("Busqueda de factura");
                        Assert.assertNotNull(fctrBO.select(fctr.getId(), "es"));

                        if (fctr.getEstado() == FacturaEstado.NO) {
                            LOG.info("Anulacion de factura");
                            fctrBO.anular(fctr.getId(), Calendar.getInstance().getTime(), fctr.getFcsr().getId(),
                                    "Observaciones de prueba de anulacion");
                        }

                        LOG.info("Busqueda de cargos de factura");
                        final List<FacturaCargoVO> fctgList = fctrBO.selectFctgList(fctr.getId(), "es");

                        Assert.assertTrue(!fctgList.isEmpty());

                        LOG.info("Busqueda de servicios de factura");
                        final List<FacturaServicioVO> fctsList = fctrBO.selectFctsList(fctr.getId(), "es");

                        Assert.assertTrue(!fctsList.isEmpty());

                        LOG.info("Busqueda de impuestos de factura");
                        final List<FacturaImpuestoVO> fctiList = fctrBO.selectFctiList(fctr.getId(), "es");

                        Assert.assertTrue(!fctiList.isEmpty());

                        LOG.info("Busqueda de lineas de factura");
                        final PaginatedList<FacturaLineaVO> fctlList = fctrBO.selectFctlList(fctr.getId(), "es", 0, 20);

                        Assert.assertTrue(!fctlList.getList().isEmpty());

                        for (final FacturaLineaVO fctl : fctlList.getList()) {
                            LOG.info("Busqueda de linea de factura");
                            Assert.assertNotNull(fctrBO.selectFctl(fctl.getId(), "es"));

                            LOG.info("Busqueda de detalles de factura de una linea, y detalles individuales");
                            final PaginatedList<FacturaDetalleVO> fctdList = fctrBO.selectFctdList(fctl.getId(), "es",
                                    0, 20);

                            Assert.assertTrue(!fctdList.getList().isEmpty());

                            for (final FacturaDetalleVO fctd : fctdList.getList()) {
                                Assert.assertNotNull(fctrBO.selectFctd(fctd.getId(), "es"));
                            }
                        }
                    }
                }

                {
                    LOG.info("Impresion de facturas");
                    final Set<Long> fctrIds = new HashSet<>();

                    for (final FacturaVO fctr : fctrList.getList()) {
                        fctrIds.add(fctr.getId());
                    }

                    final List<FacturaImpresionVO> fctrImprimirList = fctrBO.selectImprimir(fctrIds);
                }
            }
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
