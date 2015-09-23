package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

/**
 * The Class GrupoRemoveAction.
 */
public final class GrupoRemoveAction extends CrudRemoveAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3464408300660789661L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final GrupoBO grpoBO = new GrupoBO();

        grpoBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grpo;
    }
}
