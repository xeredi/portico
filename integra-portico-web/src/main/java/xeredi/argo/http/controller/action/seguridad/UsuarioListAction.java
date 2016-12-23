package xeredi.argo.http.controller.action.seguridad;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioListAction.
 */
public final class UsuarioListAction extends GridListAction<UsuarioCriterioVO, UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3750518542645128408L;

	/** The usro service. */
	@Inject
	private UsuarioService usroService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = usroService.selectList(model, getOffset(), limit);
	}
}
