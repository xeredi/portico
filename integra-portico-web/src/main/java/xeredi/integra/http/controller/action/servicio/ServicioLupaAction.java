package xeredi.integra.http.controller.action.servicio;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.servicio.Servicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.servicio.ServicioLupaCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaAction.
 */
@ParentPackage("json-default")
public final class ServicioLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1371351782684147321L;

    /** The Constant ROWS. */
    private static final int ROWS = 5;

    /** The srvcs. */
    private List<LabelValueVO> itemList;

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
    @Action(value = "srvc-lupa", results = { @Result(name = "success", type = "json") })
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

        itemLupaCriterio.setLimit(ROWS);

        final Servicio srvcBO = BOFactory.getInjector().getInstance(Servicio.class);

        itemList = srvcBO.selectLupaList(itemLupaCriterio);

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
    public List<LabelValueVO> getItemList() {
        return itemList;
    }

}
