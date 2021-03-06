package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioSaveAction.
 */
public final class SubservicioSaveAction extends ItemSaveAction<SubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7087277709727877248L;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

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
		final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

		switch (accion) {
		case create:
			ssrvService.insert(model, enti, null);

			break;
		case edit:
			ssrvService.update(model);

			break;
		case duplicate:
			ssrvService.duplicate(model);

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}
}
