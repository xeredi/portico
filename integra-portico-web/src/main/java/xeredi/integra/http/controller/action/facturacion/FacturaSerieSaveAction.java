package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Accion Web de Almacenamiento de una Serie de Factura.
 */
public final class FacturaSerieSaveAction extends CrudSaveAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1166773054003527886L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        switch (accion) {
        case create:
            fcsrBO.insert(model);

            break;
        case edit:
            fcsrBO.update(model);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_serie, model.getSerie());
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_anio, model.getAnio());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fcsr_numeroUltimo, model.getNumeroUltimo());
    }
}
