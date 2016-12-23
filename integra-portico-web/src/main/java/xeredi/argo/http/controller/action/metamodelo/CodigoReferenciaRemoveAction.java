package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaService;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * Borrado de un Código de Referencia.
 */
public final class CodigoReferenciaRemoveAction extends CrudRemoveAction<CodigoReferenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7405842967831298726L;

	@Inject
	private CodigoReferenciaService cdrfService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		cdrfService.delete(model);
	}
}
