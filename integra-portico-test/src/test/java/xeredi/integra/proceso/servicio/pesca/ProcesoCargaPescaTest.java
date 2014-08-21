package xeredi.integra.proceso.servicio.pesca;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.proceso.bo.Proceso;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPescaTest.
 */
public final class ProcesoCargaPescaTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory
            .getLog(ProcesoCargaPescaTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final ProcesoCargaPesca cargaPesca = new ProcesoCargaPesca();
        final Proceso prbtBO = BOFactory.getInjector().getInstance(Proceso.class);

        final ProcesoVO prbtVO1 = new ProcesoVO();
        final ProcesoArchivoVO prarVO1 = new ProcesoArchivoVO();

        prarVO1.setNombre("cadistot.txt");
        prbtVO1.getPrarEntradaList().add(prarVO1);
        prbtVO1.setModulo(cargaPesca.getProcesoModulo());
        prbtVO1.setTipo(cargaPesca.getProcesoTipo());
        prbtBO.crear(prbtVO1);

        final ProcesoVO prbtVO2 = new ProcesoVO();
        final ProcesoArchivoVO prarVO2 = new ProcesoArchivoVO();

        prarVO2.setNombre("cadizAsca.txt");
        prbtVO2.getPrarEntradaList().add(prarVO2);
        prbtVO2.setModulo(cargaPesca.getProcesoModulo());
        prbtVO2.setTipo(cargaPesca.getProcesoTipo());
        prbtBO.crear(prbtVO2);

        cargaPesca.procesar();

        LOG.info("End test");
    }
}
