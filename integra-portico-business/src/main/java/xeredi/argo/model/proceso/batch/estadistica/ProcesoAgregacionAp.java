package xeredi.argo.model.proceso.batch.estadistica;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAgregacionAp.
 */
public final class ProcesoAgregacionAp extends ProcesoTemplate {

	@Inject
	private SuperpuertoService sprtService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private PeriodoProcesoService peprService;

	/**
	 * The Enum params.
	 */
	public enum params {
		/** The autp. */
		autp,

		/** The mes. */
		mes,

		/** The anio. */
		anio,

		/** The sobreescribir. */
		sobreescribir
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
		// Validacion de parametros

		final String autpCodigo = findStringParameter(params.autp.name());
		final Integer anio = findIntegerParameter(params.anio.name());
		final Integer mes = findIntegerParameter(params.mes.name());
		final Boolean sobreescribir = findBooleanParameter(params.sobreescribir.name());

		if (prbtData.getPrmnList().isEmpty()) {
			try {
				// Comprobar que existe la AP
				final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

				sprtCriterio.setCodigo(autpCodigo);

				final SuperpuertoVO sprt = sprtService.selectObject(sprtCriterio);

				final Calendar calendar = Calendar.getInstance();

				calendar.setTimeInMillis(0);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.MONTH, mes - 1);
				calendar.set(Calendar.YEAR, anio);

				// Busqueda de los subpuertos de la AP
				final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

				prtoCriterio.setSprtId(sprt.getId());

				final List<PuertoVO> prtoList = prtoService.selectList(prtoCriterio);

				if (prtoList.isEmpty()) {
					addError(MensajeCodigo.E_002, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpCodigo);
				} else {
					final PeriodoProcesoVO pepr = new PeriodoProcesoVO();

					pepr.setSprt(sprt);
					pepr.setAnio(anio);
					pepr.setMes(mes);
					pepr.setFreferencia(calendar.getTime());

					try {
						peprService.agregarServicios(pepr, sobreescribir);

						prbtData.getItemSalidaList().add(pepr.getId());
					} catch (final DuplicateInstanceException ex) {
						addError(MensajeCodigo.E_001, "Periodo de Proceso: " + pepr.getSprt().getCodigo() + " "
								+ pepr.getAnio() + " " + pepr.getMes());
					} catch (final IOException ex) {
						addError(MensajeCodigo.G_000, ex.getMessage());
					}
				}
			} catch (final InstanceNotFoundException ex) {
				addError(MensajeCodigo.G_001, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpCodigo);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProcesoTipo getProcesoTipo() {
		return ProcesoTipo.EST_CREACION;
	}
}
