package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoLupaCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaAction.
 */
public final class CargoLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 367706797413439221L;

    /** The crgo criterio. */
    private CargoLupaCriterioVO crgoCriterio;

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /**
     * List.
     *
     * @return the string
     */
    @Action("crgo-lupa")
    public String list() {
        Preconditions.checkNotNull(crgoCriterio);

        if (crgoCriterio.getTextoBusqueda() != null) {
            crgoCriterio.setTextoBusqueda(crgoCriterio.getTextoBusqueda().toUpperCase() + "%");
        }

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectLupaList(crgoCriterio, GlobalNames.LUPA_LIMIT_DEFAULT);

        return SUCCESS;
    }

    /**
     * Gets the crgo criterio.
     *
     * @return the crgo criterio
     */
    public CargoLupaCriterioVO getCrgoCriterio() {
        return crgoCriterio;
    }

    /**
     * Sets the crgo criterio.
     *
     * @param value
     *            the new crgo criterio
     */
    public void setCrgoCriterio(final CargoLupaCriterioVO value) {
        crgoCriterio = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }

}
