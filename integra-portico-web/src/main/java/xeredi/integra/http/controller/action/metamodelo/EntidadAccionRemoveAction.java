package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Borrado de una Acción Específica de Entidad.
 */
public final class EntidadAccionRemoveAction extends CrudRemoveAction<EntidadAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -902787354968046090L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enacBO.delete(model.getId());
    }
}
