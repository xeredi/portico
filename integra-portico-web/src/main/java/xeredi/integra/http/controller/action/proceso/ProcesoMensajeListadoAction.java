package xeredi.integra.http.controller.action.proceso;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeListadoAction.
 */
public final class ProcesoMensajeListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2398654673428203733L;

    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The prbt id. */
    private Long prbtId;

    /** The prmn list. */
    private PaginatedList<ProcesoMensajeVO> prmnList;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /**
     * List.
     *
     * @return the string
     */
    @Action("prmn-list")
    public String list() {
        Preconditions.checkNotNull(prbtId);

        final ProcesoBO prbtBO = new ProcesoBO();

        prmnList = prbtBO.selectPrmnList(prbtId, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Gets the prbt id.
     *
     * @return the prbt id
     */
    public Long getPrbtId() {
        return prbtId;
    }

    /**
     * Sets the prbt id.
     *
     * @param value
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }

    /**
     * Gets the prmn list.
     *
     * @return the prmn list
     */
    public PaginatedList<ProcesoMensajeVO> getPrmnList() {
        return prmnList;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public void setPage(final int value) {
        page = value;
    }

}
