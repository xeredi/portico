package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.item.ItemFileExportAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.bo.SubparametroBOFactory;
import xeredi.integra.model.maestro.report.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfExportAction.
 */
public final class ParametroPdfExportAction extends ItemFileExportAction<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8831808221487676723L;

    /** The fecha vigencia. */
    protected Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doSpecificFileExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(fechaVigencia);

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();

        model = prmtBO.select(model.getId(), idioma, fechaVigencia);

        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(model.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (entiDetail.getEntiHijasList() != null) {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(model.getId());
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setIdioma(idioma);

            for (final Long entiId : entiDetail.getEntiHijasList()) {
                final SubparametroBO sprmBO = SubparametroBOFactory.newInstance(entiId);
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
            i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, model.getVersion().getId()));
        }

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

            prmtPdf.imprimir(model, entiDetail, entiHijasMap, itemHijosMap, i18nMap, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getFilename() {
        return MessageI18nKey.prmt.name() + '_' + model.getEntiId() + '_' + model.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContentType getContentType() {
        return ContentType.pdf;
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
