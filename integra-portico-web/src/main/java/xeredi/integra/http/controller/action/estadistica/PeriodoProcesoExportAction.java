package xeredi.integra.http.controller.action.estadistica;

import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoExportAction.
 */
public final class PeriodoProcesoExportAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4344754234690990490L;

    /** The pepr. */
    private PeriodoProcesoVO pepr;

    /** The arin. */
    private ArchivoInfoVO arin;

    /** The stream. */
    private InputStream stream;

    // acciones web

    /**
     * Xls export.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "pepr-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/zip", "inputName", "stream", "contentDisposition", "filename=${pepr.filename}.zip" }) })
    public String export() throws ApplicationException {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final ArchivoBO archBO = new ArchivoBO();

        pepr = peprBO.select(pepr.getId());
        arin = archBO.select(pepr.getArin().getId());
        stream = archBO.selectStream(pepr.getArin().getId());

        return SUCCESS;
    }

    // get/set

    /**
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
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
     * Gets the arin.
     *
     * @return the arin
     */
    public ArchivoInfoVO getArin() {
        return arin;
    }

}
