package xeredi.argo.http.controller.action.maestro;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroEditAction.
 */
public final class SubparametroEditAction extends ItemEditAction<SubparametroVO, TipoSubparametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6767667432126657718L;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	@Inject
	private SubparametroService sprmService;

	@Inject
	private ParametroService prmtService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getPrmtId());

		enti = entiProxy.selectTpsp(model.getEntiId());

		if (accion == AccionCodigo.create) {
			final ParametroVO prmt = prmtService.select(model.getPrmtId(), getIdioma(), model.getFref());

			if (prmt.getPrto() != null) {
				model.setPrtoId(prmt.getPrto().getId());
			}
		} else {
			model = sprmService.selectObject(model.getId(), getIdioma(), model.getFref());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadSpecificDependencies() throws ApplicationException {
		if (enti.getEnti().getTpprAsociado().getPuerto()) {
			final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

			prtoCriterio.setSprtId(getSprtId());
			prtoCriterio.setIdioma(getIdioma());

			prtoList = prtoService.selectList(prtoCriterio);
		}
	}
}
