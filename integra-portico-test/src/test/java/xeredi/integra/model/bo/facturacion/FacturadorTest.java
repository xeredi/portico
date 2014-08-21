package xeredi.integra.model.bo.facturacion;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Facturador;
import xeredi.integra.model.facturacion.bo.FacturadorBO;
import xeredi.integra.model.facturacion.bo.Valoracion;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
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
            final Valoracion valoracion = BOFactory.getInjector().getInstance(ValoracionBO.class);
            final Facturador facturador = BOFactory.getInjector().getInstance(FacturadorBO.class);

            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final PaginatedList<ValoracionVO> vlrcList = valoracion.selectList(vlrcCriterioVO, 0, 20);

            Assert.assertTrue(!vlrcList.getList().isEmpty());

            final Set<Long> vlrcIds = new HashSet<>();

            for (final ValoracionVO vlrc : vlrcList.getList()) {
                vlrcIds.add(vlrc.getId());
            }

            facturador
                    .facturarValoraciones(vlrcIds, /* 61001L */null, 68001L, Calendar.getInstance().getTime(), prbtId);
        } catch (final Throwable ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } finally {
            LOG.info("End test");
        }
    }
}
