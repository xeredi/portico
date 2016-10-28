package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadSaveAction.
 */
@Data
public final class AccionEntidadSaveAction extends CrudSaveAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7228427972567184600L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.acen;

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
        Preconditions.checkNotNull(model.getEntiId());

        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.aebs, model.getAebs());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.aebs, model.getAebs().getId());
        }
    }
}
