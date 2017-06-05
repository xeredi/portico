package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.servicio.service.ServicioSecuenciaService;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaEditAction.
 */
public final class ServicioSecuenciaEditAction extends CrudEditAction<ServicioSecuenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7265649887754786022L;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	/** The tpsr list. */
	@Getter
	private List<TipoServicioVO> tpsrList;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private ServicioSecuenciaService srscService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			Preconditions.checkNotNull(model.getPrto());
			Preconditions.checkNotNull(model.getPrto().getId());
			Preconditions.checkNotNull(model.getTpsr());
			Preconditions.checkNotNull(model.getTpsr().getId());
			Preconditions.checkNotNull(model.getAnno());

			final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

			srscCriterio.setPrtoId(model.getPrto().getId());
			srscCriterio.setTpsrId(model.getTpsr().getId());
			srscCriterio.setAnno(model.getAnno());
			srscCriterio.setIdioma(getIdioma());

			model = srscService.select(srscCriterio);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setIdioma(getIdioma());
		prtoCriterio.setSprtId(getSprtId());

		prtoList = prtoService.selectList(prtoCriterio);

		final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

		tpsrCriterio.setIdioma(getIdioma());

		tpsrList = tpsrService.selectList(tpsrCriterio);
	}
}
