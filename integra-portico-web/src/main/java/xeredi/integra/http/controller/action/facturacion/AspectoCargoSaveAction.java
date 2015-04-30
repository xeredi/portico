package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoSaveAction.
 */
public final class AspectoCargoSaveAction extends CrudSaveAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5838925962199897361L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        switch (accion) {
        case create:
            ascrBO.insert(model);

            break;
        case edit:
            ascrBO.update(model);

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
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getAspcId());

            FieldValidator.validateRequired(this, MessageI18nKey.ascr_crgo, model.getCrgo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, model.getVersion());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, model.getVersion().getFini());
        }
    }

}
