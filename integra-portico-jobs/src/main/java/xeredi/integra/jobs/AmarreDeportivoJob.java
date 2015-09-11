package xeredi.integra.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.integra.model.proceso.batch.amarredep.ProcesoAmarreDeportivo;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoJob.
 */
@DisallowConcurrentExecution
public final class AmarreDeportivoJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AmarreDeportivoJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoAmarreDeportivo proceso = new ProcesoAmarreDeportivo();

        try {
            proceso.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}