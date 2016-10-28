package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSaveAction.
 */
@Data
public final class FacturaSaveAction extends CrudSaveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6621273927510408600L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fctr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        // TODO Auto-generated method stub

    }
}
