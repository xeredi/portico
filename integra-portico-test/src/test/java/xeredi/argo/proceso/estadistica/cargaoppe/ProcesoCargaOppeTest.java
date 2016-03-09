package xeredi.argo.proceso.estadistica.cargaoppe;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
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
            final ArchivoBO archBO = new ArchivoBO();

            final ProcesoCargaOppe cargaOppe = new ProcesoCargaOppe();
            final ProcesoBO prbtBO = new ProcesoBO();

            {
                final Map<String, String> prpmMap = new HashMap<>();

                prpmMap.put(ProcesoCargaOppe.params.sobreescribir.name(), "true");

                final ArchivoVO arch = archBO.create(new File("80201304.zip"), ArchivoSentido.E);

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, ItemTipo.arch, Arrays.asList(arch.getArin().getId()));
            }

            {
                final Map<String, String> prpmMap = new HashMap<>();

                prpmMap.put(ProcesoCargaOppe.params.sobreescribir.name(), "true");

                final ArchivoVO arch = archBO.create(new File("80201210.zip"), ArchivoSentido.E);

                prbtBO.crear(ProcesoTipo.EST_CARGA, prpmMap, ItemTipo.arch, Arrays.asList(arch.getArin().getId()));
            }

            cargaOppe.procesar();
        } catch (final Exception ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End test");
    }

}
