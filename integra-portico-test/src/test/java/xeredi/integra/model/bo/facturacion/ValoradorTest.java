package xeredi.integra.model.bo.facturacion;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;

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
            final Valorador valorador = BOFactory.getInjector().getInstance(Valorador.class);
            final Set<Long> crgoIds = new HashSet<>();

            // Manifiesto
            crgoIds.add(60001L);
            crgoIds.add(60002L);

            valorador.valorarServicio(1259547L, crgoIds, Calendar.getInstance().getTime(), 1237001L);
            valorador.valorarServicio(1259572L, crgoIds, Calendar.getInstance().getTime(), 1237001L);
            valorador.valorarServicio(1259571L, crgoIds, Calendar.getInstance().getTime(), 1237001L);
            valorador.valorarServicio(1259570L, crgoIds, Calendar.getInstance().getTime(), 1237001L);
            valorador.valorarServicio(1259546L, crgoIds, Calendar.getInstance().getTime(), 1237001L);

            // valorador.valorarServicio(1687962L, crgoIds, Calendar.getInstance().getTime(), 1644001L);
            // valorador.valorarServicio(1655906L, crgoIds, Calendar.getInstance().getTime(), 1644001L);
            // valorador.valorarServicio(1687896L, crgoIds, Calendar.getInstance().getTime(), 1644001L);
            // valorador.valorarServicio(1671952L, crgoIds, Calendar.getInstance().getTime(), 1644001L);
            // valorador.valorarServicio(1687979L, crgoIds, Calendar.getInstance().getTime(), 1644001L);

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
