package xeredi.argo.http.controller.action.servicio.amarredep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.batch.amarredep.ProcesoAmarreDeportivo;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GenerarExecuteAction.
 */
public final class GenerarExecuteAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6959998927420303375L;

	/** The model. */
	@Setter
	private ServicioCriterioVO model;

	@Inject
	private ProcesoService prbtService;

	@Inject
	private ConfigurationProxyService confProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() throws ApplicationException {
		FieldValidator.validateRequired(this, MessageI18nKey.ffin, model.getFrefMax());

		if (!hasErrors()) {
			final Map<String, String> parametroMap = new HashMap<>();
			final DateFormat format = new SimpleDateFormat(confProxy.getString(ConfigurationKey.date_format));

			parametroMap.put(ProcesoAmarreDeportivo.params.ffin.name(), format.format(model.getFrefMax()));
			prbtService.crear(SessionManager.getUsroId(), ProcesoTipo.SAMD_CREACION, parametroMap, null, null);
		}
	}
}
