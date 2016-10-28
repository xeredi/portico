package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * Borrado de un Código de Referencia.
 */
@Data
public final class CodigoReferenciaRemoveAction extends CrudRemoveAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7405842967831298726L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.cdrf;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrfBO.delete(model);
    }
}
