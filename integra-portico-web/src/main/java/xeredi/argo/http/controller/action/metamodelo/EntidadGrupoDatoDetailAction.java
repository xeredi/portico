package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoService;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoDetailAction.
 */
public final class EntidadGrupoDatoDetailAction extends CrudDetailAction<EntidadGrupoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5264232903029377024L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private I18nService i18nService;

	@Inject
	private EntidadGrupoDatoService engdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = engdService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
