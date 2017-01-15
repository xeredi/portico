package xeredi.argo.http.controller.action.servicio;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioSaveAction.
 */
public final class SubservicioSaveAction extends ItemSaveAction<SubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7087277709727877248L;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		final TipoSubservicioDetailVO enti = entiProxy.selectTpss(model.getEntiId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.srvc, model.getSrvc());
			FieldValidator.validateRequired(this, MessageI18nKey.ssrv_numero, model.getNumero());
		} else {
			Preconditions.checkNotNull(model.getId());
			Preconditions.checkNotNull(model.getSrvc());
			Preconditions.checkNotNull(model.getSrvc().getId());
			Preconditions.checkNotNull(model.getNumero());
		}

		if (enti.getEnti().getTpdtEstado() != null) {
			FieldValidator.validateRequired(this, MessageI18nKey.ssrv_estado, model.getEstado());
		}

		if (enti.getEnti().isTemporal()) {
			FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getFini());
			FieldValidator.validateRequired(this, MessageI18nKey.ffin, model.getFfin());
		}

		FieldValidator.validateItem(this, enti, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final TipoSubservicioDetailVO enti = entiProxy.selectTpss(model.getEntiId());
		final SubservicioBO itemBO = SubservicioBOFactory.newInstance(model.getEntiId(), usroId);

		switch (accion) {
		case create:
			itemBO.insert(model, enti, null);

			break;
		case edit:
			itemBO.update(model);

			break;
		case duplicate:
			itemBO.duplicate(model);

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}
}
