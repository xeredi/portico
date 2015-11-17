package xeredi.argo.model.facturacion.bo;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorTest.
 */
public final class FacturadorTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {
            // final Long prbtId = 1644001L;
            final Long prbtId = 1237001L;
            final ValoracionBO vlrcBO = new ValoracionBO();

            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final PaginatedList<ValoracionVO> vlrcList = vlrcBO.selectList(vlrcCriterioVO, 0, 20);

            Assert.assertTrue(!vlrcList.getList().isEmpty());

            final Set<Long> vlrcIds = new HashSet<>();

            for (final ValoracionVO vlrc : vlrcList.getList()) {
                vlrcIds.add(vlrc.getId());
            }

            // final FacturadorBO facturador = new FacturadorBO();
            //
            // facturador.facturarValoraciones(vlrcIds, 68001L, null, Calendar.getInstance().getTime());
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
