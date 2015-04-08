package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieListadoAction.
 */
public final class FacturaSerieListadoAction extends PaginableAction implements ModelDriven<FacturaSerieCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1189138882681211082L;

    /** The srvcs. */
    private PaginatedList<FacturaSerieVO> fcsrList;

    /** The srvc criterio form. */
    private FacturaSerieCriterioVO model;

    // acciones web

    /**
     * List.
     *
     * @return the string
     */
    @Action("fcsr-list")
    public String list() {
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        if (model == null) {
            model = new FacturaSerieCriterioVO();
        }

        fcsrList = fcsrBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaSerieCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the fcsr criterio.
     *
     * @param value
     *            the new fcsr criterio
     */
    public void setModel(final FacturaSerieCriterioVO value) {
        model = value;
    }

    /**
     * Gets the fcsr list.
     *
     * @return the fcsr list
     */
    public PaginatedList<FacturaSerieVO> getFcsrList() {
        return fcsrList;
    }

}
