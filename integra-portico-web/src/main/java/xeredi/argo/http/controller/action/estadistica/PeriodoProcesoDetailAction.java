package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoDetailAction.
 */
public final class PeriodoProcesoDetailAction extends CrudDetailAction<PeriodoProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4868698080267704484L;

	/** The tpes list. */
	@Getter
	private List<LabelValueVO> tpesList;

	@Inject
	private PeriodoProcesoService peprService;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = peprService.select(model.getId(), getIdioma());
		tpesList = tpesService.selectLabelValues(new TipoEstadisticaCriterioVO());
	}
}
