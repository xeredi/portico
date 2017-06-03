package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoListAction.
 */
public final class TipoDatoListAction extends GridListAction<TipoDatoCriterioVO, TipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2898524538399018227L;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = tpdtService.selectList(model, getOffset(), limit);
	}
}
