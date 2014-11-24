package xeredi.integra.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.report.SubservicioXls;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXlsAction.
 */
public final class SubservicioXlsAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3600500596378173543L;

    /** The item criterio. */
    private SubservicioCriterioVO itemCriterio;

    /** The enti. */
    private TipoSubservicioVO enti;

    /** The stream. */
    private InputStream stream;

    // Acciones Web

    /**
     * Excel export.
     *
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "ssrv-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=${enti.codigo}.xls" }) })
    public String xlsExport() throws IOException, ApplicationException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final SubservicioBO ssrvBO = new SubservicioBO();

        enti = TipoSubservicioProxy.select(itemCriterio.getEntiId());
        itemCriterio.setSoloDatosGrid(false);
        itemCriterio.setIdioma(getIdioma());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final SubservicioXls excelUtil = new SubservicioXls(getLocale());

            excelUtil.generarSubservicios(ssrvBO.selectList(itemCriterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item criterio.
     *
     * @return the item criterio
     */
    public final SubservicioCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final SubservicioCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public final InputStream getStream() {
        return stream;
    }

}
