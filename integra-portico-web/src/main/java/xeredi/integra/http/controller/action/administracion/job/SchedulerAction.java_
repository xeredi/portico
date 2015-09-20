package xeredi.integra.http.controller.action.administracion.job;

import org.apache.struts2.convention.annotation.Action;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.jobs.PorticoScheduler;
import xeredi.integra.jobs.SchedulerInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SchedulerAction.
 */
public final class SchedulerAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3238565082610342549L;

    /** The scheduler. */
    private SchedulerInfoVO schr;

    // Acciones web

    /**
     * Detail.
     *
     * @return the string
     * @throws SchedulerException
     *             the scheduler exception
     */
    @Action("schr-detail")
    public String detail() throws SchedulerException {
        schr = PorticoScheduler.getInfo();

        return SUCCESS;
    }

    /**
     * Start.
     *
     * @return the string
     * @throws SchedulerException
     *             the scheduler exception
     */
    @Action("schr-start")
    public String start() throws SchedulerException {
        final Scheduler scheduler = PorticoScheduler.getScheduler();

        if (!scheduler.isStarted()) {
            scheduler.start();
        }

        return detail();
    }

    /**
     * Pause.
     *
     * @return the string
     * @throws SchedulerException
     *             the scheduler exception
     */
    @Action("schr-pause")
    public String pause() throws SchedulerException {
        final Scheduler scheduler = PorticoScheduler.getScheduler();

        if (!scheduler.isStarted()) {
            scheduler.pauseAll();
        }

        return detail();
    }

    /**
     * Shutdown.
     *
     * @return the string
     * @throws SchedulerException
     *             the scheduler exception
     */
    @Action("schr-shutdown")
    public String shutdown() throws SchedulerException {
        final Scheduler scheduler = PorticoScheduler.getScheduler();

        if (!scheduler.isShutdown()) {
            scheduler.shutdown();
        }

        return detail();
    }

    /**
     * Shutdown clean.
     *
     * @return the string
     * @throws SchedulerException
     *             the scheduler exception
     */
    @Action("schr-shutdown-clean")
    public String shutdownClean() throws SchedulerException {
        final Scheduler scheduler = PorticoScheduler.getScheduler();

        if (!scheduler.isShutdown()) {
            scheduler.shutdown(true);
        }

        return detail();
    }

    // get / set

    /**
     * Gets the scheduler.
     *
     * @return the scheduler
     */
    public SchedulerInfoVO getSchr() {
        return schr;
    }

}
