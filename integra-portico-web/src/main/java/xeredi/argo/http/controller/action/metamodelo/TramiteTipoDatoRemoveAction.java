package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoRemoveAction.
 */
public class TramiteTipoDatoRemoveAction extends CrudRemoveAction<TramiteTipoDatoVO> {

	/** The accn prefix. */
    @Getter
    private final AccionPrefix accnPrefix = AccionPrefix.trtd;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2770546691792502051L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getTrmtId());
		Preconditions.checkNotNull(model.getEntd());
		Preconditions.checkNotNull(model.getEntd().getTpdt());
		Preconditions.checkNotNull(model.getEntd().getTpdt().getId());

		final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();

		trtdBO.delete(model);
	}
}
