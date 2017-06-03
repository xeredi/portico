package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoEditAction.
 */
public final class SuperpuertoEditAction extends CrudEditAction<SuperpuertoVO> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2952897387558260349L;

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
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			model = sprtService.select(model.getId(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
