package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadAccionBO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

        enacBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enac;
    }
}
