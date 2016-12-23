package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoDetailAction.
 */
public final class SuperpuertoDetailAction extends CrudDetailAction<SuperpuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3768153475557841666L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private SuperpuertoService sprtService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = sprtService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
