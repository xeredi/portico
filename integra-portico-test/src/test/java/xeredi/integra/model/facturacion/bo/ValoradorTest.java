package xeredi.integra.model.facturacion.bo;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorBOTest.
 */
public final class ValoradorTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final ValoradorBO valorador = new ValoradorBO();
            final Set<Long> crgoIds = new HashSet<>();

            // Manifiesto
            crgoIds.add(60001L);
            crgoIds.add(60002L);

            valorador.valorarServicio(1825942L, crgoIds, Calendar.getInstance().getTime(), 1844001L);
            valorador.valorarServicio(1841379L, crgoIds, Calendar.getInstance().getTime(), 1844001L);
            valorador.valorarServicio(1825941L, crgoIds, Calendar.getInstance().getTime(), 1844001L);
            valorador.valorarServicio(1825943L, crgoIds, Calendar.getInstance().getTime(), 1844001L);
            valorador.valorarServicio(1825863L, crgoIds, Calendar.getInstance().getTime(), 1844001L);

            // Escala
            // crgoIds.add(60003L);
            // crgoIds.add(60004L);
            // crgoIds.add(60005L);
            // valorador.valorarServicio(1192118L, crgoIds, Calendar.getInstance().getTime(), 1226001L);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
