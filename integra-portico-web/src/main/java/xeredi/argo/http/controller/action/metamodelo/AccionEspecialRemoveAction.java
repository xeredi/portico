package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialRemoveAction.
 */
@Data
public final class AccionEspecialRemoveAction extends CrudRemoveAction<AccionEspecialVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3638404948238880930L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.aces;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final AccionEspecialBO acesBO = new AccionEspecialBO();

		acesBO.delete(model);
	}
}
