package xeredi.argo.http.controller.action.metamodelo;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionTramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

/**
 * The Class AccionTramiteRemoveAction.
 */
public final class AccionTramiteRemoveAction extends CrudRemoveAction<AccionTramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 926618789888697416L;

    /** Prefijo de accion. */
    @Getter
    private final AccionPrefix accnPrefix = AccionPrefix.actr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionTramiteBO actrBO = new AccionTramiteBO();

        actrBO.delete(model);
    }
}
