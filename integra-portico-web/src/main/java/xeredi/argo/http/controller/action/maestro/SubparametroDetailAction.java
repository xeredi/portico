package xeredi.argo.http.controller.action.maestro;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroDetailAction.
 */
public final class SubparametroDetailAction extends ItemDetailAction<SubparametroVO, TipoSubparametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4494947768754537198L;

	@Inject
	private SubparametroService sprmService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		model = sprmService.selectObject(model.getId(), getIdioma(), model.getFref());
		enti = entiProxy.selectTpsp(model.getEntiId());
	}
}
