package xeredi.integra.http.controller.action.maestro;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroLupaAction.
 */
@ParentPackage("json-default")
public final class ParametroLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5446558166864475230L;

    /** The Constant ROWS. */
    private static final int ROWS = 5;

    /** The prmts. */
    private List<LabelValueVO> itemList;

    /** The criterio vo. */
    private ParametroLupaCriterioVO itemLupaCriterio;

    /**
     * Instantiates a new parametro lupa action.
     */
    public ParametroLupaAction() {
        super();
    }

    // Acciones Web
    /**
     * Editar lupa.
     *
     * @return the string
     */
    @Action(value = "prmt-lupa", results = { @Result(name = "success", type = "json") })
    public String lupa() {
        Preconditions.checkNotNull(itemLupaCriterio);
        Preconditions.checkNotNull(itemLupaCriterio.getEntiId());
        Preconditions.checkNotNull(itemLupaCriterio.getFechaVigencia());
        Preconditions.checkNotNull(itemLupaCriterio.getTextoBusqueda());

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final TipoParametroVO enti = TipoParametroProxy.select(itemLupaCriterio.getEntiId());

        if (enti.getI18n()) {
            itemLupaCriterio.setIdioma(getIdioma());
        } else {
            itemLupaCriterio.setTpdtNombreId(enti.getTpdtNombreId());
        }

        itemLupaCriterio.setLimit(ROWS);

        itemList = prmtBO.selectLupaList(itemLupaCriterio);

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the item lupa criterio.
     *
     * @return the item lupa criterio
     */
    public ParametroLupaCriterioVO getItemLupaCriterio() {
        return itemLupaCriterio;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setItemLupaCriterio(final ParametroLupaCriterioVO value) {
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
