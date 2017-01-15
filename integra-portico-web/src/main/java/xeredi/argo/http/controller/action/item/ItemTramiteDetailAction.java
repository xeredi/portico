package xeredi.argo.http.controller.action.item;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.service.ItemTramiteService;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteDetailAction.
 */

/**
 * Instantiates a new item tramite detail action.
 */
public final class ItemTramiteDetailAction extends BaseAction
		implements ModelDriven<ItemTramiteVO>, ProtectedItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2680320980030804227L;

	/** The accion. */
	@Getter
	protected final AccionCodigo accion = AccionCodigo.ittrDetail;

	/** The model. */
	@Getter
	protected ItemTramiteVO model;

	/** The trmt. */
	@Getter
	protected TramiteDetailVO trmt;

	/** The enti. */
	@Getter
	protected AbstractEntidadDetailVO enti;

	/** The item. */
	@Getter
	protected ItemVO item;

	@Inject
	private ItemTramiteService ittrService;

	@Inject
	private TramiteProxyService trmtProxy;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() throws ApplicationException {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getId());

		model = ittrService.select(model.getId(), getIdioma());
		trmt = trmtProxy.select(model.getTrmt().getId());

		enti = entiProxy.select(model.getTrmt().getEntiId());

		switch (enti.getEnti().getTipo()) {
		case T:
			final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getEnti().getId(), usroId);
			final ServicioVO srvc = srvcBO.select(model.getItemId(), getIdioma());

			item = srvc;

			break;
		case S:
			final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(enti.getEnti().getId(), usroId);
			final SubservicioVO ssrv = ssrvBO.select(model.getItemId(), getIdioma());

			item = ssrv;

			break;
		case P:
			throw new Error("No implementado!!");
		default:
			throw new Error("Invalid entity type: " + enti.getEnti().getTipo());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long getEntiId() {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getTrmt());
		Preconditions.checkNotNull(model.getTrmt().getEntiId());

		return model.getTrmt().getEntiId();
	}
}
