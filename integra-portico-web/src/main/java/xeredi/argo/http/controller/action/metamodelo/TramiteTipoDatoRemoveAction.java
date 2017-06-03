package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoService;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoRemoveAction.
 */
public class TramiteTipoDatoRemoveAction extends CrudRemoveAction<TramiteTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2770546691792502051L;

	@Inject
	private TramiteTipoDatoService trtdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getTrmtId());
		Preconditions.checkNotNull(model.getEntd());
		Preconditions.checkNotNull(model.getEntd().getTpdt());
		Preconditions.checkNotNull(model.getEntd().getTpdt().getId());

		trtdService.delete(model);
	}
}
