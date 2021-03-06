package xeredi.argo.model.maestro.report;

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

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

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

            final TipoParametroDetailVO tpprDetail = TipoParametroProxy.select(tpprId);
            final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();

            if (tpprDetail.getEntiHijasList() != null) {
                for (final Long entiId : tpprDetail.getEntiHijasList()) {
                    entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                }
            }

            final List<ParametroVO> prmtList = prmtBO.selectList(prmtCriterioVO);

            LOG.info("Impresion de Parametros");

            for (final ParametroVO prmtVO : prmtList) {
                final Map<Long, List<SubparametroVO>> sprmMap = new HashMap<>();

                if (tpprDetail.getEntiHijasList() != null) {
                    for (final Long entiId : tpprDetail.getEntiHijasList()) {
                        final SubparametroBO sprmBO = SubparametroBOFactory.newInstance(entiId);
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

                if (tpprDetail.getEnti().isI18n()) {
                    i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, prmtVO.getVersion().getId()));
                }

                try (final OutputStream stream = new FileOutputStream(
                        "/temp/prmt_" + tpprDetail.getEnti().getId() + "_" + prmtVO.getId() + ".pdf");) {
                    prmtPdf.imprimir(prmtVO, tpprDetail, entiHijasMap, sprmMap, i18nMap, stream);
                }
            }
        }

        LOG.info("End Test");
    }
}
