package xeredi.integra.http.controller.action.facturacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.report.ValoracionPdf;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionPdfAction.
 */
public final class ValoracionPdfAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3945767104537210962L;

    /** The Constant PDF_MIMETYPE. */
    public static final String PDF_MIMETYPE = "application/pdf";

    /** The item report. */
    private Long vlrcId;

    /** The stream. */
    private InputStream stream;

    /** The filename. */
    private String filename;

    // Acciones web

    /**
     * Prints the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "vlrc-print", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "${type}", "inputName", "stream", "contentDisposition", "filename=${filename}" }) })
    public String print() throws ApplicationException {
        Preconditions.checkNotNull(vlrcId);

        final ValoracionBO vlrcBO = new ValoracionBO();
        final AspectoBO aspcBO = new AspectoBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();
        final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

        vlrcCriterio.setId(vlrcId);
        vlrcCriterio.setIdioma(getIdioma());

        vlrlCriterio.setVlrc(vlrcCriterio);
        vlrlCriterio.setIdioma(getIdioma());

        final ValoracionVO vlrc = vlrcBO.select(vlrcId, getIdioma());
        final List<ValoracionCargoVO> vlrgList = vlrcBO.selectVlrgList(vlrcCriterio);
        final List<ValoracionImpuestoVO> vlriList = vlrcBO.selectVlriList(vlrcCriterio);
        final List<ValoracionLineaVO> vlrlList = vlrcBO.selectVlrlList(vlrlCriterio);
        final AspectoVO aspc = aspcBO.select(vlrc.getAspc().getId(), vlrc.getFref(), getIdioma());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ValoracionPdf vlrcPdf = new ValoracionPdf(getLocale());

            vlrcPdf.imprimir(aspc, vlrc, vlrgList, vlriList, vlrlList, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the new vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return PDF_MIMETYPE;
    }

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

}
