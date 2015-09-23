package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.bo.GrupoAccionBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionSaveAction.
 */
public final class GrupoAccionSaveAction extends CrudSaveAction<GrupoAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3700519776384435385L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final GrupoAccionBO gracBO = new GrupoAccionBO();

        gracBO.insert(model.getGrpoId(), model.getAccnId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkArgument(accion == ACCION_EDICION.create);
        Preconditions.checkArgument(model.getAccnId() != null || model.getGrpoId() != null);

        FieldValidator.validateRequired(this, MessageI18nKey.accn, model.getAccnId());
        FieldValidator.validateRequired(this, MessageI18nKey.grpo, model.getGrpoId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grac;
    }
}
