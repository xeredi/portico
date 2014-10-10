package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionListadoAction.
 */
public final class ValoracionListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8684408096397399011L;

    /** The vlrc list. */
    private PaginatedList<ValoracionVO> vlrcList;

    /** The vlrc criterio. */
    private ValoracionCriterioVO vlrcCriterio;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The tpsr list. */
    private final List<LabelValueVO> tpsrList = new ArrayList<>();

    /**
     * The Constructor.
     */
    public ValoracionListadoAction() {
        super();

        vlrcCriterio = new ValoracionCriterioVO();
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
    @Actions({ @Action("vlrc-list") })
    public String listado() {
        Preconditions.checkNotNull(vlrcCriterio);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrcList = vlrcBO.selectList(vlrcCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action("vlrc-filter") })
    public String editarFiltro() {
        tpsrList.addAll(TipoServicioProxy.selectLabelValues());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrc criterio.
     *
     * @return the vlrc criterio
     */
    public ValoracionCriterioVO getVlrcCriterio() {
        return vlrcCriterio;
    }

    /**
     * Sets the vlrc criterio.
     *
     * @param value
     *            the vlrc criterio
     */
    public void setVlrcCriterio(final ValoracionCriterioVO value) {
        vlrcCriterio = value;
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
     * Gets the vlrc list.
     *
     * @return the vlrc list
     */
    public PaginatedList<ValoracionVO> getVlrcList() {
        return vlrcList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

}
