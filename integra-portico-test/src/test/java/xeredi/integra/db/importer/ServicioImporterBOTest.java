package xeredi.integra.db.importer;

import java.util.Locale;

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
    private static final int NUM_ITERATIONS = 100;

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final ServicioImporterBO importer = new ServicioImporterBO();

        importer.importEntities(NUM_ITERATIONS, new Locale("es", "ES"));

        LOG.info("End test");
    }

}
