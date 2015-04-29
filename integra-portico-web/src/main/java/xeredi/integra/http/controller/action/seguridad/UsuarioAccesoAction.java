package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.session.SessionManager;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoAction.
 */
public final class UsuarioAccesoAction extends BaseAction implements ModelDriven<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1732425764567626359L;

    /** The model. */
    private UsuarioVO model;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        if (model == null) {
            model = new UsuarioVO();
        }

        FieldValidator.validateRequired(this, MessageI18nKey.usro_login, model.getLogin());
        FieldValidator.validateRequired(this, MessageI18nKey.usro_contrasenia, model.getContrasenia());

        if (!hasErrors()) {
            SessionManager.login(model.getLogin(), model.getContrasenia());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final UsuarioVO value) {
        model = value;
    }
}
