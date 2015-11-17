package xeredi.argo.model.estadistica.bo;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoBOTest.
 */
public final class PeriodoProcesoBOTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PeriodoProcesoBOTest.class);

    /**
     * Test agregacion.
     *
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void testAgregacion() throws InstanceNotFoundException, DuplicateInstanceException, IOException {
        LOG.info("Start test");

        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setCodigo("80");

        final SuperpuertoVO sprt = sprtBO.selectObject(sprtCriterio);

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final PeriodoProcesoVO peprVO = new PeriodoProcesoVO();

        for (int anio = 2013; anio < 2015; anio++) {
            for (int mes = 0; mes < 12; mes++) {
                peprVO.setSprt(sprt);
                peprVO.setAnio(anio);
                peprVO.setMes(mes + 1);

                LOG.info("Agregacion de servicios. Anio: " + peprVO.getAnio() + ", mes: " + peprVO.getMes());

                peprBO.agregarServicios(peprVO, true);
            }
        }

        LOG.info("End test");
    }
}
