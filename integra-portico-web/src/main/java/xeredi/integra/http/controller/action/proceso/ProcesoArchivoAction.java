package xeredi.integra.http.controller.action.proceso;

import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoAction.
 */
public final class ProcesoArchivoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5076490409378752320L;

    /** The prar. */
    private ProcesoArchivoVO prar;

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
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setId(prar.getArchId());
        archCriterio.setPrbtId(prar.getPrbtId());

        arin = archBO.selectInfo(archCriterio);
        stream = archBO.select(prar.getArchId());

        return SUCCESS;
    }

    // get / set

    /**
     * Sets the prar.
     *
     * @param value
     *            the new prar
     */
    public void setPrar(final ProcesoArchivoVO value) {
        prar = value;
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
