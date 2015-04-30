package xeredi.integra.http.controller.action.proceso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.report.ProcesoXls;
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

    // Acciones Web

    /**
     * Excel export.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "prbt-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=PROCESOS.xls" }) })
    public String xlsExport() throws ApplicationException {
        final ProcesoBO prbtBO = new ProcesoBO();

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ProcesoXls excelUtil = new ProcesoXls(getLocale());

            excelUtil.generarProcesos(prbtBO.selectList(itemCriterio), baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
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
