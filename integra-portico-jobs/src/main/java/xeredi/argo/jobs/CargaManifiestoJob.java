package xeredi.argo.jobs;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.argo.proceso.servicio.manifiesto.ProcesoCargaManifiesto;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaManifiestoJob.
 */
@DisallowConcurrentExecution
public final class CargaManifiestoJob implements Job {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CargaManifiestoJob.class);

	@Inject
	private ProcesoCargaManifiesto prbt;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(final JobExecutionContext context) throws JobExecutionException {
		LOG.info("Start Job");

		try {
			prbt.procesar();
		} catch (final Throwable ex) {
			LOG.error(ex, ex);
		}

		LOG.info("End Job");
	}

}
