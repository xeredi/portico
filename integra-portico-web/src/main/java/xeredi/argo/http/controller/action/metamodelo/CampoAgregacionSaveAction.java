package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionSaveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class CampoAgregacionSaveAction extends CrudSaveAction<CampoAgregacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8815220820665248741L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        switch (accion) {
        case create:
            cmagBO.insert(model);

            break;
        case edit:
            cmagBO.update(model);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpesId());

        if (accion == AccionCodigo.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.entd, model.getEntd());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.entd, model.getEntd().getId());
            }
        } else {
            Preconditions.checkNotNull(model.getEntd());
            Preconditions.checkNotNull(model.getEntd().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cmag_nombre, model.getNombre());
        FieldValidator.validateRequired(this, MessageI18nKey.cmag_agregar, model.getAgregar());
    }
}
