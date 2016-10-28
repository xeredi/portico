package xeredi.argo.http.controller.action.seguridad;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoSaveAction.
 */
@Data
public final class GrupoSaveAction extends CrudSaveAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 260195700227671081L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.grpo;

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
        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.grpo_nombre, model.getNombre());
    }
}
