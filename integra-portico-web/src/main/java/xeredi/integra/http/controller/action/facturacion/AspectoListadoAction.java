package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Aspecto;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoListadoAction.
 */
public final class AspectoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7615445979289765235L;

    /** The aspc list. */
    private PaginatedList<AspectoVO> aspcList;

    /** The aspc criterio. */
    private AspectoCriterioVO aspcCriterio;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = 20;

    /**
     * The Constructor.
     */
    public AspectoListadoAction() {
        super();

        aspcCriterio = new AspectoCriterioVO();
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
    @Actions({ @Action(value = "aspc-listado") })
    public String listado() {
        Preconditions.checkNotNull(aspcCriterio);

        final Aspecto aspcBO = BOFactory.getInjector().getInstance(AspectoBO.class);

        if (hasErrors()) {
            return INPUT;
        }

        aspcList = aspcBO.selectList(aspcCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

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
     * Gets the aspc criterio.
     *
     * @return the aspc criterio
     */
    public AspectoCriterioVO getAspcCriterio() {
        return aspcCriterio;
    }

    /**
     * Sets the aspc criterio.
     *
     * @param value
     *            the aspc criterio
     */
    public void setAspcCriterio(AspectoCriterioVO value) {
        this.aspcCriterio = value;
    }

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public PaginatedList<AspectoVO> getAspcList() {
        return aspcList;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the page
     */
    public void setPage(int value) {
        this.page = value;
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
    public void setLimit(int value) {
        this.limit = value;
    }

}