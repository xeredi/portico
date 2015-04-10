package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaListadoAction.
 */
public final class ValoracionLineaListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4531375285740204285L;

    /** The vlrl list. */
    private PaginatedList<ValoracionLineaVO> vlrlList;

    /** The vlrl criterio. */
    private Long vlrcId;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("vlrl-list")
    public String listado() {
        Preconditions.checkNotNull(vlrcId);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrlList = vlrcBO.selectVlrlList(vlrcId, getIdioma(), getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the new vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
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
