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
    private static Scheduler instance;

    /**
     * Gets the single instance of PorticoScheduler.
     *
     * @return single instance of PorticoScheduler
     * @throws SchedulerException
     *             the scheduler exception
     */
    public static Scheduler getScheduler() throws SchedulerException {
        if (instance == null) {
            LOG.info("Creating Scheduler");

            final SchedulerFactory factory = new StdSchedulerFactory();

            instance = factory.getScheduler();

            final JobDetail cargaOppeJob = JobBuilder.newJob(CargaOppeJob.class)
                    .withIdentity("cargaOppeJob", "estGroup").build();

            final Trigger cargaOppeTrigger = TriggerBuilder.newTrigger().withIdentity("cargaOppeTrigger", "estGroup")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(300).repeatForever())
                    .build();

            instance.scheduleJob(cargaOppeJob, cargaOppeTrigger);

            final JobDetail agregacionApJob = JobBuilder.newJob(AgregacionApJob.class)
                    .withIdentity("agregacionApJob", "estGroup").build();

            final Trigger agregacionApTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("agregacionApTrigger", "estGroup").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(300).repeatForever())
                    .build();

            instance.scheduleJob(agregacionApJob, agregacionApTrigger);

            final JobDetail pescaJob = JobBuilder.newJob(CargaPescaJob.class).withIdentity("pescaJob", "srvcGroup")
                    .build();

            final Trigger pescaTrigger = TriggerBuilder.newTrigger().withIdentity("pescaTrigger", "srvcGroup")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(300).repeatForever())
                    .build();

            instance.scheduleJob(pescaJob, pescaTrigger);

            LOG.info("Scheduler Created");
        }

        return instance;
    }

    /**
     * Gets the info.
     *
     * @return the info
     * @throws SchedulerException
     *             the scheduler exception
     */
    public static SchedulerInfoVO getInfo() throws SchedulerException {
        final Scheduler scheduler = getScheduler();

        final SchedulerInfoVO infoVO = new SchedulerInfoVO();

        infoVO.setInStandbyMode(scheduler.isInStandbyMode());
        infoVO.setStarted(scheduler.isStarted());
        infoVO.setShutdown(scheduler.isShutdown());

        return infoVO;
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
            final Scheduler scheduler = PorticoScheduler.getScheduler();

            scheduler.start();
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
        }
    }
}
