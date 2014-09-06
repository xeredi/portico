package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Valoracion;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListadoAction.
 */
public final class ValoracionDetalleListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9004620291483639470L;

    /** The vlrd list. */
    private PaginatedList<ValoracionDetalleVO> vlrdList;

    /** The vlrd criterio. */
    private ValoracionDetalleCriterioVO vlrdCriterio;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /**
     * The Constructor.
     */
    public ValoracionDetalleListadoAction() {
        super();

        vlrdCriterio = new ValoracionDetalleCriterioVO();
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
    @Actions({ @Action("vlrd-list") })
    public String listado() {
        Preconditions.checkNotNull(vlrdCriterio);

        final Valoracion vlrcBO = BOFactory.getInjector().getInstance(ValoracionBO.class);

        if (hasErrors()) {
            return INPUT;
        }

        vlrdList = vlrcBO.selectVlrdList(vlrdCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

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
     * Gets the vlrd criterio.
     *
     * @return the vlrd criterio
     */
    public ValoracionDetalleCriterioVO getVlrdCriterio() {
        return vlrdCriterio;
    }

    /**
     * Sets the vlrd criterio.
     *
     * @param value
     *            the vlrd criterio
     */
    public void setVlrdCriterio(final ValoracionDetalleCriterioVO value) {
        vlrdCriterio = value;
    }

    /**
     * Gets the vlrd list.
     *
     * @return the vlrd list
     */
    public PaginatedList<ValoracionDetalleVO> getVlrdList() {
        return vlrdList;
    }

}
