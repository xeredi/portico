package xeredi.integra.http.controller.action.proceso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.report.ExcelUtil;
import xeredi.integra.model.proceso.bo.Proceso;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXlsAction.
 */
public final class ProcesoXlsAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3249503570912661191L;

    /** The item criterio. */
    private ProcesoCriterioVO itemCriterio;

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
    @Action(value = "prbt-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=PROCESOS.xls" }) })
    public String xlsExport() throws IOException {
        final Proceso prbtBO = BOFactory.getInjector().getInstance(ProcesoBO.class);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ExcelUtil excelUtil = new ExcelUtil(getLocale());

            excelUtil.generarProcesos(prbtBO.selectList(itemCriterio), baos);

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
    public final ProcesoCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final ProcesoCriterioVO value) {
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
