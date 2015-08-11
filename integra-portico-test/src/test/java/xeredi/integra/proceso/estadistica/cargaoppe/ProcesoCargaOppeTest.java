package xeredi.integra.proceso.estadistica.cargaoppe;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaOppeTest.
 */
public final class ProcesoCargaOppeTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaOppeTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {

            final ProcesoCargaOppe cargaOppe = new ProcesoCargaOppe();
            final ProcesoBO prbtBO = new ProcesoBO();

            {
                final Map<String, String> prpmMap = new HashMap<>();

                prpmMap.put(ProcesoCargaOppe.AUTP_PARAM, "80");
                prpmMap.put(ProcesoCargaOppe.ANIO_PARAM, "2013");
                prpmMap.put(ProcesoCargaOppe.MES_PARAM, "04");
                prpmMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, null, null, null);
            }

            {
                final Map<String, String> prpmMap = new HashMap<>();

                prpmMap.put(ProcesoCargaOppe.AUTP_PARAM, "1030308");
                prpmMap.put(ProcesoCargaOppe.ANIO_PARAM, "2012");
                prpmMap.put(ProcesoCargaOppe.MES_PARAM, "10");
                prpmMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, null, null, null);
            }

            cargaOppe.procesar();
        } catch (final Exception ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End test");
    }

}
