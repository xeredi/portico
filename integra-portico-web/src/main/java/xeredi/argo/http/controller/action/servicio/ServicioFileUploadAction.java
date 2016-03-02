package xeredi.argo.http.controller.action.servicio;

import java.io.IOException;

import xeredi.argo.http.controller.action.comun.CrudFileUploadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioFileUploadAction.
 */
public final class ServicioFileUploadAction extends CrudFileUploadAction<Entidad> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2802980591334798026L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doImport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model);

        final ProcesoBO prbtBO = new ProcesoBO();
        ProcesoTipo procesoTipo = null;

        switch (model) {
        case MANIFIESTO:
            procesoTipo = ProcesoTipo.MAN_CARGA;

            break;
        case ESCALA:
            procesoTipo = ProcesoTipo.ESC_CARGA;

            break;
        case MANIFIESTO_PESCA:
            procesoTipo = ProcesoTipo.PES_CARGA;

            break;
        default:
            throw new Error("Tipo de proceso desconocido: " + procesoTipo);
        }

        prbtBO.crear(procesoTipo, null, null, null, file);
    }
}
