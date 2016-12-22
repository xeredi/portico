package xeredi.argo.http.controller.action.seguridad;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.GuiceInjector;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class UsuarioListAction extends GridListAction<UsuarioCriterioVO, UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3750518542645128408L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		final UsuarioService usroService = GuiceInjector.getInjector().getInstance(UsuarioService.class);

		resultList = usroService.selectList(model, getOffset(), limit);
	}
}
