package xeredi.argo.proceso.estadistica.cargaoppe;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

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

                prpmMap.put(ProcesoCargaOppe.params.autp.name(), "80");
                prpmMap.put(ProcesoCargaOppe.params.anio.name(), "2013");
                prpmMap.put(ProcesoCargaOppe.params.mes.name(), "04");
                prpmMap.put(ProcesoCargaOppe.params.sobreescribir.name(), "true");

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, null, null, null);
            }

            {
                final Map<String, String> prpmMap = new HashMap<>();

                prpmMap.put(ProcesoCargaOppe.params.autp.name(), "80");
                prpmMap.put(ProcesoCargaOppe.params.anio.name(), "2012");
                prpmMap.put(ProcesoCargaOppe.params.mes.name(), "10");
                prpmMap.put(ProcesoCargaOppe.params.sobreescribir.name(), "true");

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, null, null, null);
            }

            cargaOppe.procesar();
        } catch (final Exception ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End test");
    }

}
