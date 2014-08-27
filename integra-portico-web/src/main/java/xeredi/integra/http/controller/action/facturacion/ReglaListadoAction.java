package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Regla;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaListadoAction.
 */
public final class ReglaListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3368897572069442785L;

    /** The aspc list. */
    private PaginatedList<ReglaVO> rglaList;

    /** The aspc criterio. */
    private ReglaCriterioVO rglaCriterio;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /**
     * The Constructor.
     */
    public ReglaListadoAction() {
        super();

        rglaCriterio = new ReglaCriterioVO();
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
    @Actions({ @Action(value = "rgla-listado") })
    public String listado() {
        Preconditions.checkNotNull(rglaCriterio);

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);

        rglaList = rglaBO.selectList(rglaCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

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
     * Gets the rgla list.
     *
     * @return the rgla list
     */
    public PaginatedList<ReglaVO> getRglaList() {
        return rglaList;
    }

    /**
     * Sets the rgla criterio.
     *
     * @param value
     *            the new rgla criterio
     */
    public void setRglaCriterio(final ReglaCriterioVO value) {
        rglaCriterio = value;
    }

    /**
     * Gets the rgla criterio.
     *
     * @return the rgla criterio
     */
    public ReglaCriterioVO getRglaCriterio() {
        return rglaCriterio;
    }

}
