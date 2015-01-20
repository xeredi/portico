package xeredi.integra.proceso.estadistica.cargaoppe;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaOppeTest.
 */
public final class ProcesoCargaOppeTest {

    private static final Log LOG = LogFactory.getLog(ProcesoCargaOppeTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start test");

        try {

            final ProcesoCargaOppe cargaOppe = new ProcesoCargaOppe();
            final ProcesoBO prbtBO = new ProcesoBO();
            final ProcesoVO prbtVO = new ProcesoVO();

            prbtVO.setModulo(cargaOppe.getProcesoModulo());
            prbtVO.setTipo(cargaOppe.getProcesoTipo());

            prbtVO.getPrpmMap().put(ProcesoCargaOppe.AUTP_PARAM, "1030308");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.ANIO_PARAM, "2013");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.MES_PARAM, "04");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");
            prbtBO.crear(prbtVO);

            prbtVO.getPrpmMap().put(ProcesoCargaOppe.AUTP_PARAM, "1030308");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.ANIO_PARAM, "2012");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.MES_PARAM, "10");
            prbtVO.getPrpmMap().put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");
            prbtBO.crear(prbtVO);

            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.AUTP_PARAM, "11");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.ANIO_PARAM, "2013");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.MES_PARAM, "01");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");
            // prbtBO.crear(prbtVO);
            //
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.AUTP_PARAM, "11");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.ANIO_PARAM, "2013");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.MES_PARAM, "02");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");
            // prbtBO.crear(prbtVO);
            //
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.AUTP_PARAM, "11");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.ANIO_PARAM, "2013");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.MES_PARAM, "03");
            // prbtVO.getPrpmMap().put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, "true");
            // prbtBO.crear(prbtVO);

            cargaOppe.procesar();
        } catch (final Exception ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End test");
    }

}
