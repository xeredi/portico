package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoDetailAction.
 */
public final class PuertoDetailAction extends CrudDetailAction<PuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8390167251326279336L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private PuertoService prtoService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = prtoService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
