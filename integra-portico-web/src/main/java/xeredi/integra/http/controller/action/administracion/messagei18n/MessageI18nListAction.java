package xeredi.integra.http.controller.action.administracion.messagei18n;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.MessageI18nBO;
import xeredi.integra.model.comun.bo.MessageI18nReportVO;
import xeredi.integra.model.comun.vo.MessageI18nBundle;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nListAction.
 */
public final class MessageI18nListAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9186179634462884228L;

    /** The bundle. */
    private MessageI18nBundle bundle;

    /** The report. */
    private MessageI18nReportVO report;

    /**
     * List.
     *
     * @return the string
     */
    @Action("m18n-grid")
    public String list() {
        Preconditions.checkNotNull(bundle);

        final MessageI18nBO m18nBO = new MessageI18nBO();

        report = m18nBO.report(bundle);

        return SUCCESS;
    }

    /**
     * Gets the bundle.
     *
     * @return the bundle
     */
    public MessageI18nBundle getBundle() {
        return bundle;
    }

    /**
     * Sets the bundle.
     *
     * @param bundle
     *            the new bundle
     */
    public void setBundle(final MessageI18nBundle bundle) {
        this.bundle = bundle;
    }

    /**
     * Gets the report.
     *
     * @return the report
     */
    public MessageI18nReportVO getReport() {
        return report;
    }

}
