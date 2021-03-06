package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaService;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.FacturaRectificacionVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaRectificacionEditAction.
 */
public final class FacturaRectificacionEditAction extends CrudEditAction<FacturaRectificacionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9102133120619646073L;

	/** The vlrc list. */
	@Getter
	private List<ValoracionVO> vlrcList;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private FacturaService fctrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getFctrId());

		final FacturaVO fctr = fctrService.select(model.getFctrId(), getIdioma());
		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setFctr(fctr);
		vlrcCriterio.setIdioma(getIdioma());

		vlrcList = vlrcService.selectList(vlrcCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
