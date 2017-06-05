package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTypeaheadAction.
 */
public final class ServicioTypeaheadAction extends ItemTypeaheadAction<ServicioTypeaheadCriterioVO, ServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3651561999872993795L;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificTypeahead() throws ApplicationException {
		final ServicioService srvcService = srvcFactory.getInstance(model.getEntiId(), usroId);

		resultList = srvcService.selectTypeaheadList(model, limit);
	}
}
