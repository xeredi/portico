package xeredi.integra.model.bo.facturacion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;
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
            final Factura factura = BOFactory.getInjector().getInstance(FacturaBO.class);
            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
            final PaginatedList<FacturaVO> fctrList = factura.selectList(fctrCriterioVO, 0, 20);

            if (!fctrList.getList().isEmpty()) {
                {
                    LOG.info("Busqueda de facturas una a una");
                    for (final FacturaVO fctr : fctrList.getList()) {
                        LOG.info("Busqueda de factura");
                        Assert.assertNotNull(factura.select(fctr.getId()));

                        LOG.info("Busqueda de cargos de factura");
                        final List<FacturaCargoVO> fctgList = factura.selectFctgList(fctr.getId());

                        Assert.assertTrue(!fctgList.isEmpty());

                        LOG.info("Busqueda de servicios de factura");
                        final List<FacturaServicioVO> fctsList = factura.selectFctsList(fctr.getId());

                        Assert.assertTrue(!fctsList.isEmpty());

                        LOG.info("Busqueda de impuestos de factura");
                        final List<FacturaImpuestoVO> fctiList = factura.selectFctiList(fctr.getId());

                        Assert.assertTrue(!fctiList.isEmpty());

                        LOG.info("Busqueda de lineas de factura");
                        final PaginatedList<FacturaLineaVO> fctlList = factura.selectFctlList(fctr.getId(), 0, 20);

                        Assert.assertTrue(!fctlList.getList().isEmpty());

                        for (final FacturaLineaVO fctl : fctlList.getList()) {
                            LOG.info("Busqueda de linea de factura");
                            Assert.assertNotNull(factura.selectFctl(fctl.getId()));

                            LOG.info("Busqueda de detalles de factura");
                            final PaginatedList<FacturaDetalleVO> fctdList = factura
                                    .selectFctdList(fctl.getId(), 0, 20);

                            Assert.assertTrue(!fctdList.getList().isEmpty());

                            for (final FacturaDetalleVO fctd : fctdList.getList()) {
                                LOG.info("Busqueda de detalle de factura");
                                Assert.assertNotNull(factura.selectFctd(fctd.getId()));
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

                    final List<FacturaImpresionVO> fctrImprimirList = factura.selectImprimir(fctrIds);
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
