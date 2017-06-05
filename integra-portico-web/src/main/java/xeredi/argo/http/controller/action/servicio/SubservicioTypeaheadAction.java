package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTypeaheadAction.
 */
public final class SubservicioTypeaheadAction extends ItemTypeaheadAction<SubservicioLupaCriterioVO, SubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5330875855344902234L;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificTypeahead() throws ApplicationException {
		Preconditions.checkNotNull(model.getSrvcId());

		final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

		resultList = ssrvService.selectTypeaheadList(model, limit);
	}
}
