package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoRemoveAction.
 */
public final class EntidadGrupoDatoRemoveAction extends CrudRemoveAction<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8335697148874416415L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        engdBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.engd;
    }
}
