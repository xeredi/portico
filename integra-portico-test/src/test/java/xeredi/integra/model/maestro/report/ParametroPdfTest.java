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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
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
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             the IO exception
     */
    @Test
    public void test() throws ApplicationException, IOException {
        LOG.info("Start Test");

        final List<Long> tpprIds = Arrays.asList(new Long[] { 20005L, 20049L });
        final String language = "es";
        final String country = "ES";
        final String locale = "es_ES";

        final ParametroPdf prmtPdf = new ParametroPdf(new Locale(language, country));

        for (final Long tpprId : tpprIds) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(tpprId);
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiId(tpprId);
            prmtCriterioVO.setIdioma(locale);
            prmtCriterioVO.setFechaVigencia(Calendar.getInstance().getTime());

            LOG.info("Busqueda de Parametros");

            final TipoParametroVO tpprVO = TipoParametroProxy.select(tpprId);
            final Map<Long, TipoSubparametroVO> entiHijasMap = new HashMap<>();

            if (tpprVO.getEntiHijasList() != null) {
                for (final Long entiId : tpprVO.getEntiHijasList()) {
                    entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                }
            }

            final List<ParametroVO> prmtList = prmtBO.selectList(prmtCriterioVO);

            LOG.info("Impresion de Parametros");

            for (final ParametroVO prmtVO : prmtList) {
                final Map<Long, List<SubparametroVO>> sprmMap = new HashMap<>();

                if (tpprVO.getEntiHijasList() != null) {
                    for (final Long entiId : tpprVO.getEntiHijasList()) {
                        final SubparametroBO sprmBO = new SubparametroBO();
                        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                        sprmCriterioVO.setFechaVigencia(prmtCriterioVO.getFechaVigencia());
                        sprmCriterioVO.setIdioma(prmtCriterioVO.getIdioma());
                        sprmCriterioVO.setEntiId(entiId);

                        prmtCriterioVO.setId(prmtVO.getId());

                        sprmCriterioVO.setPrmt(prmtCriterioVO);

                        sprmMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
                    }
                }

                final Map<String, I18nVO> i18nMap = new HashMap<>();

                if (tpprVO.isI18n()) {
                    i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, prmtVO.getPrvr().getId()));
                }

                try (final OutputStream stream = new FileOutputStream("/temp/prmt_" + tpprVO.getId() + "_"
                        + prmtVO.getId() + ".pdf");) {
                    prmtPdf.imprimir(prmtVO, tpprVO, entiHijasMap, sprmMap, i18nMap, stream);
                }
            }
        }

        LOG.info("End Test");
    }
}
