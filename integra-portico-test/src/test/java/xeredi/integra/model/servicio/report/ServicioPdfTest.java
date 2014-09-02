package xeredi.integra.model.servicio.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.dynamicreports.report.exception.DRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.Servicio;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.Subservicio;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.report.ServicioPdf;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioPdfTest.
 */
public final class ServicioPdfTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioPdfTest.class);

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws DRException
     *             the DR exception
     */
    @Test
    public void test() throws IOException, DRException {
        LOG.info("Start Test");

        final List<Long> tpsrIds = Arrays.asList(new Long[] { 21002L, 21003L });
        final String language = "es";
        final String country = "ES";
        final String locale = "es_ES";

        final ServicioPdf srvcPdf = new ServicioPdf(new Locale(language, country));
        final Servicio srvc = BOFactory.getInjector().getInstance(ServicioBO.class);

        for (final Long tpsrId : tpsrIds) {
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setEntiId(tpsrId);
            srvcCriterioVO.setIdioma(locale);
            srvcCriterioVO.setFechaVigencia(Calendar.getInstance().getTime());
            srvcCriterioVO.setLimit(50);

            LOG.info("Busqueda de Servicios");

            final TipoServicioVO tpsrVO = TipoServicioProxy.select(tpsrId);
            final Map<Long, TipoSubservicioVO> entiHijasMap = new HashMap<>();

            if (tpsrVO.getEntiHijasList() != null) {
                for (final Long entiId : tpsrVO.getEntiHijasList()) {
                    entiHijasMap.put(entiId, TipoSubservicioProxy.select(entiId));
                }
            }

            final List<ServicioVO> srvcList = srvc.selectList(srvcCriterioVO);

            LOG.info("Impresion de Servicios");

            for (final ServicioVO srvcVO : srvcList) {
                final Map<Long, List<SubservicioVO>> ssrvMap = new HashMap<>();

                if (tpsrVO.getEntiHijasList() != null) {
                    for (final Long entiId : tpsrVO.getEntiHijasList()) {
                        final Subservicio ssrv = BOFactory.getInjector().getInstance(SubservicioBO.class);
                        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                        ssrvCriterioVO.setFechaVigencia(srvcCriterioVO.getFechaVigencia());
                        ssrvCriterioVO.setIdioma(srvcCriterioVO.getIdioma());
                        ssrvCriterioVO.setEntiId(entiId);

                        srvcCriterioVO.setId(srvcVO.getId());

                        ssrvCriterioVO.setSrvc(srvcCriterioVO);

                        ssrvMap.put(entiId, ssrv.selectList(ssrvCriterioVO));
                    }
                }

                try (final OutputStream stream = new FileOutputStream("/temp/srvc_" + tpsrVO.getId() + "_"
                        + srvcVO.getId() + ".pdf");) {
                    srvcPdf.imprimir(srvcVO, tpsrVO, entiHijasMap, ssrvMap, stream);
                }
            }
        }

        LOG.info("End Test");
    }

}
