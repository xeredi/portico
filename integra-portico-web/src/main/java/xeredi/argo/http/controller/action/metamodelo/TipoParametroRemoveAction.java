package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroRemoveAction.
 */
public final class TipoParametroRemoveAction extends CrudRemoveAction<TipoParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5117314548397691124L;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		tpprService.delete(model);
	}
}
