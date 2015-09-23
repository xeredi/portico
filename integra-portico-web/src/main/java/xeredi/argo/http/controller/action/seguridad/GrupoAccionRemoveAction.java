package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoAccionBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionRemoveAction.
 */
public final class GrupoAccionRemoveAction extends CrudRemoveAction<GrupoAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4521219701701041031L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getGrpoId());
        Preconditions.checkNotNull(model.getAccnId());

        final GrupoAccionBO gracBO = new GrupoAccionBO();

        gracBO.delete(model.getGrpoId(), model.getAccnId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grac;
    }
}
