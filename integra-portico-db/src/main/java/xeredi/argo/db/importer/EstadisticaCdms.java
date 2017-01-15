package xeredi.argo.db.importer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

public final class EstadisticaCdms {
	private static final Log LOG = LogFactory.getLog(EstadisticaCdms.class);

	public static void main(final String[] args) {
		LOG.info("CDMS Generation Start");

		final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
		final PeriodoProcesoCriterioVO peprCriterio = new PeriodoProcesoCriterioVO();

		for (final PeriodoProcesoVO pepr : peprBO.selectList(peprCriterio)) {
			LOG.info("CDMS for: " + pepr.getSprt().getCodigo() + ", " + pepr.getAnio() + ", " + pepr.getMes());

			peprBO.generarCuadroMensual(pepr.getId(), true);
		}

		LOG.info("CDMS Generation End");
	}
}
