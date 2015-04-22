package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.integra.http.controller.action.item.ItemPdfExportAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.report.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfExportAction.
 */
public final class ParametroPdfExportAction extends ItemPdfExportAction<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8831808221487676723L;

    /** The fecha vigencia. */
    protected Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doSpecificPdfExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(fechaVigencia);

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(item.getEntiId());
        final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();

        item = prmtBO.select(item.getId(), idioma, fechaVigencia);

        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(item.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (entiDetail.getEntiHijasList() != null) {
            final SubparametroBO sprmBO = new SubparametroBO();
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(item.getId());
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setIdioma(idioma);

            for (final Long entiId : entiDetail.getEntiHijasList()) {
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                sprmCriterioVO.setPrmt(prmtCriterioVO);
                sprmCriterioVO.setEntiId(entiId);
                sprmCriterioVO.setFechaVigencia(fechaVigencia);
                sprmCriterioVO.setIdioma(idioma);

                entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                itemHijosMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
            }
        }

        final Map<String, I18nVO> i18nMap = new HashMap<>();

        if (entiDetail.getEnti().isI18n()) {
            i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId()));
        }

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

            prmtPdf.imprimir(item, entiDetail, entiHijasMap, itemHijosMap, i18nMap, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getFilename() {
        return MessageI18nKey.prmt.name() + '_' + item.getEntiId() + '_' + item.getId();
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }
}
