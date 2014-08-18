package xeredi.integra.model.bo.facturacion;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.facturacion.ValoracionCargoVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBOTest.
 */
public final class ValoracionTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoracionTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            final Long vlrcId = 1367920L;
            final Long vlrlId = 1371129L;
            final Long vlrdId = 1371148L;

            final Valoracion vlrcBO = BOFactory.getInjector().getInstance(Valoracion.class);

            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(vlrcId);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);
            vlrlCriterioVO.setId(vlrlId);
            vlrdCriterioVO.setId(vlrdId);
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            {
                LOG.info("vlrc");

                final ValoracionVO vlrc = vlrcBO.select(vlrcId);

                Assert.assertNotNull(vlrc);

                LOG.info("vlrc: " + vlrc);
            }

            {
                LOG.info("vlrl");

                final ValoracionLineaVO vlrl = vlrcBO.selectLinea(vlrlId);

                Assert.assertNotNull(vlrl);

                LOG.info("vlrl: " + vlrl);
            }

            {
                LOG.info("vlrlList");

                final List<ValoracionLineaVO> vlrlList = vlrcBO.selectLineasList(vlrlCriterioVO);

                Assert.assertNotNull(vlrlList);
                Assert.assertTrue(!vlrlList.isEmpty());

                for (final ValoracionLineaVO vlrl : vlrlList) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlrlList Paginated");

                final PaginatedList<ValoracionLineaVO> vlrlList = vlrcBO.selectLineasList(vlrlCriterioVO, 0, 20);

                Assert.assertNotNull(vlrlList);
                Assert.assertNotNull(vlrlList.getList());
                Assert.assertTrue(!vlrlList.getList().isEmpty());

                for (final ValoracionLineaVO vlrl : vlrlList.getList()) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlrd");

                final ValoracionDetalleVO vlrd = vlrcBO.selectDetalle(vlrdId);

                Assert.assertNotNull(vlrd);

                LOG.info("vlrd: " + vlrd);
            }

            {
                LOG.info("vlrdList Paginated");

                final PaginatedList<ValoracionDetalleVO> vlrdList = vlrcBO.selectDetallesList(vlrdCriterioVO, 0, 20);

                Assert.assertNotNull(vlrdList);
                Assert.assertNotNull(vlrdList.getList());
                Assert.assertTrue(!vlrdList.getList().isEmpty());

                for (final ValoracionDetalleVO vlrd : vlrdList.getList()) {
                    LOG.info("vlrd: " + vlrd);
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
