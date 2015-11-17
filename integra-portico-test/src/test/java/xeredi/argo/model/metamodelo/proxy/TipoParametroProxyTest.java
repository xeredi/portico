package xeredi.argo.model.metamodelo.proxy;

import java.util.Map;

import org.junit.Test;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroBOTest.
 */
public final class TipoParametroProxyTest {

    /**
     * Test.
     *
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Test
    public static void test() throws InstanceNotFoundException {
        final Map<Long, TipoParametroDetailVO> tpprMap = TipoParametroProxy.selectMap();

        for (final TipoParametroDetailVO vo : tpprMap.values()) {
            TipoParametroProxy.select(vo.getEnti().getId());
        }
    }
}
