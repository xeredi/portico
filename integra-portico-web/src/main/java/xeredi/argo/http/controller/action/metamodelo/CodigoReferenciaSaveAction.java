package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

/**
 * Grabación de un Código de Referencia.
 */
public final class CodigoReferenciaSaveAction extends CrudSaveAction<CodigoReferenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8704360630485075850L;

	/** The cdri map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private CodigoReferenciaService cdrfService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			cdrfService.insert(model, i18nMap);

			break;
		case edit:
			cdrfService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no implementada: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpdtId());
		Preconditions.checkNotNull(i18nMap);

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.cdrf_valor, model.getValor());
		} else {
			Preconditions.checkNotNull(model.getId());
			Preconditions.checkNotNull(model.getValor());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.cdrf_orden, model.getOrden());
		FieldValidator.validateI18n(this, i18nMap);
	}
}
