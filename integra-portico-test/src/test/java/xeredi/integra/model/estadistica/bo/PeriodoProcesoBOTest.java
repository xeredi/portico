package xeredi.integra.model.estadistica.bo;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;

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

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.AUTORIDAD_PORTUARIA.getId());
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setEntiId(Entidad.AUTORIDAD_PORTUARIA.getId());
        prmtCriterioVO.setParametro("80");

        final ParametroVO autpVO = prmtBO.selectObject(prmtCriterioVO);

        final PeriodoProcesoVO peprVO = new PeriodoProcesoVO();

        for (int anio = 2013; anio < 2015; anio++) {
            for (int mes = 0; mes < 12; mes++) {
                peprVO.setAutp(autpVO);
                peprVO.setAnio(anio);
                peprVO.setMes(mes + 1);

                LOG.info("Agregacion de servicios. Anio: " + peprVO.getAnio() + ", mes: " + peprVO.getMes());

                peprBO.agregarServicios(peprVO, peprBO.selectSubpIds(autpVO.getId(), peprVO.getFreferencia()), true);
            }
        }

        LOG.info("End test");
    }
}
