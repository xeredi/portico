package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class RegaLupaAction.
 */
public final class ReglaLupaAction extends LupaAction implements ModelDriven<ReglaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -657608329114959872L;

    /** The model. */
    private ReglaCriterioVO model;

    /** The rgla list. */
    private List<ReglaVO> rglaList;

    @Action("rgla-lupa")
    public String lupa() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTextoBusqueda());

        model.setIdioma(getIdioma());

        final ReglaBO rglaBO = new ReglaBO();

        rglaList = rglaBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ReglaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final ReglaCriterioVO model) {
        this.model = model;
    }

    /**
     * Gets the rgla list.
     *
     * @return the rgla list
     */
    public List<ReglaVO> getRglaList() {
        return rglaList;
    }

}
