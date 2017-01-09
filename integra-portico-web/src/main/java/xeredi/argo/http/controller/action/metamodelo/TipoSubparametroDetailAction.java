package xeredi.argo.http.controller.action.metamodelo;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroDetailAction.
 */
public final class TipoSubparametroDetailAction extends EntidadDetailAction<TipoSubparametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8144616675066501877L;

	@Inject
	private TipoSubparametroService tpspService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		model = tpspService.select(model.getId(), getIdioma());
	}
}
