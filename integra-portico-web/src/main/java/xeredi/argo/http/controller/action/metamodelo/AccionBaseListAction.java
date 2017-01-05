package xeredi.argo.http.controller.action.metamodelo;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseListAction.
 */
public final class AccionBaseListAction extends GridListAction<AccionBaseCriterioVO, AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8697939019605785607L;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = acbsService.selectList(model, getOffset(), limit);
	}
}
