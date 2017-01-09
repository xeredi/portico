package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleSaveAction.
 */
public final class ValoracionDetalleSaveAction extends CrudSaveAction<ValoracionDetalleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1354136282476244950L;

	/** The vlrl. */
	@Getter
	private ValoracionLineaVO vlrl;

	@Inject
	private ValoracionDetalleService vlrdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			vlrdService.insert(model);

			break;
		case edit:
			vlrdService.update(model);

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
