package xeredi.integra.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PorticoScheduler.
 */
public final class PorticoScheduler {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PorticoScheduler.class);

    /** The instance. */
    private static PorticoScheduler instance;

    /** The scheduler. */
    private Scheduler scheduler;

    /**
     * Gets the single instance of PorticoScheduler.
     *
     * @return single instance of PorticoScheduler
     * @throws SchedulerException
     *             the scheduler exception
     */
    public static PorticoScheduler getInstance() throws SchedulerException {
        if (instance == null) {
            LOG.info("Creating Scheduler");

            instance = new PorticoScheduler();

            final SchedulerFactory factory = new StdSchedulerFactory();

            instance.scheduler = factory.getScheduler();

            final JobDetail cargaOppeJob = JobBuilder.newJob(CargaOppeJob.class)
                    .withIdentity("cargaOppeJob", "estGroup").build();

            final Trigger cargaOppeTrigger = TriggerBuilder.newTrigger().withIdentity("cargaOppeTrigger", "estGroup")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(300).repeatForever())
                    .build();

            instance.scheduler.scheduleJob(cargaOppeJob, cargaOppeTrigger);

            final JobDetail agregacionApJob = JobBuilder.newJob(AgregacionApJob.class)
                    .withIdentity("agregacionApJob", "estGroup").build();

            final Trigger agregacionApTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("agregacionApTrigger", "estGroup").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(300).repeatForever())
                    .build();

            instance.scheduler.scheduleJob(agregacionApJob, agregacionApTrigger);

            LOG.info("Scheduler Created");
        }

        if (!instance.scheduler.isStarted()) {
            LOG.info("Starting Scheduler");

            instance.scheduler.start();

            LOG.info("Scheduler Started");
        }

        return instance;
    }

    /**
     * Instantiates a new portico scheduler.
     */
    private PorticoScheduler() {
        super();
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        try {
            PorticoScheduler.getInstance();
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
        }
    }
}
