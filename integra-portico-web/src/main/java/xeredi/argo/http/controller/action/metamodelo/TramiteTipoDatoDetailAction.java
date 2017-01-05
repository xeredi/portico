package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoService;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoDetailAction.
 */
public final class TramiteTipoDatoDetailAction extends CrudDetailAction<TramiteTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4066766450469953829L;

	@Inject
	private TramiteTipoDatoService trtdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getTrmtId());
		Preconditions.checkNotNull(model.getEntd());
		Preconditions.checkNotNull(model.getEntd().getTpdt().getId());

		model = trtdService.select(model.getTrmtId(), model.getEntd().getTpdt().getId(), getIdioma());
	}
}
