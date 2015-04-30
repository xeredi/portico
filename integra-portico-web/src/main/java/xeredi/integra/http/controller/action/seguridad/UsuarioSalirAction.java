package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.http.controller.session.SessionManager;
import xeredi.integra.model.comun.exception.ApplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSalirAction.
 */
public final class UsuarioSalirAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6689064314355141824L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        SessionManager.logout();
    }
}
