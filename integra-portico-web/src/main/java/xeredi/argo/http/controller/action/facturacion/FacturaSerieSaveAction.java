package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * Accion Web de Almacenamiento de una Serie de Factura.
 */
public final class FacturaSerieSaveAction extends CrudSaveAction<FacturaSerieVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1166773054003527886L;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			fcsrService.insert(model);

			break;
		case edit:
			fcsrService.update(model);

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
