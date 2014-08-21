package xeredi.integra.model.proxy.metamodelo;

import java.util.Map;

import org.junit.Test;

import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroBOTest.
 */
public final class TipoParametroProxyTest {

    /**
     * Test.
     */
    @Test
    public static void test() {
        final Map<Long, TipoParametroVO> tpprMap = TipoParametroProxy.selectMap();

        for (final TipoParametroVO vo : tpprMap.values()) {
            TipoParametroProxy.select(vo.getId());
        }
    }
}
