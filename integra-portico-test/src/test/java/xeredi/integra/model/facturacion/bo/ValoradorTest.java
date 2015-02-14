package xeredi.integra.model.facturacion.bo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.facturacion.ProcesoValorador;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorBOTest.
 */
public final class ValoradorTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoradorTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final ProcesoBO prbtBO = new ProcesoBO();

            final Map<String, String> parametroMap = new HashMap<>();
            final Set<Long> crgoIds = new HashSet<>();

            // Manifiesto
            crgoIds.add(60001L);
            crgoIds.add(60002L);

            parametroMap.put("crgoIdList", crgoIds.toString());
            parametroMap.put("fliq", Calendar.getInstance().getTime().toString());

            prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, Arrays.asList(new Long[] { 1825942L }),
                    null);
            prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, Arrays.asList(new Long[] { 1841379L }),
                    null);
            prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, Arrays.asList(new Long[] { 1825941L }),
                    null);
            prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, Arrays.asList(new Long[] { 1825943L }),
                    null);
            prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, Arrays.asList(new Long[] { 1825863L }),
                    null);

            final ProcesoValorador valorador = new ProcesoValorador();

            valorador.procesar();

            // Escala
            // crgoIds.add(60003L);
            // crgoIds.add(60004L);
            // crgoIds.add(60005L);
            // valorador.valorarServicio(1192118L, crgoIds, Calendar.getInstance().getTime(), 1226001L);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
