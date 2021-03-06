package xeredi.argo.http.controller.action.administracion.configuration;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationEditAction.
 */
public final class ConfigurationEditAction extends CrudEditAction<ConfigurationVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7232090855025643651L;

	/** The conf service. */
	@Inject
	private ConfigurationService confService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getKey());

		switch (accion) {
		case edit:
			model = confService.select(model.getKey());

			break;
		default:
			throw new Error("Accion no valida: " + accion);
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
