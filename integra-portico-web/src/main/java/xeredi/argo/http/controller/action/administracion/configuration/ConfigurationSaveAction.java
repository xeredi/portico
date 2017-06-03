package xeredi.argo.http.controller.action.administracion.configuration;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationSaveAction.
 */
public final class ConfigurationSaveAction extends CrudSaveAction<ConfigurationVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6903870337366067759L;

	/** The conf service. */
	@Inject
	private ConfigurationService confService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case edit:
			confService.update(model);

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getKey());
	}
}
