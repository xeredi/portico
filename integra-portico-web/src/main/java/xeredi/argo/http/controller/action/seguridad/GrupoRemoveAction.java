package xeredi.argo.http.controller.action.seguridad;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

/**
 * The Class GrupoRemoveAction.
 */
@Data
public final class GrupoRemoveAction extends CrudRemoveAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3464408300660789661L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.grpo;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final GrupoBO grpoBO = new GrupoBO();

        grpoBO.delete(model);
    }
}
