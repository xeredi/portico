package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ValoracionLineaBO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaSaveAction.
 */
@Data
public final class ValoracionLineaSaveAction extends CrudSaveAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2626755272488026780L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.vlrl;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ValoracionLineaBO vlrlBO = new ValoracionLineaBO();

        switch (accion) {
        case create:
            vlrlBO.insert(model);

            break;
        case edit:
            vlrlBO.update(model);

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
        Preconditions.checkNotNull(model.getVlrcId());

        if (accion == AccionCodigo.edit) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVlrcId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgla, model.getRgla());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgla, model.getRgla().getId());

            if (model.getRgla().getTipo() == ReglaTipo.T) {
                FieldValidator.validateRequired(this, MessageI18nKey.vlrl_impuesto, model.getImpuesto());

                if (!hasErrors()) {
                    FieldValidator.validateRequired(this, MessageI18nKey.vlrl_impuesto, model.getImpuesto().getId());
                }
            }
        }
    }
}
