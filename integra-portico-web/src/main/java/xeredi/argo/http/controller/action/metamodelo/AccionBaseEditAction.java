package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseEditAction.
 */
public final class AccionBaseEditAction extends CrudEditAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 182459317575847660L;

	/** The acpr list. */
	@Getter
	private ClassPrefix[] acprList;

	/** The acco list. */
	@Getter
	private AccionCodigo[] accoList;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new AccionBaseVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = acbsService.select(model.getId());
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
