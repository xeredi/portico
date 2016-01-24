package xeredi.argo.http.controller.action.seguridad;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.bo.ResultadoLoginVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoAction.
 */
public final class UsuarioAccesoAction extends BaseAction implements ModelDriven<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1732425764567626359L;

    /** The model. */
    @Getter
    @Setter
    private UsuarioVO model;

    /** The resultado login. */
    @Getter
    private ResultadoLoginVO resultadoLogin;

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
            resultadoLogin = SessionManager.login(model.getLogin(), model.getContrasenia());
        }
    }
}
