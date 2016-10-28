package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseDetailAction.
 */
@Data
public final class AccionBaseDetailAction extends CrudDetailAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1098675557065003093L;

	   /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.acbs;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final AccionBaseBO acbsBO = new AccionBaseBO();
		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setId(model.getId());

		model = acbsBO.selectObject(acbsCriterio);
	}
}
