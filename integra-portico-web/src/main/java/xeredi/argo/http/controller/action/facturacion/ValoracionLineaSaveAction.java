package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaSaveAction.
 */
public final class ValoracionLineaSaveAction extends CrudSaveAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2626755272488026780L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (accion) {
        case create:
            vlrcBO.insertVlrl(model);

            break;
        case edit:
            vlrcBO.updateVlrl(model);

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

        if (accion == ACCION_EDICION.edit) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrl;
    }
}
