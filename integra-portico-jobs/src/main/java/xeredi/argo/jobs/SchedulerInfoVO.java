package xeredi.argo.jobs;

// TODO: Auto-generated Javadoc
/**
 * The Class SchedulerInfoVO.
 */
public final class SchedulerInfoVO {

    /** The started. */
    private boolean started;

    /** The shutdown. */
    private boolean shutdown;

    /** The in standby. */
    private boolean inStandbyMode;

    /**
     * Instantiates a new scheduler info vo.
     */
    SchedulerInfoVO() {
        super();
    }

    /**
     * Checks if is started.
     *
     * @return true, if is started
     */
    public boolean isStarted() {
        return started;
    }

    /**
     * Sets the started.
     *
     * @param value
     *            the new started
     */
    public void setStarted(final boolean value) {
        started = value;
    }

    /**
     * Checks if is shutdown.
     *
     * @return true, if is shutdown
     */
    public boolean isShutdown() {
        return shutdown;
    }

    /**
     * Sets the shutdown.
     *
     * @param value
     *            the new shutdown
     */
    public void setShutdown(final boolean value) {
        shutdown = value;
    }

    /**
     * Checks if is in standby.
     *
     * @return true, if is in standby
     */
    public boolean isInStandbyMode() {
        return inStandbyMode;
    }

    /**
     * Sets the in standby.
     *
     * @param value
     *            the new in standby
     */
    public void setInStandbyMode(final boolean value) {
        inStandbyMode = value;
    }

}
