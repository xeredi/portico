package xeredi.argo.http.controller.action.servicio.suministrored;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.vo.ServicioMaestroCriterioVO;
import xeredi.argo.proceso.servicio.suministrored.ProcesoSuministroRed;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new generate save action.
 */
public final class GenerarSaveAction extends CrudSaveAction<ServicioMaestroCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8629569795665372129L;

	@Inject
	private ProcesoService prbtService;

	@Inject
	private ConfigurationProxyService confProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final Map<String, String> parametroMap = new HashMap<>();
		final SimpleDateFormat format = new SimpleDateFormat(confProxy.getString(ConfigurationKey.date_format));

		parametroMap.put(ProcesoSuministroRed.params.ffin.name(), format.format(model.getFfin()));

		prbtService.crear(getUsroId(), ProcesoTipo.SRED_CREACION, parametroMap, null, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		FieldValidator.validateRequired(this, MessageI18nKey.srms_ffin, model.getFfin());
	}

}
