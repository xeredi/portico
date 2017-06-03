package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioRemoveAction.
 */
public final class TipoServicioRemoveAction extends CrudRemoveAction<TipoServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5096593722337875752L;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		tpsrService.delete(model);
	}
}
