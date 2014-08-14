package xeredi.integra.model.bo.facturacion;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBOTest.
 */
public final class ValoracionBOTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoracionBOTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final Valoracion vlrcBO = BOFactory.getInjector().getInstance(Valoracion.class);

            final ValoracionVO vlrc = vlrcBO.select(1353920L);

            LOG.info("vlrc: " + vlrc);

            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(1353920L);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);

            final List<ValoracionLineaVO> vlrlList = vlrcBO.selectLineasList(vlrlCriterioVO);

            LOG.info("vlrlList: " + vlrlList);
        } catch (Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }

}
