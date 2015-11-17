package xeredi.argo.model.facturacion.report;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.bo.FacturaImpresionVO;

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
                final FacturaPdf facturaPdf = new FacturaPdf(new Locale(
                        ConfigurationProxy.getString(ConfigurationKey.language_default)));
                final FacturaBO fctrBO = new FacturaBO();

                fctrIds.add(id);

                LOG.info("Busqueda de Facturas");

                final List<FacturaImpresionVO> list = fctrBO.selectImprimir(fctrIds);

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
