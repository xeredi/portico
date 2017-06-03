package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListAction.
 */
public final class TipoParametroListAction extends GridListAction<TipoParametroCriterioVO, TipoParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -417082160677321691L;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = tpprService.selectList(model, getOffset(), limit);
	}
}
