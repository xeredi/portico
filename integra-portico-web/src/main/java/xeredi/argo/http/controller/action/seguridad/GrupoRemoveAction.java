package xeredi.argo.http.controller.action.seguridad;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.vo.GrupoVO;

/**
 * The Class GrupoRemoveAction.
 */
public final class GrupoRemoveAction extends CrudRemoveAction<GrupoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3464408300660789661L;

	@Inject
	private GrupoService grpoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		grpoService.delete(model);
	}
}
