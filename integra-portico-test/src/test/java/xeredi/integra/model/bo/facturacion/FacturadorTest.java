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
 * The Class FacturadorTest.
 */
public final class FacturadorTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final Facturador facturador = BOFactory.getInjector().getInstance(Facturador.class);
            final Set<Long> vlrcIds = new HashSet<>();

            vlrcIds.add(1765046L);
            vlrcIds.add(1769960L);
            vlrcIds.add(1779533L);
            vlrcIds.add(1784286L);
            vlrcIds.add(1784380L);

            facturador.facturarValoraciones(vlrcIds, /*61001L*/ null, 68001L, Calendar.getInstance().getTime(), 1644001L);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        }

        LOG.info("End test");
    }
}
