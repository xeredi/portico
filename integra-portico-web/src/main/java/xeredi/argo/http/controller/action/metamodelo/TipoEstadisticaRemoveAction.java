package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaRemoveAction.
 */
public final class TipoEstadisticaRemoveAction extends CrudRemoveAction<TipoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8551997472365097343L;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		tpesService.delete(model);
	}
}
