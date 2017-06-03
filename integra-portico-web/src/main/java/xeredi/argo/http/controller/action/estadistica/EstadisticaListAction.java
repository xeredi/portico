package xeredi.argo.http.controller.action.estadistica;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.service.EstadisticaService;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaListAction.
 */
public final class EstadisticaListAction
		extends ItemListAction<EstadisticaCriterioVO, EstadisticaVO, TipoEstadisticaDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1284436845357248301L;

	@Inject
	private EstadisticaService estdService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificList() throws ApplicationException {
		Preconditions.checkNotNull(model.getPepr());
		Preconditions.checkNotNull(model.getPepr().getId());
		Preconditions.checkNotNull(model.getPepr().getSprtId());

		enti = entiProxy.selectTpes(model.getEntiId());
		resultList = estdService.selectList(model, getOffset(), limit);
	}
}
