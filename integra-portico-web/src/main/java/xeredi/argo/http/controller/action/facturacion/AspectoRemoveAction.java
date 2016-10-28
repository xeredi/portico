package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoRemoveAction.
 */
@Data
public final class AspectoRemoveAction extends CrudRemoveAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2102022344017937240L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.aspc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final AspectoBO aspcBO = new AspectoBO();

        aspcBO.delete(model);
    }
}
