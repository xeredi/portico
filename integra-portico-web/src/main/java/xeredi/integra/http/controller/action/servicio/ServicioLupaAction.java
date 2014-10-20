package xeredi.integra.http.controller.action.servicio;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaAction.
 */
public final class ServicioLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1371351782684147321L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getConfiguration()
            .getInt(ConfigurationKey.FILTER_LIMIT.getKey());

    /** The srvcs. */
    private List<ServicioVO> itemList;

    /** The srvc lupa criterio. */
    private ServicioLupaCriterioVO itemLupaCriterio;

    /**
     * Instantiates a new servicio lupa action.
     */
    public ServicioLupaAction() {
        super();
    }

    // Acciones Web
    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("srvc-lupa")
    public String lupa() {
        Preconditions.checkNotNull(itemLupaCriterio);
        Preconditions.checkNotNull(itemLupaCriterio.getEntiId());
        Preconditions.checkNotNull(itemLupaCriterio.getTextoBusqueda());

        final StringTokenizer tokenizer = new StringTokenizer(itemLupaCriterio.getTextoBusqueda(), "/");

        itemLupaCriterio.setSubpuerto(tokenizer.nextToken().toUpperCase());

        if (tokenizer.hasMoreTokens()) {
            itemLupaCriterio.setAnno(tokenizer.nextToken() + "%");
        }
        if (tokenizer.hasMoreTokens()) {
            itemLupaCriterio.setNumero(tokenizer.nextToken() + "%");
        }

        final ServicioBO srvcBO = new ServicioBO();

        itemList = srvcBO.selectLupaList(itemLupaCriterio, ROWS);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item lupa criterio.
     *
     * @return the item lupa criterio
     */
    public ServicioLupaCriterioVO getItemLupaCriterio() {
        return itemLupaCriterio;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setItemLupaCriterio(final ServicioLupaCriterioVO value) {
        itemLupaCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public List<ServicioVO> getItemList() {
        return itemList;
    }

}
