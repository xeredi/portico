package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioLupaAction.
 */
public final class SubservicioLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -979190040769739626L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getInt(ConfigurationKey.filter_limit);

    /** The item list. */
    private List<SubservicioVO> itemList;

    /** The item lupa criterio. */
    private SubservicioLupaCriterioVO itemLupaCriterio;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("ssrv-lupa")
    public String lupa() {
        Preconditions.checkNotNull(itemLupaCriterio);
        Preconditions.checkNotNull(itemLupaCriterio.getEntiId());
        Preconditions.checkNotNull(itemLupaCriterio.getSrvcId());
        Preconditions.checkNotNull(itemLupaCriterio.getNumero());

        final SubservicioBO ssrvBO = new SubservicioBO();

        itemList = ssrvBO.selectLupaList(itemLupaCriterio, ROWS);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item lupa criterio.
     *
     * @return the item lupa criterio
     */
    public SubservicioLupaCriterioVO getItemLupaCriterio() {
        return itemLupaCriterio;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setItemLupaCriterio(final SubservicioLupaCriterioVO value) {
        itemLupaCriterio = value;
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
