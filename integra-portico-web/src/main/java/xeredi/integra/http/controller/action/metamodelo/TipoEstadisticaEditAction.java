package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

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

}
