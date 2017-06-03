package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioDetailAction.
 */
public final class TipoServicioDetailAction extends EntidadDetailAction<TipoServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3574420037025529065L;

	/** The tpss list. */
	@Getter
	private List<TipoSubservicioVO> subentiList;

	/** The enti hijas list. */
	@Getter
	private List<EntidadVO> entiHijasList;

	/** The trmt list. */
	@Getter
	private List<TramiteVO> trmtList;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private EntidadService entiService;

	@Inject
	private TramiteService trmtService;

	@Inject
	private TipoSubservicioService tpssService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		model = tpsrService.select(model.getId(), getIdioma());

		final TipoSubservicioCriterioVO tpssCriterio = new TipoSubservicioCriterioVO();

		tpssCriterio.setTpsrId(model.getId());
		tpssCriterio.setIdioma(getIdioma());

		subentiList = tpssService.selectList(tpssCriterio);

		if (subentiList != null && !subentiList.isEmpty()) {
			final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

			entiCriterio.setEntiPadreId(model.getId());
			entiCriterio.setIdioma(getIdioma());

			entiHijasList = entiService.selectList(entiCriterio);
		}

		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setEntiId(model.getId());
		trmtCriterio.setIdioma(getIdioma());

		trmtList = trmtService.selectList(trmtCriterio);
	}
}
