package xeredi.integra.model.bo.facturacion;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

            crgoIds.add(60001L);
            crgoIds.add(60002L);

            vlrdBO.valorarServicio(1209891L, crgoIds, Calendar.getInstance().getTime(), 1225001L);
        } finally {
            LOG.info("End test");
        }
    }
}
