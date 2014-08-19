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

            vlrcIds.add(1965046L);
            vlrcIds.add(1969960L);
            vlrcIds.add(1979533L);
            vlrcIds.add(1984286L);
            vlrcIds.add(1984380L);

            facturador.facturarValoraciones(vlrcIds, /* 61001L */null, 68001L, Calendar.getInstance().getTime(),
                    1644001L);

            // vlrcIds.add(1951376L);
            // vlrcIds.add(1956594L);
            // vlrcIds.add(1966167L);
            // vlrcIds.add(1970925L);
            // vlrcIds.add(1971407L);

            // facturador.facturarValoraciones(vlrcIds, /* 61001L */null, 68001L, Calendar.getInstance().getTime(),
            // 1237001L);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        }

        LOG.info("End test");
    }
}