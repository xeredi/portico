package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaAnulacionVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAnulacionEditAction.
 */
public final class FacturaAnulacionEditAction extends CrudEditAction<FacturaAnulacionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3480470491984180806L;

	/** The fcsr list. */
	@Getter
	private List<FacturaSerieVO> fcsrList;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getFctrId());

		final FacturaBO fctrBO = new FacturaBO();
		final FacturaVO fctr = fctrBO.select(model.getFctrId(), getIdioma());

		model.setFecha(Calendar.getInstance().getTime());
		model.setFcsrId(fctr.getFcsr().getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

		fcsrCriterio.setAnio(Calendar.getInstance().get(Calendar.YEAR));

		fcsrList = fcsrService.selectList(fcsrCriterio);
	}
}
