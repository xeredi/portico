package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.bo.AccionEntidadBO;
import xeredi.argo.model.seguridad.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadSaveAction.
 */
public final class AccionEntidadSaveAction extends CrudSaveAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7228427972567184600L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.acen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AccionEntidadBO acenBO = new AccionEntidadBO();

        switch (accion) {
        case create:
            acenBO.insert(model);
            break;
        case edit:
            acenBO.update(model);
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

        FieldValidator.validateRequired(this, MessageI18nKey.accn, model.getAccn());
        FieldValidator.validateRequired(this, MessageI18nKey.enti, model.getEnti());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.accn, model.getAccn().getId());
            FieldValidator.validateRequired(this, MessageI18nKey.enti, model.getEnti().getId());
        }
    }
}
