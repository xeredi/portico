package xeredi.argo.http.controller.action.estadistica;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoSaveAction.
 */
public final class PeriodoProcesoSaveAction extends CrudSaveAction<ProcesoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 230657854894847117L;

	@Inject
	private SuperpuertoService sprtService;

	@Inject
	private ArchivoService archService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final SuperpuertoVO sprt = sprtService.select(model.getPepr().getSprt().getId(), getIdioma());

		final ProcesoBO prbtBO = new ProcesoBO();
		final Map<String, String> parametroMap = new HashMap<>();

		parametroMap.put(ProcesoCargaOppe.params.autp.name(), sprt.getCodigo());
		parametroMap.put(ProcesoCargaOppe.params.anio.name(), model.getPepr().getAnio().toString());
		parametroMap.put(ProcesoCargaOppe.params.mes.name(), model.getPepr().getMes().toString());
		parametroMap.put(ProcesoCargaOppe.params.sobreescribir.name(), model.getSobreescribir().toString());

		switch (accion) {
		case load:
			final String foldername = ConfigurationProxy
					.getString(ConfigurationKey.estadistica_files_oppe_entrada_home);
			final String filepath = foldername + "/" + model.getPepr().getFilename() + ".zip";
			final File file = new File(filepath);

			final ArchivoVO arch = archService.create(file, ArchivoSentido.E);

			prbtBO.crear(SessionManager.getUsroId(), ProcesoTipo.EST_CARGA, parametroMap, ItemTipo.arch,
					Arrays.asList(arch.getArin().getId()));

			break;
		case create:
			prbtBO.crear(SessionManager.getUsroId(), ProcesoTipo.EST_CREACION, parametroMap, null, null);

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
		FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getPepr().getSprt());

		if (!hasErrors()) {
			FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getPepr().getSprt().getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, model.getPepr().getAnio());
		FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, model.getPepr().getMes());
		FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, model.getSobreescribir());
	}
}
