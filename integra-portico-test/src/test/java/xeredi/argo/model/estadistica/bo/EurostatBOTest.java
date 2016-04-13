package xeredi.argo.model.estadistica.bo;

import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.argo.model.estadistica.io.EurostatFileExport;
import xeredi.argo.model.estadistica.vo.EurostatCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EurostatBOTest.
 */
public final class EurostatBOTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(EurostatBOTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final EurostatFileExport fileExport = new EurostatFileExport();
        final EurostatBO erstBO = new EurostatBO();

        LOG.info("A2_1");

        try (final FileOutputStream fos = new FileOutputStream("/A2_2015_1.txt")) {
            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();

            erstCriterio.setYear(2015);
            erstCriterio.setQuarter(1);

            fileExport.generateFile(fos, erstBO.selectA2List(erstCriterio));
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }

        LOG.info("F2_1");

        try (final FileOutputStream fos = new FileOutputStream("/F2_2015_1.txt")) {
            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();

            erstCriterio.setYear(2015);
            erstCriterio.setQuarter(1);

            fileExport.generateFile(fos, erstBO.selectF2List(erstCriterio));
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }

        LOG.info("C1_1");

        try (final FileOutputStream fos = new FileOutputStream("/C1_2015_1.txt")) {
            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();

            erstCriterio.setYear(2015);
            erstCriterio.setQuarter(1);

            fileExport.generateFile(fos, erstBO.selectC1List(erstCriterio));
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }

        LOG.info("D1_1");

        try (final FileOutputStream fos = new FileOutputStream("/D1_2015_1.txt")) {
            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();

            erstCriterio.setYear(2015);
            erstCriterio.setQuarter(1);

            fileExport.generateFile(fos, erstBO.selectD1List(erstCriterio));
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }

        LOG.info("A1_1");

        try (final FileOutputStream fos = new FileOutputStream("/A1_2015_1.txt")) {
            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();

            erstCriterio.setYear(2015);
            erstCriterio.setQuarter(1);

            fileExport.generateFile(fos, erstBO.selectA1List(erstCriterio));
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }

//        LOG.info("2");
//
//        try (final FileOutputStream fos = new FileOutputStream("/A1_2015_2.txt")) {
//            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();
//
//            erstCriterio.setYear(2015);
//            erstCriterio.setQuarter(2);
//
//            fileExport.generateFile(fos, erstBO.selectA1List(erstCriterio));
//        } catch (final Throwable ex) {
//            ex.printStackTrace(System.err);
//        }
//
//        LOG.info("3");
//
//        try (final FileOutputStream fos = new FileOutputStream("/A1_2015_3.txt")) {
//            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();
//
//            erstCriterio.setYear(2015);
//            erstCriterio.setQuarter(3);
//
//            fileExport.generateFile(fos, erstBO.selectA1List(erstCriterio));
//        } catch (final Throwable ex) {
//            ex.printStackTrace(System.err);
//        }
//
//        LOG.info("4");
//
//        try (final FileOutputStream fos = new FileOutputStream("/A1_2015_4.txt")) {
//            final EurostatCriterioVO erstCriterio = new EurostatCriterioVO();
//
//            erstCriterio.setYear(2015);
//            erstCriterio.setQuarter(4);
//
//            fileExport.generateFile(fos, erstBO.selectA1List(erstCriterio));
//        } catch (final Throwable ex) {
//            ex.printStackTrace(System.err);
//        }

        LOG.info("End test");
    }
}
