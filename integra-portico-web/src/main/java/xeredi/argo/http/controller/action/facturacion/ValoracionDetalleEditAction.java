package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleEditAction.
 */
public final class ValoracionDetalleEditAction extends CrudEditAction<ValoracionDetalleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2216528521567482950L;

	/** The vlrl. */
	@Getter
	private ValoracionLineaVO vlrl;

	/** The vlrl padre. */
	@Getter
	private ValoracionLineaVO vlrlPadre;

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
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getVlrcId());
		Preconditions.checkNotNull(model.getVlrlId());

		if (accion == AccionCodigo.edit) {
			Preconditions.checkNotNull(model.getId());

			model = vlrdService.select(model.getId(), getIdioma());
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
