package xeredi.integra.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleSaveAction.
 */
public final class ValoracionDetalleSaveAction extends CrudSaveAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1354136282476244950L;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (accion) {
        case create:
            vlrcBO.insertVlrd(model);

            break;
        case edit:
            vlrcBO.updateVlrd(model);

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
        Preconditions.checkNotNull(model.getVlrlId());
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getRgla());
        Preconditions.checkNotNull(vlrl.getRgla().getEnti());

        if (ACCION_EDICION.edit == accion) {
            Preconditions.checkNotNull(model.getId());
        }

        if (vlrl.getRgla().getTipo() == ReglaTipo.T) {
            FieldValidator.validateRequired(this, MessageI18nKey.vlrd_valorBase, model.getValorBase());

            if (vlrl.getRgla().getEnti().getTipo() == TipoEntidad.S) {
                FieldValidator.validateRequired(this, MessageI18nKey.ssrv, model.getSsrv());

                if (!hasErrors()) {
                    FieldValidator.validateRequired(this, MessageI18nKey.ssrv, model.getSsrv().getId());
                }
            }
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.vlrd_importeBase, model.getImporteBase());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.vlrd_importe, model.getImporte());

    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the new vlrl
     */
    public void setVlrl(final ValoracionLineaVO value) {
        vlrl = value;
    }
}
