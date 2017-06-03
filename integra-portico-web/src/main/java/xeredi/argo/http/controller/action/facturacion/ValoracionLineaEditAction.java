package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaEditAction.
 */
public final class ValoracionLineaEditAction extends CrudEditAction<ValoracionLineaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1498921008270553150L;

	/** The vlrl padre. */
	@Getter
	private ValoracionLineaVO vlrlPadre;

	/** The aspc. */
	@Getter
	private AspectoVO aspc;

	/** The impuesto list. */
	@Getter
	private List<ParametroVO> impuestoList;

	@Inject
	private ParametroService prmtService;

	@Inject
	private AspectoService aspcService;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private ValoracionLineaService vlrlService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getVlrcId());

		switch (accion) {
		case create:
			final ValoracionVO vlrc = vlrcService.select(model.getVlrcId(), getIdioma());

			model.setFref(vlrc.getFref());

			break;
		case edit:
			Preconditions.checkNotNull(model.getId());

		{
			final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

			vlrlCriterio.setId(model.getId());
			vlrlCriterio.setIdioma(getIdioma());

			model = vlrlService.selectObject(vlrlCriterio);
		}

			if (model.getId() == model.getPadreId()) {
				vlrlPadre = model;
			} else {
				final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

				vlrlCriterio.setId(model.getPadreId());
				vlrlCriterio.setIdioma(getIdioma());

				vlrlPadre = vlrlService.selectObject(vlrlCriterio);
			}

			break;
		default:
			throw new Error("Accion no valida: " + accion);
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
		Preconditions.checkNotNull(model.getFref());

		final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

		prmtCriterio.setEntiId(Entidad.TIPO_IVA.getId());
		prmtCriterio.setFechaVigencia(model.getFref());
		prmtCriterio.setIdioma(getIdioma());

		impuestoList = prmtService.selectList(prmtCriterio);
	}
}
