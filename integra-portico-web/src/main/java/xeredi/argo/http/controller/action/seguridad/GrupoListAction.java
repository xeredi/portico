package xeredi.argo.http.controller.action.seguridad;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoListAction.
 */
public final class GrupoListAction extends GridListAction<GrupoCriterioVO, GrupoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5074804383452913721L;

	/** The grpo service. */
	@Inject
	private GrupoService grpoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = grpoService.selectList(model, getOffset(), limit);
	}
}
