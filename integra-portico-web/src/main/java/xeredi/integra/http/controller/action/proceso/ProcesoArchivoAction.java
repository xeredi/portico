package xeredi.integra.http.controller.action.proceso;

import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoAction.
 */
public final class ProcesoArchivoAction extends ItemAction implements ModelDriven<ProcesoArchivoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5076490409378752320L;

    /** The prar. */
    private ProcesoArchivoVO model;

    /** The arin. */
    private ArchivoInfoVO arin;

    /** The stream. */
    private InputStream stream;

    // Acciones web

    /**
     * Download.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "prar-download", results = { @Result(name = "success", type = "stream", params = { "inputName",
            "stream", "contentDisposition", "filename=${arin.nombre}" }) })
    public String download() throws ApplicationException {
        final ArchivoBO archBO = new ArchivoBO();

        arin = archBO.select(model.getArchId());
        stream = archBO.selectStream(model.getArchId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcesoArchivoVO getModel() {
        return model;
    }

    /**
     * Sets the prar.
     *
     * @param value
     *            the new prar
     */
    public void setModel(final ProcesoArchivoVO value) {
        model = value;
    }

    /**
     * Gets the arin.
     *
     * @return the arin
     */
    public ArchivoInfoVO getArin() {
        return arin;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }

}
