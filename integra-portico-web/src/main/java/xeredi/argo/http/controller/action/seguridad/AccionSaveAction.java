package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;

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
        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.accn_codigo, model.getCodigo());
        FieldValidator.validateRequired(this, MessageI18nKey.accn_prefix, model.getPrefix());
        FieldValidator.validateRequired(this, MessageI18nKey.accn_core, model.getCore());
        FieldValidator.validateRequired(this, MessageI18nKey.accn_multiple, model.getMultiple());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.accn;
    }
}
