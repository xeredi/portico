package xeredi.integra.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.bo.util.ExcelUtil;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
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
    @Action(value = "ssrv-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=${enti.codigo}.xls" }) })
    public String xlsExport() throws IOException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

        enti = TipoSubservicioProxy.select(itemCriterio.getEntiId());
        itemCriterio.setSoloDatosGrid(false);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ExcelUtil excelUtil = new ExcelUtil(getLocale());

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
