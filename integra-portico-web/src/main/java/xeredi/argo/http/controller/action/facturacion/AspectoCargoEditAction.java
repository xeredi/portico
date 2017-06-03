package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoEditAction.
 */
public final class AspectoCargoEditAction extends CrudEditAction<AspectoCargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1292421221150084862L;

	/** The crgo list. */
	@Getter
	private List<CargoVO> crgoList;

	@Inject
	private AspectoService aspcService;

	@Inject
	private AspectoCargoService ascrService;

	@Inject
	private CargoService crgoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getAspcId());
		} else {
			Preconditions.checkNotNull(model.getId());

			model = ascrService.select(model.getId(), model.getFref(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getAspcId());

			final AspectoVO aspc = aspcService.select(model.getAspcId(), model.getFref(), getIdioma());

			final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

			crgoCriterio.setTpsrId(aspc.getTpsr().getId());
			crgoCriterio.setFechaVigencia(model.getFref());
			crgoCriterio.setIdioma(getIdioma());

			crgoList = crgoService.selectList(crgoCriterio);
		}
	}
}
