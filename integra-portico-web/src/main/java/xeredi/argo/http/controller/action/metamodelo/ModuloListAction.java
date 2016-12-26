package xeredi.argo.http.controller.action.metamodelo;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloListAction.
 */
public final class ModuloListAction extends GridListAction<ModuloCriterioVO, ModuloVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7287670605906578392L;

	@Inject
	private ModuloService mdloService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = mdloService.selectList(model, getOffset(), limit);
	}
}
