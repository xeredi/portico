package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoService;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailAction.
 */
public final class TramiteDetailAction extends CrudDetailAction<TramiteVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8184203973522067742L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The enti. */
	@Getter
	private EntidadVO enti;

	/** The trtd list. */
	@Getter
	private List<TramiteTipoDatoVO> trtdList;

	@Inject
	private EntidadService entiService;

	@Inject
	private TramiteService trmtService;

	@Inject
	private I18nService i18nService;

	@Inject
	private TramiteTipoDatoService trtdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = trmtService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
		enti = entiService.select(model.getEntiId(), getIdioma());

		final TramiteTipoDatoCriterioVO trtdCriterio = new TramiteTipoDatoCriterioVO();

		trtdCriterio.setTrmtId(model.getId());
		trtdCriterio.setIdioma(getIdioma());

		trtdList = trtdService.selectList(trtdCriterio);
	}
}
