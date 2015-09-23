package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaEditAction.
 */
public final class TipoEstadisticaEditAction extends EntidadEditAction<TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3008447139811475030L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

            model = tpesBO.select(model.getId(), getIdioma());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpes;
    }

}
