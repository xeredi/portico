package xeredi.argo.http.controller.action.servicio;

import java.io.IOException;
import java.util.Arrays;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudLoadAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.http.view.servicio.ProcesoServicioVO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLoadAction.
 */
public final class ServicioLoadAction extends CrudLoadAction<ProcesoServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1859425520777790834L;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doLoad() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model);

		FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getEntiId());
		FieldValidator.validateRequired(this, MessageI18nKey.arch, model.getArchId());

		if (!hasErrors()) {
			ProcesoTipo procesoTipo = null;

			if (model.getEntiId() == Entidad.MANIFIESTO.getId()) {
				procesoTipo = ProcesoTipo.MAN_CARGA;
			} else if (model.getEntiId() == Entidad.ESCALA.getId()) {
				procesoTipo = ProcesoTipo.ESC_CARGA;
			} else if (model.getEntiId() == Entidad.MANIFIESTO_PESCA.getId()) {
				procesoTipo = ProcesoTipo.PES_CARGA;
			} else {
				throw new Error("Tipo de proceso desconocido: " + procesoTipo);
			}

			prbtService.crear(SessionManager.getUsroId(), procesoTipo, null, ItemTipo.arch,
					Arrays.asList(model.getArchId()));
		}
	}
}
