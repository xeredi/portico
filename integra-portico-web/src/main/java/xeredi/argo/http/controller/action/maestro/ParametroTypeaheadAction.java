package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadAction.
 */
public final class ParametroTypeaheadAction extends ItemTypeaheadAction<ParametroCriterioVO, ParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7639038275412903995L;

	@Inject
	private ParametroService prmtService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doSpecificTypeahead() throws ApplicationException {
		final TipoParametroDetailVO entiDetail = entiProxy.selectTppr(model.getEntiId());

		if (entiDetail.getEnti().getPuerto()) {
			Preconditions.checkNotNull(model.getPrto());
			Preconditions.checkNotNull(model.getPrto().getId());
		}

		if (model.getFechaVigencia() == null) {
			model.setFechaVigencia(Calendar.getInstance().getTime());
		}

		resultList = prmtService.selectTypeaheadList(model, limit);
	}
}
