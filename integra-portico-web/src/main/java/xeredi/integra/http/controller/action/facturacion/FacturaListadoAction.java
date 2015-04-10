package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaListadoAction.
 */
public final class FacturaListadoAction extends PaginableAction implements ModelDriven<FacturaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -46147994205400361L;

    /** The fctr criterio. */
    private FacturaCriterioVO model;

    /** The fctr list. */
    private PaginatedList<FacturaVO> fctrList;

    // acciones web

    /**
     * List.
     *
     * @return the string
     */
    @Action("fctr-list")
    public String list() {
        final FacturaBO fctrBO = new FacturaBO();

        if (model == null) {
            model = new FacturaCriterioVO();
        }

        fctrList = fctrBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the fctr criterio.
     *
     * @param value
     *            the new fctr criterio
     */
    public void setModel(final FacturaCriterioVO value) {
        model = value;
    }

    /**
     * Gets the fctr list.
     *
     * @return the fctr list
     */
    public PaginatedList<FacturaVO> getFctrList() {
        return fctrList;
    }
}
