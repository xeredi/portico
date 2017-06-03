package xeredi.argo.http.controller.action.administracion.puerto;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoListAction.
 */
public final class PuertoListAction extends GridListAction<PuertoCriterioVO, PuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1750952015496111173L;

	/** The prto service. */
	@Inject
	private PuertoService prtoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = prtoService.selectList(model, getOffset(), limit);
	}
}
