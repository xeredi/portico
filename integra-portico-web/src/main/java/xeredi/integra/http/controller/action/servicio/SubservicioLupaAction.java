package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioLupaAction.
 */
public final class SubservicioLupaAction extends LupaAction implements ModelDriven<SubservicioLupaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -979190040769739626L;

    /** The item lupa criterio. */
    private SubservicioLupaCriterioVO model;

    /** The item list. */
    private List<SubservicioVO> itemList;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("ssrv-lupa")
    public String lupa() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getSrvcId());
        Preconditions.checkNotNull(model.getNumero());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        itemList = ssrvBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public SubservicioLupaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setModel(final SubservicioLupaCriterioVO value) {
        model = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public List<SubservicioVO> getItemList() {
        return itemList;
    }

}
