package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

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
            vlrcBO.insertVlrl(model, null);

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
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgla, model.getRgla());

        if (!hasErrors()) {
            if (model.getRgla().getTipo() == ReglaTipo.T) {
                FieldValidator.validateRequired(this, MessageI18nKey.vlrl_impuesto, model.getImpuesto());
            }
        }
    }
}
