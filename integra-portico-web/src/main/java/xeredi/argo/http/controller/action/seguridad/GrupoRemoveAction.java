package xeredi.argo.http.controller.action.seguridad;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

/**
 * The Class GrupoRemoveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
}
