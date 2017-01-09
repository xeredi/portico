package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaSaveAction.
 */
public final class ValoracionLineaSaveAction extends CrudSaveAction<ValoracionLineaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2626755272488026780L;

	@Inject
	private ValoracionLineaService vlrlService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			vlrlService.insert(model);

			break;
		case edit:
			vlrlService.update(model);

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
