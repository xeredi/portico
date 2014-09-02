package xeredi.integra.proceso.servicio.manifiesto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.proceso.bo.Proceso;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiestoTest.
 */
public final class ProcesoCargaManifiestoTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory
            .getLog(ProcesoCargaManifiestoTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final ProcesoCargaManifiesto cargaManifiesto = new ProcesoCargaManifiesto();
        final Proceso prbtBO = BOFactory.getInjector().getInstance(ProcesoBO.class);

        final ProcesoVO prbtVO1 = new ProcesoVO();
        final ProcesoArchivoVO prarVO1 = new ProcesoArchivoVO();

        prarVO1.setNombre("I0040GAAIgayWR.itc");
        prbtVO1.getPrarEntradaList().add(prarVO1);
        prbtVO1.setModulo(cargaManifiesto.getProcesoModulo());
        prbtVO1.setTipo(cargaManifiesto.getProcesoTipo());
        prbtBO.crear(prbtVO1);

        final ProcesoVO prbtVO2 = new ProcesoVO();
        final ProcesoArchivoVO prarVO2 = new ProcesoArchivoVO();

        prarVO2.setNombre("I0040GAA_laqKd.itc");
        prbtVO2.getPrarEntradaList().add(prarVO2);
        prbtVO2.setModulo(cargaManifiesto.getProcesoModulo());
        prbtVO2.setTipo(cargaManifiesto.getProcesoTipo());
        prbtBO.crear(prbtVO2);

        final ProcesoVO prbtVO3 = new ProcesoVO();
        final ProcesoArchivoVO prarVO3 = new ProcesoArchivoVO();

        prarVO3.setNombre("I0040EAA2Jaquw.itc");
        prbtVO3.getPrarEntradaList().add(prarVO3);
        prbtVO3.setModulo(cargaManifiesto.getProcesoModulo());
        prbtVO3.setTipo(cargaManifiesto.getProcesoTipo());
        prbtBO.crear(prbtVO3);

        final ProcesoVO prbtVO4 = new ProcesoVO();
        final ProcesoArchivoVO prarVO4 = new ProcesoArchivoVO();

        prarVO4.setNombre("gh.itc");
        prbtVO4.getPrarEntradaList().add(prarVO4);
        prbtVO4.setModulo(cargaManifiesto.getProcesoModulo());
        prbtVO4.setTipo(cargaManifiesto.getProcesoTipo());
        prbtBO.crear(prbtVO4);

        cargaManifiesto.procesar();

        LOG.info("End test");
    }

}
