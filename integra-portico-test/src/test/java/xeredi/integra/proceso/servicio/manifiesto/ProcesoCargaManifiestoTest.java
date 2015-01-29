package xeredi.integra.proceso.servicio.manifiesto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiestoTest.
 */
public final class ProcesoCargaManifiestoTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaManifiestoTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        final ProcesoCargaManifiesto cargaManifiesto = new ProcesoCargaManifiesto();
        final ProcesoBO prbtBO = new ProcesoBO();

        {
            final ProcesoVO prbtVO = new ProcesoVO();
            final ProcesoArchivoVO prarVO = new ProcesoArchivoVO();

            prarVO.setNombre("11311501013_1_ALTA.itc");
            prbtVO.getPrarEntradaList().add(prarVO);
            prbtVO.setModulo(cargaManifiesto.getProcesoModulo());
            prbtVO.setTipo(cargaManifiesto.getProcesoTipo());
            prbtBO.crear(prbtVO);
        }

        // cargaManifiesto.procesar();

        LOG.info("End test");
    }

}
