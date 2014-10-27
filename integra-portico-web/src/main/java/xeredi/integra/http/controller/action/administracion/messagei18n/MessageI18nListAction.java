package xeredi.integra.http.controller.action.administracion.messagei18n;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.MessageI18nBO;
import xeredi.integra.model.comun.bo.MessageI18nReportVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nListAction.
 */
public final class MessageI18nListAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9186179634462884228L;

    /** The report. */
    private MessageI18nReportVO report;

    /**
     * List.
     *
     * @return the string
     */
    @Action("m18n-grid")
    public String list() {
        final MessageI18nBO m18nBO = new MessageI18nBO();

        report = m18nBO.report();

        return SUCCESS;
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
