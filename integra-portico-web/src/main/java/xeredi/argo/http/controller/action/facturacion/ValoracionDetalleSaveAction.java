package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ValoracionDetalleBO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleSaveAction.
 */
@Data
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
        final ValoracionDetalleBO vlrdBO = new ValoracionDetalleBO();

        switch (accion) {
        case create:
            vlrdBO.insert(model);

            break;
        case edit:
            vlrdBO.update(model);

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

        if (AccionCodigo.edit == accion) {
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
}
