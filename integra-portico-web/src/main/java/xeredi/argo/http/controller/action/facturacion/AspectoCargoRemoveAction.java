package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoRemoveAction.
 */
@Data
public final class AspectoCargoRemoveAction extends CrudRemoveAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8982657228033763093L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.ascr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascrBO.delete(model);
    }
}
