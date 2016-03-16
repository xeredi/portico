package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.FacturaAnulacionBO;
import xeredi.argo.model.facturacion.vo.FacturaAnulacionVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAnulacionSaveAction.
 */
public final class FacturaAnulacionSaveAction extends CrudSaveAction<FacturaAnulacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1464959696532041004L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fcan;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctrId());

        final FacturaAnulacionBO fcanBO = new FacturaAnulacionBO();

        fcanBO.anular(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.fcsr, model.getFcsrId());
        FieldValidator.validateRequired(this, MessageI18nKey.fcan_fecha, model.getFecha());
    }
}
