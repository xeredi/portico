package xeredi.integra.model.facturacion.bo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
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
            final Long vlrcId = 2156046L;
            final Long vlrlId = 2156047L;
            final Long vlrdId = 2156048L;

            final ValoracionBO vlrcBO = new ValoracionBO();

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

                final ValoracionVO vlrc = vlrcBO.select(vlrcId, "es");

                Assert.assertNotNull(vlrc);

                LOG.info("vlrc: " + vlrc);
            }

            {
                LOG.info("vlrcImpresion");

                final Set<Long> ids = new HashSet<>();

                ids.add(vlrcId);

                // FIXME Acabar
            }

            {
                LOG.info("vlrl");

                final ValoracionLineaVO vlrl = vlrcBO.selectVlrl(vlrlId, "es");

                Assert.assertNotNull(vlrl);

                LOG.info("vlrl: " + vlrl);
            }

            {
                LOG.info("vlrlList");

                final List<ValoracionLineaVO> vlrlList = vlrcBO.selectVlrlList(vlrcId, "es");

                Assert.assertNotNull(vlrlList);
                Assert.assertTrue(!vlrlList.isEmpty());

                for (final ValoracionLineaVO vlrl : vlrlList) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlrlList Paginated");

                final PaginatedList<ValoracionLineaVO> vlrlList = vlrcBO.selectVlrlList(vlrcId, "es", 0, 20);

                Assert.assertNotNull(vlrlList);
                Assert.assertNotNull(vlrlList.getList());
                Assert.assertTrue(!vlrlList.getList().isEmpty());

                for (final ValoracionLineaVO vlrl : vlrlList.getList()) {
                    LOG.info("vlrl: " + vlrl);
                }
            }

            {
                LOG.info("vlrd");

                final ValoracionDetalleVO vlrd = vlrcBO.selectVlrd(vlrdId);

                Assert.assertNotNull(vlrd);

                LOG.info("vlrd: " + vlrd);
            }

            {
                LOG.info("vlrdList Paginated");

                final PaginatedList<ValoracionDetalleVO> vlrdList = vlrcBO.selectVlrdList(vlrdCriterioVO, 0, 20);

                Assert.assertNotNull(vlrdList);
                Assert.assertNotNull(vlrdList.getList());
                Assert.assertTrue(!vlrdList.getList().isEmpty());

                for (final ValoracionDetalleVO vlrd : vlrdList.getList()) {
                    LOG.info("vlrd: " + vlrd);
                }
            }

            {
                LOG.info("vlriList");

                final List<ValoracionImpuestoVO> vlriList = vlrcBO.selectVlriList(vlrcId, "es");

                for (final ValoracionImpuestoVO vlri : vlriList) {
                    LOG.info("vlri: " + vlri);
                }
            }

            {
                LOG.info("vlrgList");

                final List<ValoracionCargoVO> vlrgList = vlrcBO.selectVlrgList(vlrcId, "es");

                for (final ValoracionCargoVO vlrg : vlrgList) {
                    LOG.info("vlrg: " + vlrg);
                }
            }
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }

}
