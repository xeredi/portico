package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloDetailAction.
 */
public final class ModuloDetailAction extends CrudDetailAction<ModuloVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 696320810765547190L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The grpo list. */
	@Getter
	private List<GrupoVO> grpoList;

	@Inject
	private ModuloService mdloService;

	@Inject
	private GrupoService grpoService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = mdloService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);

		final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

		grpoCriterio.setFncdId(model.getId());
		grpoCriterio.setIdioma(getIdioma());

		grpoList = grpoService.selectList(grpoCriterio);
	}
}
