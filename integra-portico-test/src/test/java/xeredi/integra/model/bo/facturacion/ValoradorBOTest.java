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
public final class ValoradorBOTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorBOTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final Valorador vlrdBO = BOFactory.getInjector().getInstance(Valorador.class);
            final Set<Long> crgoIds = new HashSet<>();

            // Manifiesto
            crgoIds.add(60001L);
            crgoIds.add(60002L);
            vlrdBO.valorarServicio(1192567L, crgoIds, Calendar.getInstance().getTime(), 1208001L);

            // Escala
         // crgoIds.add(60003L);
         // crgoIds.add(60004L);
         // crgoIds.add(60005L);
         // vlrdBO.valorarServicio(1192118L, crgoIds, Calendar.getInstance().getTime(), 1226001L);

        } catch (Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
