package xeredi.integra.db.importer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioImporterBOTest.
 */
public final class ServicioImporterBOTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioImporterBOTest.class);

    /** The Constant NUM_ITERATIONS. */
    private static final int NUM_ITERATIONS = 40;

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final ServicioImporterBO importer = new ServicioImporterBO();

        importer.importEntities(NUM_ITERATIONS);

        LOG.info("End test");
    }

}
