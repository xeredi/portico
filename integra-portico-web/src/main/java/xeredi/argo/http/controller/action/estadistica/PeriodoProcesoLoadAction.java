package xeredi.argo.http.controller.action.estadistica;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudLoadAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoLoadFileSaveAction.
 */
public final class PeriodoProcesoLoadAction extends CrudLoadAction<ProcesoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5966692618549116508L;

	@Inject
	private ArchivoService archService;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doLoad() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model);

		FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, model.getSobreescribir());
		FieldValidator.validateRequired(this, MessageI18nKey.pepr_file, model.getArchId());

		if (!hasErrors()) {
			final ArchivoInfoVO arin = archService.select(model.getArchId());

			final Map<String, String> parametroMap = new HashMap<>();

			parametroMap.put(ProcesoCargaOppe.params.sobreescribir.name(), model.getSobreescribir().toString());
			parametroMap.put(ProcesoCargaOppe.params.autp.name(), arin.getNombre().substring(0, 2));
			parametroMap.put(ProcesoCargaOppe.params.anio.name(), arin.getNombre().substring(2, 6));
			parametroMap.put(ProcesoCargaOppe.params.mes.name(), arin.getNombre().substring(6, 8));

			prbtService.crear(SessionManager.getUsroId(), ProcesoTipo.EST_CARGA, parametroMap, ItemTipo.arch,
					Arrays.asList(model.getArchId()));
		}
	}
}
