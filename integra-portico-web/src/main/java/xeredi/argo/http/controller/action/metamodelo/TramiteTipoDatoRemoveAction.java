package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoRemoveAction.
 */
@Data
public class TramiteTipoDatoRemoveAction extends CrudRemoveAction<TramiteTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2770546691792502051L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.trtd;

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
