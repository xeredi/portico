package xeredi.integra.proceso.servicio.escala;

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
 * The Class ProcesoCargaEscalaTest.
 */
public final class ProcesoCargaEscalaTest {
    private static final Log LOG = LogFactory.getLog(ProcesoCargaEscalaTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start Test");

        final ProcesoCargaEscala cargaEscala = new ProcesoCargaEscala();
        final Proceso prbtBO = BOFactory.getInjector().getInstance(ProcesoBO.class);

        final ProcesoVO prbtVO1 = new ProcesoVO();
        final ProcesoArchivoVO prarVO1 = new ProcesoArchivoVO();

        prarVO1.setNombre("47escalavolcano.itc");
        prbtVO1.getPrarEntradaList().add(prarVO1);
        prbtVO1.setModulo(cargaEscala.getProcesoModulo());
        prbtVO1.setTipo(cargaEscala.getProcesoTipo());
        prbtBO.crear(prbtVO1);

        final ProcesoVO prbtVO2 = new ProcesoVO();
        final ProcesoArchivoVO prarVO2 = new ProcesoArchivoVO();

        prarVO2.setNombre("47ever.itc");
        prbtVO2.getPrarEntradaList().add(prarVO2);
        prbtVO2.setModulo(cargaEscala.getProcesoModulo());
        prbtVO2.setTipo(cargaEscala.getProcesoTipo());
        prbtBO.crear(prbtVO2);

        final ProcesoVO prbtVO3 = new ProcesoVO();
        final ProcesoArchivoVO prarVO3 = new ProcesoArchivoVO();

        prarVO3.setNombre("a.itc");
        prbtVO3.getPrarEntradaList().add(prarVO3);
        prbtVO3.setModulo(cargaEscala.getProcesoModulo());
        prbtVO3.setTipo(cargaEscala.getProcesoTipo());
        prbtBO.crear(prbtVO3);

        final ProcesoVO prbtVO4 = new ProcesoVO();
        final ProcesoArchivoVO prarVO4 = new ProcesoArchivoVO();

        prarVO4.setNombre("alta escala.itc");
        prbtVO4.getPrarEntradaList().add(prarVO4);
        prbtVO4.setModulo(cargaEscala.getProcesoModulo());
        prbtVO4.setTipo(cargaEscala.getProcesoTipo());
        prbtBO.crear(prbtVO4);

        cargaEscala.procesar();

        LOG.info("End Test");
    }

}
