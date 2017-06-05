package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioListAction.
 */
public final class SubservicioListAction
		extends ItemListAction<SubservicioCriterioVO, SubservicioVO, TipoSubservicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7791150298212933914L;

	/** The ssrv factory. */
	@Inject
	private SubservicioServiceFactory ssrvFactory;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificList() throws ApplicationException {
		enti = entiProxy.selectTpss(model.getEntiId());

		final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

		resultList = ssrvService.selectList(model, getOffset(), limit);
	}
}
