package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturadorVO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoTipo;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorEditAction.
 */
public final class FacturadorEditAction extends CrudEditAction<FacturadorVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1389260062489112937L;

	/** The fcsr list. */
	@Getter
	private List<FacturaSerieVO> fcsrList;

	/** The tpsr list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	@Getter
	private ValoracionGrupoTipo[] grupoTipoList;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model);

		model.setFecha(Calendar.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getFecha());

		final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

		fcsrCriterio.setAnio(model.getFecha().get(Calendar.YEAR));

		fcsrList = fcsrService.selectList(fcsrCriterio);
		grupoTipoList = ValoracionGrupoTipo.values();

		if (model.getVlrcId() == null) {
			tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());

			final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

			prtoCriterio.setIdioma(getIdioma());

			prtoList = prtoService.selectList(prtoCriterio);
		}
	}
}
