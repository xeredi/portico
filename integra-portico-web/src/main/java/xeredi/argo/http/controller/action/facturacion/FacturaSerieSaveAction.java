package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * Accion Web de Almacenamiento de una Serie de Factura.
 */
@Data
public final class FacturaSerieSaveAction extends CrudSaveAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1166773054003527886L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fcsr;

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
        if (accion == AccionCodigo.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_serie, model.getSerie());
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_anio, model.getAnio());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fcsr_numeroUltimo, model.getNumeroUltimo());
    }
}
