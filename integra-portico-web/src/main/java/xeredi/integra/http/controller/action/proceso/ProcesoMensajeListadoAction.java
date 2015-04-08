package xeredi.integra.http.controller.action.proceso;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeListadoAction.
 */
public final class ProcesoMensajeListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2398654673428203733L;

    /** The prbt id. */
    private Long prbtId;

    /** The prmn list. */
    private PaginatedList<ProcesoMensajeVO> prmnList;

    /**
     * List.
     *
     * @return the string
     */
    @Action("prmn-list")
    public String list() {
        Preconditions.checkNotNull(prbtId);

        final ProcesoBO prbtBO = new ProcesoBO();

        prmnList = prbtBO.selectPrmnList(prbtId, getOffset(), getLimit());

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

}
