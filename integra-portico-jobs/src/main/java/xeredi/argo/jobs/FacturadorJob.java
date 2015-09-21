package xeredi.argo.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import xeredi.argo.proceso.facturacion.ProcesoFacturador;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorJob.
 */
@DisallowConcurrentExecution
public final class FacturadorJob implements Job {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start Job");

        final ProcesoFacturador procesoFacturador = new ProcesoFacturador();

        try {
            procesoFacturador.procesar();
        } catch (final Throwable ex) {
            LOG.error(ex, ex);
        }

        LOG.info("End Job");
    }

}
