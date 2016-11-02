package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.FacturaRectificacionBO;
import xeredi.argo.model.facturacion.vo.FacturaRectificacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaRectificacionSaveAction.
 */
@Data
public final class FacturaRectificacionSaveAction extends CrudSaveAction<FacturaRectificacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6559800096192675179L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctrId());

        final FacturaRectificacionBO fcrcBO = new FacturaRectificacionBO();

        fcrcBO.rectificar(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc, model.getVlrcId());
        FieldValidator.validateRequired(this, MessageI18nKey.fcrc_duplicar, model.getDuplicar());
    }
}
