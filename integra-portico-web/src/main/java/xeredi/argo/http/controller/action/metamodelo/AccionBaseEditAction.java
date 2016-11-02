package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseEditAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseEditAction extends CrudEditAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 182459317575847660L;

	/** The acpr list. */
	private ClassPrefix[] acprList;

	/** The acco list. */
	private AccionCodigo[] accoList;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new AccionBaseVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			final AccionBaseBO acbsBO = new AccionBaseBO();
			final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

			acbsCriterio.setId(model.getId());

			model = acbsBO.selectObject(acbsCriterio);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		accoList = AccionCodigo.values();
		acprList = ClassPrefix.values();
	}
}
