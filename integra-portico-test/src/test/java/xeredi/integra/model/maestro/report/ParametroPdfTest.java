package xeredi.integra.model.maestro.report;

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
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.Subparametro;
import xeredi.integra.model.maestro.report.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfUtilTest.
 */
public final class ParametroPdfTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ParametroPdfTest.class);

    /**
     * Test.
     *
     * @throws IOException
     *             the IO exception
     * @throws DRException
     *             the DR exception
     */
    @Test
    public void test() throws IOException, DRException {
        LOG.info("Start Test");

        final List<Long> tpprIds = Arrays.asList(new Long[] { 20005L, 20049L });
        final String language = "es";
        final String country = "ES";
        final String locale = "es_ES";

        final ParametroPdf prmtPdf = new ParametroPdf(new Locale(language, country));
        final Parametro prmt = BOFactory.getInjector().getInstance(Parametro.class);

        for (final Long tpprId : tpprIds) {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiId(tpprId);
            prmtCriterioVO.setIdioma(locale);
            prmtCriterioVO.setFechaVigencia(Calendar.getInstance().getTime());
            prmtCriterioVO.setLimit(50);

            LOG.info("Busqueda de Parametros");

            final TipoParametroVO tpprVO = TipoParametroProxy.select(tpprId);
            final Map<Long, TipoSubparametroVO> entiHijasMap = new HashMap<>();

            if (tpprVO.getEntiHijasList() != null) {
                for (final Long entiId : tpprVO.getEntiHijasList()) {
                    entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                }
            }

            final List<ParametroVO> prmtList = prmt.selectList(prmtCriterioVO);

            LOG.info("Impresion de Parametros");

            for (final ParametroVO prmtVO : prmtList) {
                final Map<Long, List<SubparametroVO>> sprmMap = new HashMap<>();

                if (tpprVO.getEntiHijasList() != null) {
                    for (final Long entiId : tpprVO.getEntiHijasList()) {
                        final Subparametro sprm = BOFactory.getInjector().getInstance(Subparametro.class);
                        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                        sprmCriterioVO.setFechaVigencia(prmtCriterioVO.getFechaVigencia());
                        sprmCriterioVO.setIdioma(prmtCriterioVO.getIdioma());
                        sprmCriterioVO.setEntiId(entiId);

                        prmtCriterioVO.setId(prmtVO.getId());

                        sprmCriterioVO.setPrmt(prmtCriterioVO);

                        sprmMap.put(entiId, sprm.selectList(sprmCriterioVO));
                    }
                }

                final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

                if (tpprVO.isI18n()) {
                    p18nMap.putAll(prmt.selectI18nMap(prmtVO.getPrvr().getId()));
                }

                try (final OutputStream stream = new FileOutputStream("/temp/prmt_" + tpprVO.getId() + "_"
                        + prmtVO.getId() + ".pdf");) {
                    prmtPdf.imprimir(prmtVO, tpprVO, entiHijasMap, sprmMap, p18nMap, stream);
                }
            }
        }

        LOG.info("End Test");
    }
}
