package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

/**
 * The Class AccionSaveAction.
 */
public final class AccionSaveAction extends CrudSaveAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6960100948960687513L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AccionBO accnBO = new AccionBO();

        switch (accion) {
        case create:
            accnBO.insert(model);
            break;
        case edit:
            accnBO.update(model);
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
        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.accn_codigo, model.getCodigo());
        FieldValidator.validateRequired(this, MessageI18nKey.accn_nombre, model.getNombre());
    }
}
