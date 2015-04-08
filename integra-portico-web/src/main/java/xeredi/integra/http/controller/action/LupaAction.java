package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;

// TODO: Auto-generated Javadoc
/**
 * The Class LupaAction.
 */
public abstract class LupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7129397130272857558L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getInt(ConfigurationKey.filter_limit);

    /** The limit. */
    private int limit = ROWS;

    // get / set
    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public final int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param limit
     *            the new limit
     */
    public final void setLimit(final int limit) {
        this.limit = limit;
    }

}
