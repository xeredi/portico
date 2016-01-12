package xeredi.argo.http.controller.action.facturacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.report.ValoracionPdf;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

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

        final TipoDatoVO tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
        final ParametroVO pagador = prmtBO.select(model.getPagador().getId(), getIdioma(), model.getFref());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ValoracionPdf vlrcPdf = new ValoracionPdf(getLocale());

            vlrcPdf.imprimir(model, pagador, tpdtCodExencion, vlrgList, vlriList, vlrlList, baos);

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
