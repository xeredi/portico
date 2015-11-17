package xeredi.argo.model.comun.proxy;

import org.junit.Test;

import xeredi.argo.model.comun.vo.ConfigurationKey;

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
