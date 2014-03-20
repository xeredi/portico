package xeredi.integra.model.bo.comun;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.util.GlobalNames;

// TODO: Auto-generated Javadoc
/**
 * The Class IgBOTest.
 */
public final class IgBOTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(IgBOTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        final IgBO igBO = new IgBO();

        for (int i = 0; i < 100000; i++) {
            final Long value = igBO.nextVal(GlobalNames.SQ_INTEGRA);

            if (value % 1000 == 0) {
                LOG.info(value);
            }
        }
    }
}
