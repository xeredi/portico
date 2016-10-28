package xeredi.argo.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemFileExportAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.report.ParametroPdf;
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
 * The Class ParametroPdfExportAction.
 */
public final class ParametroPdfExportAction extends ItemFileExportAction<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8831808221487676723L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doSpecificFileExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getFref());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();

        model = prmtBO.select(model.getId(), idioma, model.getFref());

        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(model.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (entiDetail.getEntiHijasList() != null) {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(model.getId());
            prmtCriterioVO.setFechaVigencia(model.getFref());
            prmtCriterioVO.setIdioma(idioma);

            for (final Long entiId : entiDetail.getEntiHijasList()) {
                final SubparametroBO sprmBO = SubparametroBOFactory.newInstance(entiId);
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                sprmCriterioVO.setPrmt(prmtCriterioVO);
                sprmCriterioVO.setEntiId(entiId);
                sprmCriterioVO.setFechaVigencia(model.getFref());
                sprmCriterioVO.setIdioma(idioma);

                entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                itemHijosMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
            }
        }

        final Map<String, I18nVO> i18nMap = new HashMap<>();

        if (entiDetail.getEnti().isI18n()) {
            i18nMap.putAll(I18nBO.selectMap(ClassPrefix.prvr, model.getVersion().getId()));
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
}
