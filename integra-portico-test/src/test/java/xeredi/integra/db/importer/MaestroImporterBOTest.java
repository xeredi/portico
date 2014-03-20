package xeredi.integra.db.importer;

import java.util.Calendar;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroImporterBOTest.
 */
public final class MaestroImporterBOTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        final MaestroImporterBO importer = new MaestroImporterBO("es_ES", Calendar.getInstance().getTime());

        importer.importEntities();
    }
}
