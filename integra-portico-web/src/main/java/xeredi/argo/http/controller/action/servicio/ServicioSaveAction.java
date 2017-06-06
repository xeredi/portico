package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSaveAction.
 */
public final class ServicioSaveAction extends ItemSaveAction<ServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8100605830957326882L;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		final TipoServicioDetailVO enti = entiProxy.selectTpsr(model.getEntiId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());
			FieldValidator.validateRequired(this, MessageI18nKey.srvc_anno, model.getAnno());
			FieldValidator.validateRequired(this, MessageI18nKey.srvc_numero, model.getNumero());
		} else {
			Preconditions.checkNotNull(model.getId());
		}

		if (enti.getEnti().getTpdtEstado() != null) {
			FieldValidator.validateRequired(this, MessageI18nKey.srvc_estado, model.getEstado());
		}

		if (enti.getEnti().getTemporal()) {
			FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getFini());
			FieldValidator.validateRequired(this, MessageI18nKey.ffin, model.getFfin());

			// FIXME ¿Deberia estar en la clase de negocio?
			model.setFref(model.getFini());
		} else {
			FieldValidator.validateRequired(this, MessageI18nKey.fref, model.getFref());
		}

		FieldValidator.validateItem(this, enti, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		// FIXME ACABAR
		final ServicioService srvcService = srvcFactory.getInstance(model.getEntiId(), usroId);

		switch (accion) {
		case create:
			srvcService.insert(model, null, null, null);

			break;
		case edit:
			srvcService.update(model);

			break;
		case duplicate:
			srvcService.duplicate(model);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}
}
