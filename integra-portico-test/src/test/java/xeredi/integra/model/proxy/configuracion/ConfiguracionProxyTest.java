package xeredi.integra.model.proxy.configuracion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguracionProxyTest.
 */
public final class ConfiguracionProxyTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConfiguracionProxyTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            LOG.info(ConfiguracionProxy.getString("test"));
            LOG.info(ConfiguracionProxy.getBoolean("testBoolean"));
            LOG.info(ConfiguracionProxy.getLong("testLong"));
            LOG.info(ConfiguracionProxy.getDouble("testDouble"));

            // Verificar que falla cuando se pide un parametro que no existe
            try {
                LOG.info(ConfiguracionProxy.getString("testNotFound"));

                Assert.fail("Deberia fallar");
            } catch (final ConfiguracionException ex) {
                LOG.info("Error controlado: " + ex.getMessage());
            }

            // Verificar que falla cuando se pide un parametro de un tipo incorrecto
            try {
                LOG.info(ConfiguracionProxy.getString("testBoolean"));

                Assert.fail("Deberia fallar");
            } catch (final ConfiguracionException ex) {
                LOG.info("Error controlado: " + ex.getMessage());
            }

            LOG.info(ConfiguracionProxy.getMessage("test"));
            LOG.info(ConfiguracionProxy.getMessage("testNotFound"));

            LOG.info("Inicio test Rendimiento");
            for (int i = 0; i < 1000000; i++) {
                ConfiguracionProxy.getString("test");
                ConfiguracionProxy.getBoolean("testBoolean");
                ConfiguracionProxy.getLong("testLong");
                ConfiguracionProxy.getDouble("testDouble");
                ConfiguracionProxy.getMessage("test");
                ConfiguracionProxy.getMessage("testNotFound");
            }
        } catch (final ConfiguracionException ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End test");
    }
}
