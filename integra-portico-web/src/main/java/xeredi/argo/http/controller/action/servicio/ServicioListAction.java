package xeredi.argo.http.controller.action.servicio;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.OrderByElement.OrderByType;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioListAction.
 */
public final class ServicioListAction extends ItemListAction<ServicioCriterioVO, ServicioVO, TipoServicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1069829008412284361L;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificList() throws ApplicationException {
		enti = entiProxy.selectTpsr(model.getEntiId());

		if (model.getOrderByList().isEmpty()) {
			model.addOrderBy(ServicioCriterioVO.OrderByColumn.srvc_fref.name(), OrderByType.DESC);
		}

		final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId(), usroId);

		resultList = srvcBO.selectList(model, getOffset(), limit);
	}
}
