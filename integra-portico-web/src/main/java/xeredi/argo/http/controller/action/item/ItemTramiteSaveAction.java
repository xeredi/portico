package xeredi.argo.http.controller.action.item;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteSaveAction.
 */
public final class ItemTramiteSaveAction extends BaseAction implements FuncionalidadAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1629906671936657593L;

	/** The model. */
	@Setter
	protected ItemTramiteVO model;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	/** The ssrv factory. */
	@Inject
	private SubservicioServiceFactory ssrvFactory;

	@Inject
	private TramiteProxyService trmtProxy;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() throws ApplicationException {
		final AbstractEntidadDetailVO enti = entiProxy.select(model.getTrmt().getEntiId());

		doValidate();

		if (!hasErrors()) {
			switch (enti.getEnti().getTipo()) {
			case T:
				final ServicioService srvcService = srvcFactory.getInstance(model.getTrmt().getEntiId(), usroId);

				srvcService.statechange(model);

				break;
			case S:
				final SubservicioService ssrvService = ssrvFactory.getInstance(model.getTrmt().getEntiId(), usroId);

				ssrvService.statechange(model);

				break;
			case P:
				throw new Error("No implementado!!");
			default:
				throw new Error("Invalid entity type: " + enti.getEnti().getTipo());
			}
		}
	}

	/**
	 * Do validate.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getItemId());
		Preconditions.checkNotNull(model.getTrmt());
		Preconditions.checkNotNull(model.getTrmt().getId());
		Preconditions.checkNotNull(model.getTrmt().getEntiId());

		final TramiteDetailVO trmt = trmtProxy.select(model.getTrmt().getId());
		final AbstractEntidadDetailVO enti = entiProxy.select(model.getTrmt().getEntiId());

		switch (enti.getEnti().getTipo()) {
		case T:
			final TipoServicioDetailVO tpsr = (TipoServicioDetailVO) entiProxy.select(model.getTrmt().getEntiId());

			if (tpsr.getEnti().isTemporal()) {
				FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getDitemFini());
				FieldValidator.validatePeriod(this, model.getDitemFini(), model.getDitemFfin());
			}

			break;
		case S:
			final TipoSubservicioDetailVO tpss = (TipoSubservicioDetailVO) entiProxy
					.select(model.getTrmt().getEntiId());

			if (tpss.getEnti().isTemporal()) {
				FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getDitemFini());
				FieldValidator.validatePeriod(this, model.getDitemFini(), model.getDitemFfin());
			}

			break;
		case P:
			throw new Error("No implementado!!");
		default:
			throw new Error("Invalid entity type: " + enti.getEnti().getTipo());
		}

		FieldValidator.validateTrmt(this, enti, trmt, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getFncdId() {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getTrmt());
		Preconditions.checkNotNull(model.getTrmt().getId());

		return model.getTrmt().getId();
	}
}
