package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoSaveAction.
 */
public final class EntidadTipoDatoSaveAction extends CrudSaveAction<EntidadTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6877738229315027201L;

	/** The i18n map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private EntidadTipoDatoService entdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			entdService.insert(model, i18nMap);

			break;
		case edit:
			entdService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no contemplada: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.tpdt, model.getTpdt());
		} else {
			Preconditions.checkNotNull(model.getTpdt());
			Preconditions.checkNotNull(model.getTpdt().getId());
		}

		FieldValidator.validateI18n(this, i18nMap);

		FieldValidator.validateRequired(this, MessageI18nKey.entd_grupo, model.getGrupo());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_fila, model.getFila());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_orden, model.getOrden());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_span, model.getSpan());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_spanLg, model.getSpanLg());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_obligatorio, model.getObligatorio());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_gridable, model.getGridable());
		FieldValidator.validateRequired(this, MessageI18nKey.entd_filtrable, model.getFiltrable());

		FieldValidator.validateValidacion(this, MessageI18nKey.entd_validacion, model.getValidacion());
	}
}
