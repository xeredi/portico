package xeredi.argo.proceso.servicio.suministrored;

import java.util.Date;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.bo.suministrored.SuministroRedBO;
import xeredi.argo.model.servicio.vo.ServicioMaestroCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.ProcesoTemplate;

public final class ProcesoSuministroRed extends ProcesoTemplate {

	/**
	 * The Enum params.
	 */
	public enum params {
		/** The ffin. */
		ffin
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void prepararProcesos() {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void ejecutarProceso() {
		final Date ffin = findDateParameter(params.ffin.name());
		final SuministroRedBO sredBO = new SuministroRedBO(prbtData.getPrbt().getUsro().getId());

		Preconditions.checkNotNull(ffin);

		final ServicioMaestroCriterioVO srmsCriterio = new ServicioMaestroCriterioVO();

		srmsCriterio.setFfin(ffin);

		for (final ServicioMaestroVO srms : sredBO.selectGenerateList(srmsCriterio)) {
			try {
				final ServicioVO srvc = sredBO.create(srms);

				addPritSalida(srvc.getId());
			} catch (final DuplicateInstanceException ex) {
				addError(MensajeCodigo.G_011, ex.getMessage());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProcesoTipo getProcesoTipo() {
		return ProcesoTipo.SRED_CREACION;
	}
}
