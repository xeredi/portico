package xeredi.integra.model.bo.facturacion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBOTest.
 */
public final class ValoracionBOTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoracionBOTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final Valoracion vlrcBO = BOFactory.getInjector().getInstance(Valoracion.class);

            vlrcBO.delete(1325920L);
        } catch (Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }

}
