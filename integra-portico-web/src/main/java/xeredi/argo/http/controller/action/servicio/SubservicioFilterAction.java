package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioFilterAction.
 */
public final class SubservicioFilterAction extends ItemFilterAction<SubservicioCriterioVO, TipoSubservicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8222430396254969052L;

	/** The fecha vigencia. */
	@Getter
	@Setter
	private Date fechaVigencia;

	/** The subps. */
	@Getter
	private List<PuertoVO> prtoList;

	@Inject
	private EntidadProxyService entiProxy;

	@Inject
	private PuertoService prtoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificPrepareFilter() throws ApplicationException {
		enti = entiProxy.selectTpss(model.getEntiId());

		if (fechaVigencia == null) {
			fechaVigencia = Calendar.getInstance().getTime();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setSprtId(sprtId);
		prtoCriterio.setIdioma(getIdioma());

		prtoList = prtoService.selectList(prtoCriterio);
	}
}
