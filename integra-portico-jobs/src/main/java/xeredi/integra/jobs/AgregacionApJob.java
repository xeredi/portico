package xeredi.integra.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.integra.proceso.estadistica.agregacionap.ProcesoAgregacionAp;

// TODO: Auto-generated Javadoc
/**
 * The Class AgregacionApJob.
 */
public final class AgregacionApJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AgregacionApJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoAgregacionAp procesoAgregacionAp = new ProcesoAgregacionAp();

        try {
            procesoAgregacionAp.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}
