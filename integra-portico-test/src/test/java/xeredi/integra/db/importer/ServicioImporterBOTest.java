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
    private static final int NUM_ITERATIONS = 1;

    /**
     * Test.
     */
    @Test
    public void test() {
        final ServicioImporterBO importer = new ServicioImporterBO();

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            LOG.info("Iteration: " + i);

            importer.importEntities();
        }
    }

}
