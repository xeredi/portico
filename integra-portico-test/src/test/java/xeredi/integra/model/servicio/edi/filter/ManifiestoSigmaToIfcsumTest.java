package xeredi.integra.model.servicio.edi.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoSigmaToIfcsumTest.
 */
public class ManifiestoSigmaToIfcsumTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ManifiestoSigmaToIfcsumTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        try {
            final ManifiestoSigmaToIfcsum manifiestoSigmaToIfcsum = new ManifiestoSigmaToIfcsum();
            final File file = new File(
                    "/proyectos/team/git/portico/integra-portico-test/etc/examples/ifcsum/MZ1NO605.itc");
            final FileInputStream source = new FileInputStream(file);
            final FileOutputStream dest = new FileOutputStream(
                    "/proyectos/team/git/portico/integra-portico-test/etc/examples/ifcsum/" + file.getName() + ".conv");

            manifiestoSigmaToIfcsum.convert(source, dest);
        } catch (final Exception ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        }
    }
}
