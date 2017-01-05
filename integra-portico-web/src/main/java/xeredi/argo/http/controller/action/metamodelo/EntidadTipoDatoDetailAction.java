package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoDetailAction.
 */
public final class EntidadTipoDatoDetailAction extends CrudDetailAction<EntidadTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6085148921599533885L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private I18nService i18nService;

	@Inject
	private EntidadTipoDatoService entdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = entdService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
