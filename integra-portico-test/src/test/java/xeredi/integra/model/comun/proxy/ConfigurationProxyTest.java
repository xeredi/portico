package xeredi.integra.model.comun.proxy;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationProxyTest.
 */
public final class ConfigurationProxyTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        System.out.println(ConfigurationProxy.getConfiguration().getString("estadistica.files.oppe.erroneo.home"));
        System.out.println(ConfigurationProxy.getConfiguration().getString("db.dataSource.driver"));
    }

}
