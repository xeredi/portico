package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.CampoAgregacionService;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaDetailAction.
 */
public final class TipoEstadisticaDetailAction extends EntidadDetailAction<TipoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8074035967447249323L;

	/** The cmag list. */
	@Getter
	private List<CampoAgregacionVO> cmagList;

	@Inject
	private CampoAgregacionService cmagService;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		model = tpesService.select(model.getId(), getIdioma());

		final CampoAgregacionCriterioVO cmagCriterio = new CampoAgregacionCriterioVO();

		cmagCriterio.setTpesId(model.getId());
		cmagCriterio.setIdioma(getIdioma());

		cmagList = cmagService.selectList(cmagCriterio);
	}
}
