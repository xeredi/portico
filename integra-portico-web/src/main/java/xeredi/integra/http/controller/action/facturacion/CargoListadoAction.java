package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoListadoAction.
 */
public final class CargoListadoAction extends PaginableAction implements ModelDriven<CargoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6194164339064073309L;

    /** The aspc list. */
    private PaginatedList<CargoVO> crgoList;

    /** The aspc criterio. */
    private CargoCriterioVO model;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // acciones web
    /**
     * Filter.
     *
     * @return the string
     */
    @Action("crgo-filter")
    public String filter() {
        tpsrList = TipoServicioProxy.selectLabelValues();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("crgo-list")
    public String listado() {
        if (model == null) {
            model = new CargoCriterioVO();
        }

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        model.setIdioma(getIdioma());

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the crgo criterio.
     *
     * @param value
     *            the new crgo criterio
     */
    public void setModel(final CargoCriterioVO value) {
        model = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public PaginatedList<CargoVO> getCrgoList() {
        return crgoList;
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
