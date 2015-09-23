package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoRemoveAction.
 */
public final class EntidadTipoDatoRemoveAction extends CrudRemoveAction<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7790171477752471387L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        entdBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.entd;
    }
}
