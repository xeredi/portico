package xeredi.integra.model.metamodelo.proxy;

import java.util.Map;

import org.junit.Test;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoBOTest.
 */
public final class TipoDatoProxyTest {

    /**
     * Test.
     *
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Test
    public static void test() throws InstanceNotFoundException {
        final Map<Long, TipoDatoVO> tpdtMap = TipoDatoProxy.selectMap();

        for (final TipoDatoVO vo : tpdtMap.values()) {
            TipoDatoProxy.select(vo.getId());
        }
    }

}
