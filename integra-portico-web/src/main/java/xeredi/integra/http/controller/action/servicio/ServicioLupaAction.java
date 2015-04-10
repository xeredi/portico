package xeredi.integra.http.controller.action.servicio;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaAction.
 */
public final class ServicioLupaAction extends LupaAction implements ModelDriven<ServicioLupaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1371351782684147321L;

    /** The srvcs. */
    private List<ServicioVO> itemList;

    /** The srvc lupa criterio. */
    private ServicioLupaCriterioVO model;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        final StringTokenizer tokenizer = new StringTokenizer(model.getTextoBusqueda(), "/");

        model.setSubpuerto(tokenizer.nextToken().toUpperCase());

        if (tokenizer.hasMoreTokens()) {
            model.setAnno(tokenizer.nextToken() + "%");
        }

        if (tokenizer.hasMoreTokens()) {
            model.setNumero(tokenizer.nextToken() + "%");
        }

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        itemList = srvcBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioLupaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setModel(final ServicioLupaCriterioVO value) {
        model = value;
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
