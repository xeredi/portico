package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListAction.
 */
public final class TipoServicioListAction extends GridListAction<TipoServicioCriterioVO, TipoServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -334690081170777720L;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = tpsrService.selectList(model, getOffset(), limit);
	}
}
