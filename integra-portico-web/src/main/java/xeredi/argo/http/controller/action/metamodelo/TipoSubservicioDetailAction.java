package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioDetailAction.
 */
public final class TipoSubservicioDetailAction extends EntidadDetailAction<TipoSubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2106629104252322129L;

	/** The enti hijas list. */
	@Getter
	private List<EntidadVO> entiHijasList;

	/** The enti padres list. */
	@Getter
	private List<EntidadVO> entiPadresList;

	/** The trmt list. */
	@Getter
	private List<TramiteVO> trmtList;

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
		model = tpssService.select(model.getId(), getIdioma());

		{
			final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

			entiCriterio.setEntiPadreId(model.getId());
			entiCriterio.setIdioma(getIdioma());

			entiHijasList = entiService.selectList(entiCriterio);
		}

		{
			final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

			entiCriterio.setEntiHijaId(model.getId());
			entiCriterio.setIdioma(getIdioma());

			entiPadresList = entiService.selectList(entiCriterio);
		}

		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setEntiId(model.getId());
		trmtCriterio.setIdioma(getIdioma());

		trmtList = trmtService.selectList(trmtCriterio);
	}
}
