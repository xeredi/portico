package xeredi.argo.http.controller.action.administracion.configuration;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationListAction.
 */
public final class ConfigurationListAction extends ListAction<ConfigurationVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4157882341228986446L;

	/** The conf service. */
	@Inject
	private ConfigurationService confService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() {
		resultList = confService.selectList();
	}
}
