package xeredi.integra.http.controller.action.servicio;

import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.servicio.vo.ServicioArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioArchivoAction.
 */
public final class ServicioArchivoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2603874884019648859L;

    /** The srar. */
    private ServicioArchivoVO srar;

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
    @Action(value = "srar-download", results = { @Result(name = "success", type = "stream", params = { "inputName",
            "stream", "contentDisposition", "filename=${arin.nombre}" }) })
    public String download() throws ApplicationException {
        final ArchivoBO archBO = new ArchivoBO();
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setId(srar.getArchId());
        archCriterio.setSrvcId(srar.getSrvcId());

        arin = archBO.selectInfo(archCriterio);
        stream = archBO.select(srar.getArchId());

        return SUCCESS;
    }

    // get / set

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

    /**
     * Sets the srar.
     *
     * @param value
     *            the new srar
     */
    public void setSrar(final ServicioArchivoVO value) {
        srar = value;
    }

}
