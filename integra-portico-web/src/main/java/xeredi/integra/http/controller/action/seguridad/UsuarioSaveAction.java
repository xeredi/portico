package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.bo.UsuarioBO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSaveAction.
 */
public final class UsuarioSaveAction extends CrudSaveAction<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4486221964172526427L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final UsuarioBO usroBO = new UsuarioBO();

        switch (accion) {
        case create:
            usroBO.insert(model);

            break;
        case edit:
            usroBO.update(model);

            break;

        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.usro_login, model.getLogin());
        FieldValidator.validateRequired(this, MessageI18nKey.usro_contrasenia, model.getContrasenia());
        FieldValidator.validateRequired(this, MessageI18nKey.usro_nombre, model.getNombre());
    }
}
