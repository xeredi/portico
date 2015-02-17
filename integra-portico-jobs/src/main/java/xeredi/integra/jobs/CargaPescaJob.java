package xeredi.integra.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.integra.proceso.servicio.pesca.ProcesoCargaPesca;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaPescaJob.
 */
@DisallowConcurrentExecution
public final class CargaPescaJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(CargaPescaJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoCargaPesca procesoCargaPesca = new ProcesoCargaPesca();

        try {
            procesoCargaPesca.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}
