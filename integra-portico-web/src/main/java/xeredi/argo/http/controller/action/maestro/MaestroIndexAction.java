package xeredi.argo.http.controller.action.maestro;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
public final class MaestroIndexAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6957331552111084410L;

	@Getter
	private List<LabelValueVO> resultList;

	@Inject
	private TipoParametroService tpprService;

	// Acciones web
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() {
		final TipoParametroCriterioVO tpprCriterio = new TipoParametroCriterioVO();

		resultList = tpprService.selectLabelValues(tpprCriterio);
	}
}
