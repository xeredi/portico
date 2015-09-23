package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridRemoveAction.
 */
public final class EntidadAccionGridRemoveAction extends CrudRemoveAction<EntidadAccionGridVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7363930156589738654L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        enagBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enag;
    }
}
