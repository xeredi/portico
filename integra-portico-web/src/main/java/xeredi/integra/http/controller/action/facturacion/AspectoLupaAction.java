package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoLupaAction.
 */
public final class AspectoLupaAction extends LupaAction implements ModelDriven<AspectoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -764613729784237979L;

    /** The crgo criterio. */
    private AspectoCriterioVO model;

    /** The crgo list. */
    private List<AspectoVO> aspcList;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("aspc-lupa")
    public String lupa() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpsrId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        model.setIdioma(getIdioma());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoBO aspcBO = new AspectoBO();

        aspcList = aspcBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public List<AspectoVO> getAspcList() {
        return aspcList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AspectoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final AspectoCriterioVO value) {
        model = value;
    }

}
