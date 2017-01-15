package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioFilterAction.
 */
public final class ServicioFilterAction extends ItemFilterAction<ServicioCriterioVO, TipoServicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1880833298596581117L;

	/** The subps. */
	@Getter
	private List<PuertoVO> prtoList;

	/** The fecha vigencia. */
	@Getter
	@Setter
	private Date fechaVigencia;

	@Inject
	private PuertoService prtoService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificPrepareFilter() throws ApplicationException {
		enti = entiProxy.selectTpsr(model.getEntiId());

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
