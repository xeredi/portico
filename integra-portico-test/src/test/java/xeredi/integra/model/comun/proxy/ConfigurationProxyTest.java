package xeredi.integra.model.comun.proxy;

import org.junit.Test;

import xeredi.integra.model.comun.vo.ConfigurationKey;

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
        System.out.println(ConfigurationProxy.getString(ConfigurationKey.escala_files_entrada_home));
    }

}
