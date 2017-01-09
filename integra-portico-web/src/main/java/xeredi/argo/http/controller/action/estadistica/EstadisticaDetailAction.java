package xeredi.argo.http.controller.action.estadistica;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.service.EstadisticaService;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaDetailAction.
 */
public final class EstadisticaDetailAction extends ItemDetailAction<EstadisticaVO, TipoEstadisticaDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -375730466702517334L;

	@Inject
	private EstadisticaService estdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		enti = TipoEstadisticaProxy.select(model.getEntiId());
		model = estdService.select(model.getId(), getIdioma());
	}
}
