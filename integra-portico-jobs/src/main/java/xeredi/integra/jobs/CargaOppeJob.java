package xeredi.integra.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.integra.proceso.estadistica.cargaoppe.ProcesoCargaOppe;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaOppeJob.
 */
public final class CargaOppeJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(CargaOppeJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoCargaOppe procesoCargaOppe = new ProcesoCargaOppe();

        try {
            procesoCargaOppe.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}
