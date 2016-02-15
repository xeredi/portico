package xeredi.argo.http.controller.action.metamodelo;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.AccionTramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionTramiteSaveAction.
 */
public final class AccionTramiteSaveAction extends CrudSaveAction<AccionTramiteVO> {

    /** serialVersionUID. */
    private static final long serialVersionUID = 7906748575846848933L;

    /** Prefijo de accion. */
    @Getter
    private final AccionPrefix accnPrefix = AccionPrefix.actr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AccionTramiteBO actrBO = new AccionTramiteBO();

        switch (accion) {
        case create:
            actrBO.insert(model);
            break;
        case edit:
            actrBO.update(model);
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
        Preconditions.checkNotNull(model.getTrmtId());

        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.accn, model.getAccn());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.accn, model.getAccn().getId());
        }
    }
}
