package xeredi.argo.http.controller.action.administracion.configuration;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationDetailAction.
 */
public final class ConfigurationDetailAction extends CrudDetailAction<ConfigurationVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 614441828114934645L;

	/** The conf service. */
	@Inject
	private ConfigurationService confService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getKey());

		model = confService.select(model.getKey());
	}
}
