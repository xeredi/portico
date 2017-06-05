package xeredi.argo.model.proceso.batch.amarredep;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.service.amarredep.AmarreDeportivoServicioService;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAmarreDeportivo.
 */
public final class ProcesoAmarreDeportivo extends ProcesoTemplate {

	@Inject
	private ServicioServiceFactory srvcFactory;

	@Inject
	private EntidadProxyService entiProxy;

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

		if (prbtData.getPrmnList().isEmpty()) {
			final TipoServicioDetailVO enti = entiProxy.selectTpsr(Entidad.AMARRE_DEP_SRV.getId());

			final AmarreDeportivoServicioService srvcService = (AmarreDeportivoServicioService) srvcFactory
					.getInstance(Entidad.AMARRE_DEP_SRV.getId(), prbtData.getPrbt().getUsro().getId());
			final ServicioCriterioVO criterio = new ServicioCriterioVO();

			criterio.setFrefMax(ffin);

			for (final ServicioMaestroVO maestro : srvcService.selectGenerate(criterio)) {
				final ServicioVO srvc = enti.createItem();

				try {
					srvc.setPrto(maestro.getPrmt().getPrto());
					srvc.setFini(maestro.getFini());
					srvc.setFfin(maestro.getFfin());
					srvc.setFref(maestro.getFini());

					final Calendar calendar = Calendar.getInstance();

					calendar.setTime(maestro.getFini());

					srvc.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));

					final ParametroVO amarre = new ParametroVO();

					amarre.setId(Long.parseLong(maestro.getItdtMap().get(TipoDato.AMARRE_DEP.name()).toString()));
					amarre.setParametro(maestro.getItdtMap().get(TipoDato.AMARRE_DEP.name() + "_prmt").toString());

					srvc.addItdt(TipoDato.AMARRE_DEP.getId(), amarre);

					final ParametroVO embarcacion = new ParametroVO();

					embarcacion.setId(
							Long.parseLong(maestro.getItdtMap().get(TipoDato.EMBARCACION_DEP.name()).toString()));
					embarcacion.setParametro(
							maestro.getItdtMap().get(TipoDato.EMBARCACION_DEP.name() + "_prmt").toString());

					srvc.addItdt(TipoDato.EMBARCACION_DEP.getId(), embarcacion);

					final ParametroVO tipoIva = new ParametroVO();

					tipoIva.setId(Long.parseLong(maestro.getItdtMap().get(TipoDato.TIPO_IVA.name()).toString()));

					srvc.addItdt(TipoDato.TIPO_IVA.getId(), tipoIva);

					srvcService.insert(srvc, null, null, null);

					addPritSalida(srvc.getId());
				} catch (final DuplicateInstanceException ex) {
					addError(MensajeCodigo.G_011, srvc.getItdt(TipoDato.AMARRE_DEP.getId()).getPrmt().getParametro()
							+ " - " + srvc.getItdt(TipoDato.EMBARCACION_DEP.getId()).getPrmt().getParametro());
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProcesoTipo getProcesoTipo() {
		return ProcesoTipo.SAMD_CREACION;
	}
}
