package xeredi.integra.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.report.ExcelUtil;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioXlsAction.
 */
public final class ServicioXlsAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The item criterio. */
    private ServicioCriterioVO itemCriterio;

    /** The enti. */
    private TipoServicioVO enti;

    /** The stream. */
    private InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones Web

    /**
     * Excel export.
     *
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Action(value = "srvc-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=${enti.codigo}.xls" }) })
    public String xlsExport() throws IOException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final ServicioBO srvcBO = new ServicioBO();

        enti = TipoServicioProxy.select(itemCriterio.getEntiId());
        itemCriterio.setSoloDatosGrid(false);
        itemCriterio.setIdioma(getIdioma());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ExcelUtil excelUtil = new ExcelUtil(getLocale());

            excelUtil.generarServicios(srvcBO.selectList(itemCriterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * Gets the item criterio.
     *
     * @return the item criterio
     */
    public final ServicioCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final ServicioCriterioVO value) {
        itemCriterio = value;
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
