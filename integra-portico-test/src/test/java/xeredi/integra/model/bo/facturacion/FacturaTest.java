package xeredi.integra.model.bo.facturacion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;

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
            final Factura factura = BOFactory.getInjector().getInstance(Factura.class);
            final Set<Long> fctrIds = new HashSet<>();

            fctrIds.add(2146001L);
            fctrIds.add(2146051L);

            final List<FacturaImpresionVO> fctrList = factura.selectImprimir(fctrIds);

            LOG.info(fctrList);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
