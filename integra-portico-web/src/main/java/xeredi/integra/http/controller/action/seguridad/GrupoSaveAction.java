package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoSaveAction.
 */
public final class GrupoSaveAction extends CrudSaveAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 260195700227671081L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();

        switch (accion) {
        case create:
            grpoBO.insert(model);
            break;
        case edit:
            grpoBO.update(model);
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

        FieldValidator.validateRequired(this, MessageI18nKey.grpo_nombre, model.getNombre());
    }

}
