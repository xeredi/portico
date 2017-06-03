package xeredi.argo.http.controller.action.proceso;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeListAction.
 */
public final class ProcesoMensajeListAction extends GridListAction<ProcesoMensajeCriterioVO, ProcesoMensajeVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5625987046816994729L;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		Preconditions.checkNotNull(model.getPrbtId());

		resultList = prbtService.selectPrmnList(model, getOffset(), limit);
	}
}
