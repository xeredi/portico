package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadRemoveAction.
 */
@Data
public final class AccionEntidadRemoveAction extends CrudRemoveAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7321406198311414130L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.acen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionEntidadBO acenBO = new AccionEntidadBO();

        acenBO.delete(model);
    }
}
