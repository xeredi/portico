package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroListadoAction.
 */
public final class SubparametroListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8182660007822844841L;

    /** The item list. */
    private PaginatedList<SubparametroVO> itemList;

    /** The item criterio. */
    private SubparametroCriterioVO itemCriterio;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("sprm-list")
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());
        Preconditions.checkNotNull(itemCriterio.getPrmt().getId());
        Preconditions.checkNotNull(itemCriterio.getFechaVigencia());

        final SubparametroBO sprmBO = new SubparametroBO();

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        itemList = sprmBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubparametroCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return itemCriterio == null || itemCriterio.getFechaVigencia() == null ? Calendar.getInstance().getTime()
                : itemCriterio.getFechaVigencia();
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setItemCriterio(final SubparametroCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public PaginatedList<SubparametroVO> getItemList() {
        return itemList;
    }

}
