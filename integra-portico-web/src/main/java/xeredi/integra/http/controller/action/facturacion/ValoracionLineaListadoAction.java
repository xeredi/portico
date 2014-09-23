package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaListadoAction.
 */
public final class ValoracionLineaListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4531375285740204285L;

    /** The vlrl list. */
    private PaginatedList<ValoracionLineaVO> vlrlList;

    /** The vlrl criterio. */
    private ValoracionLineaCriterioVO vlrlCriterio;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /**
     * The Constructor.
     */
    public ValoracionLineaListadoAction() {
        super();

        vlrlCriterio = new ValoracionLineaCriterioVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Actions({ @Action("vlrl-list") })
    public String listado() {
        Preconditions.checkNotNull(vlrlCriterio);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrlList = vlrcBO.selectVlrlList(vlrlCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get / set

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
     *            the page
     */
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the limit
     */
    public void setLimit(final int value) {
        limit = value;
    }

    /**
     * Gets the vlrl criterio.
     *
     * @return the vlrl criterio
     */
    public ValoracionLineaCriterioVO getVlrlCriterio() {
        return vlrlCriterio;
    }

    /**
     * Sets the vlrl criterio.
     *
     * @param value
     *            the new vlrl criterio
     */
    public void setVlrlCriterio(final ValoracionLineaCriterioVO value) {
        vlrlCriterio = value;
    }

    /**
     * Gets the vlrl list.
     *
     * @return the vlrl list
     */
    public PaginatedList<ValoracionLineaVO> getVlrlList() {
        return vlrlList;
    }

}
