package xeredi.integra.model.proxy.metamodelo;

import java.util.Map;

import org.junit.Test;

import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoBOTest.
 */
public final class TipoDatoProxyTest {
    /**
     * Test.
     */
    @Test
    public static void test() {
        final Map<Long, TipoDatoVO> tpdtMap = TipoDatoProxy.selectMap();

        for (final TipoDatoVO vo : tpdtMap.values()) {
            TipoDatoProxy.select(vo.getId());
        }
    }

}
