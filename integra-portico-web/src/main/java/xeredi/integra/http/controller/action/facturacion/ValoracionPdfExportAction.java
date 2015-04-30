package xeredi.integra.http.controller.action.facturacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudFileExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.report.ValoracionPdf;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionPdfExportAction.
 */
public final class ValoracionPdfExportAction extends CrudFileExportAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5178479812829740439L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(model.getId());
        vlrcCriterio.setIdioma(idioma);

        model = vlrcBO.selectObject(vlrcCriterio);

        final List<ValoracionCargoVO> vlrgList = vlrcBO.selectVlrgList(vlrcCriterio);
        final List<ValoracionImpuestoVO> vlriList = vlrcBO.selectVlriList(vlrcCriterio);

        final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

        vlrlCriterio.setVlrc(vlrcCriterio);
        vlrlCriterio.setIdioma(getIdioma());

        final List<ValoracionLineaVO> vlrlList = vlrcBO.selectVlrlList(vlrlCriterio);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ValoracionPdf vlrcPdf = new ValoracionPdf(getLocale());

            vlrcPdf.imprimir(model, vlrgList, vlriList, vlrlList, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.vlrc.name() + '_' + model.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrudFileExportAction.ContentType getContentType() {
        return ContentType.pdf;
    }
}
