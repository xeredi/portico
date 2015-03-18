package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaAction.
 */
public final class CargoLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 367706797413439221L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getInt(ConfigurationKey.filter_limit);

    /** The crgo criterio. */
    private CargoCriterioVO crgoCriterio;

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("crgo-lupa-tpsr")
    public String lupaTpsr() {
        Preconditions.checkNotNull(crgoCriterio);
        Preconditions.checkNotNull(crgoCriterio.getTpsrId());
        Preconditions.checkNotNull(crgoCriterio.getTextoBusqueda());

        crgoCriterio.setIdioma(getIdioma());

        if (crgoCriterio.getFechaVigencia() == null) {
            crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectLupaList(crgoCriterio, ROWS);

        return SUCCESS;
    }

    /**
     * Lupa aspc.
     *
     * @return the string
     */
    @Action("crgo-lupa-aspc")
    public String lupaAspc() {
        Preconditions.checkNotNull(crgoCriterio);
        Preconditions.checkNotNull(crgoCriterio.getAspcId());
        Preconditions.checkNotNull(crgoCriterio.getTextoBusqueda());

        crgoCriterio.setIdioma(getIdioma());

        if (crgoCriterio.getFechaVigencia() == null) {
            crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectLupaList(crgoCriterio, ROWS);

        return SUCCESS;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }

    /**
     * Sets the crgo criterio.
     *
     * @param value
     *            the new crgo criterio
     */
    public void setCrgoCriterio(final CargoCriterioVO value) {
        crgoCriterio = value;
    }
}
