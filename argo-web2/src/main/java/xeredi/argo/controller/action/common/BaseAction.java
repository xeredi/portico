package xeredi.argo.controller.action.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 */
@ParentPackage("default")
@Result(type = "json", params = { "excludeNullProperties", "true", "ignoreHierarchy", "false", "enableGZIP", "true" })
public abstract class BaseAction  extends ActionSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1581095263604888595L;

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(BaseAction.class);

    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Action
    public final String execute() {
        try {
            doExecute();
        } catch (final Exception ex) {
            LOG.error(ex, ex);
        }

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws Exception the exception
     */
    public abstract void doExecute() throws Exception;
}
