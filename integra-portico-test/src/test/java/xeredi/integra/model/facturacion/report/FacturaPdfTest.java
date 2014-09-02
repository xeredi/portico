package xeredi.integra.model.facturacion.report;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Factura;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.bo.FacturaImpresionVO;
import xeredi.integra.model.facturacion.report.FacturaPdf;
import xeredi.integra.model.util.GlobalNames;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaPdfTest.
 */
public final class FacturaPdfTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturaPdfTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            for (int i = 0; i < 10; i++) {
                final Long id = 2196001L;

                final Set<Long> fctrIds = new HashSet<>();
                final FacturaPdf facturaPdf = new FacturaPdf(GlobalNames.DEFAULT_LOCALE);
                final Factura factura = BOFactory.getInjector().getInstance(FacturaBO.class);

                fctrIds.add(id);

                LOG.info("Busqueda de Facturas");

                final List<FacturaImpresionVO> list = factura.selectImprimir(fctrIds);

                LOG.info("Impresion");

                for (final FacturaImpresionVO vo : list) {
                    final OutputStream os = new FileOutputStream("/temp/test.pdf");

                    facturaPdf.imprimir(vo, os);
                }
            }
        } catch (final Throwable th) {
            LOG.error(th, th);

            Assert.fail(th.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
