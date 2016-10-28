package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Borrado de un Código de Referencia.
 */
public final class CodigoReferenciaRemoveAction extends CrudRemoveAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7405842967831298726L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrfBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.cdrf;
    }
}
