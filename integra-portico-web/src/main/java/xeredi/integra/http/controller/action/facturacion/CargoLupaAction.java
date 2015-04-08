package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaAction.
 */
public final class CargoLupaAction extends LupaAction implements ModelDriven<CargoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 367706797413439221L;

    /** The crgo criterio. */
    private CargoCriterioVO model;

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("crgo-lupa-tpsr")
    public String lupaTpsr() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpsrId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        model.setIdioma(getIdioma());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    /**
     * Lupa aspc.
     *
     * @return the string
     */
    @Action("crgo-lupa-aspc")
    public String lupaAspc() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getAspcId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        model.setIdioma(getIdioma());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final CargoCriterioVO value) {
        model = value;
    }

}
