package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleDetailAction.
 */
public final class ValoracionDetalleDetailAction extends CrudDetailAction<ValoracionDetalleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 340743883680134402L;

	/** The vlrl. */
	@Getter
	private ValoracionLineaVO vlrl;

	/** The vlrl padre. */
	@Getter
	private ValoracionLineaVO vlrlPadre;

	/** The vlrd hijos list. */
	@Getter
	private List<ValoracionDetalleVO> vlrdHijosList;

	/** The aspc. */
	@Getter
	private AspectoVO aspc;

	@Inject
	private AspectoService aspcService;

	@Inject
	private ValoracionLineaService vlrlService;

	@Inject
	private ValoracionDetalleService vlrdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = vlrdService.select(model.getId(), getIdioma());

		// Busqueda de lineas hijas (coef/bonif)
		if (model.getRgla().getTipo() == ReglaTipo.T) {
			final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

			vlrdCriterio.setPadreId(model.getId());
			vlrdCriterio.setIdioma(getIdioma());
			vlrdCriterio.setSoloHijos(true);

			vlrdHijosList = vlrdService.selectList(vlrdCriterio);
		}

		final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

		vlrlCriterio.setId(model.getVlrlId());
		vlrlCriterio.setIdioma(getIdioma());

		vlrl = vlrlService.selectObject(vlrlCriterio);

		if (vlrl.getId() == vlrl.getPadreId()) {
			vlrlPadre = vlrl;
		} else {
			final ValoracionLineaCriterioVO vlrlPadreCriterio = new ValoracionLineaCriterioVO();

			vlrlPadreCriterio.setId(vlrl.getPadreId());
			vlrlPadreCriterio.setIdioma(getIdioma());

			vlrlPadre = vlrlService.selectObject(vlrlPadreCriterio);
		}

		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setVlrcId(model.getVlrcId());
		aspcCriterio.setIdioma(getIdioma());

		aspc = aspcService.selectObject(aspcCriterio);
	}
}
