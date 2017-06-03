package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroRemoveAction.
 */
public final class TipoSubparametroRemoveAction extends CrudRemoveAction<TipoSubparametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2112505129384431410L;

	@Inject
	private TipoSubparametroService tpspService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		tpspService.delete(model);
	}
}
