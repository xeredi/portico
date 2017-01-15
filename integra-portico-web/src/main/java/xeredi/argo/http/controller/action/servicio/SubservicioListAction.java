package xeredi.argo.http.controller.action.servicio;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
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

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificList() throws ApplicationException {
		enti = entiProxy.selectTpss(model.getEntiId());

		final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId(), usroId);

		resultList = ssrvBO.selectList(model, getOffset(), limit);
	}
}
