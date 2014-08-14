package xeredi.integra.model.bo.facturacion;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.facturacion.ValoracionCargoVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;
import xeredi.util.pagination.PaginatedList;

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
            final Long vlrcId = 1740920L;
            final Valoracion vlrcBO = BOFactory.getInjector().getInstance(Valoracion.class);
            final ValoracionVO vlrc = vlrcBO.select(vlrcId);

            LOG.info("vlrc: " + vlrc);

            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(vlrcId);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);

            {
                LOG.info("vlrcList");

                final List<ValoracionLineaVO> vlrlList = vlrcBO.selectLineasList(vlrlCriterioVO);

                for (final ValoracionLineaVO vlrl : vlrlList) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlrcList Paginated");

                final PaginatedList<ValoracionLineaVO> vlrlList = vlrcBO.selectLineasList(vlrlCriterioVO, 1, 20);

                for (final ValoracionLineaVO vlrl : vlrlList.getList()) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlriList");

                final List<ValoracionImpuestoVO> vlriList = vlrcBO.selectImpuestosList(vlrcCriterioVO);

                for (final ValoracionImpuestoVO vlri : vlriList) {
                    LOG.info("vlri: " + vlri);
                }
            }

            {
                LOG.info("vlrgList");

                final List<ValoracionCargoVO> vlrgList = vlrcBO.selectCargosList(vlrcCriterioVO);

                for (final ValoracionCargoVO vlrg : vlrgList) {
                    LOG.info("vlrg: " + vlrg);
                }
            }
        } catch (Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }

}
