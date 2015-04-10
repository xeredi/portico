package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListadoAction.
 */
public final class ValoracionDetalleListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9004620291483639470L;

    /** The vlrd list. */
    private PaginatedList<ValoracionDetalleVO> vlrdList;

    /** The vlrl id. */
    private Long vlrlId;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("vlrd-list")
    public String listado() {
        Preconditions.checkNotNull(vlrlId);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrdList = vlrcBO.selectVlrdList(vlrlId, getIdioma(), getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrl id.
     *
     * @return the vlrl id
     */
    public Long getVlrlId() {
        return vlrlId;
    }

    /**
     * Sets the vlrl id.
     *
     * @param value
     *            the new vlrl id
     */
    public void setVlrlId(final Long value) {
        vlrlId = value;
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
