package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.servicio.service.ServicioSecuenciaService;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaSaveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServicioSecuenciaSaveAction extends CrudSaveAction<ServicioSecuenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7028594284567884292L;

	@Inject
	private ServicioSecuenciaService srscService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			srscService.insert(model);

			break;
		case edit:
			srscService.update(model);

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
		switch (accion) {
		case create:
			FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());
			FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr().getId());
				FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
			}

			FieldValidator.validateRequired(this, MessageI18nKey.srsc_anno, model.getAnno());

			break;
		case edit:
			Preconditions.checkNotNull(model);
			Preconditions.checkNotNull(model.getPrto());
			Preconditions.checkNotNull(model.getPrto().getId());
			Preconditions.checkNotNull(model.getTpsr());
			Preconditions.checkNotNull(model.getTpsr().getId());
			Preconditions.checkNotNull(model.getAnno());

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}

		FieldValidator.validateRequired(this, MessageI18nKey.srsc_ultimo_numero, model.getUltimoNumero());
	}
}
