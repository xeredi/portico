package xeredi.argo.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.argo.model.proceso.batch.pesca.ProcesoBuquePesca;

@DisallowConcurrentExecution
public final class BuquePescaJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(BuquePescaJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoBuquePesca proceso = new ProcesoBuquePesca();

        try {
            proceso.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}
