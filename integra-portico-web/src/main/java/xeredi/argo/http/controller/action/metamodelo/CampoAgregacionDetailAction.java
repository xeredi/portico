package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.CampoAgregacionService;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionDetailAction.
 */
public final class CampoAgregacionDetailAction extends CrudDetailAction<CampoAgregacionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7449645197472409959L;

	@Inject
	private CampoAgregacionService cmagService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpesId());
		Preconditions.checkNotNull(model.getEntd());
		Preconditions.checkNotNull(model.getEntd().getId());

		model = cmagService.select(model.getTpesId(), model.getEntd().getId(), getIdioma());
	}
}
