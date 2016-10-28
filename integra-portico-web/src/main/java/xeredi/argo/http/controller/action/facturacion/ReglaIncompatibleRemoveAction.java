package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleRemoveAction.
 */
@Data
public final class ReglaIncompatibleRemoveAction extends CrudRemoveAction<ReglaIncompatibleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4230713466511401390L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.rgin;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        rginBO.delete(model);
    }
}
