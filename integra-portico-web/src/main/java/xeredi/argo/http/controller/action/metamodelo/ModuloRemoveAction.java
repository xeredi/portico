package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloRemoveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ModuloRemoveAction extends CrudRemoveAction<ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7556234323466189867L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ModuloBO mdloBO = new ModuloBO();

        mdloBO.delete(model);
    }
}
