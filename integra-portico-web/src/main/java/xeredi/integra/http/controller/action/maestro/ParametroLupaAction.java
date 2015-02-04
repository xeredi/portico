package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroLupaAction.
 */
public final class ParametroLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5446558166864475230L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getInt(ConfigurationKey.filter_limit);

    /** The prmts. */
    private List<ParametroVO> itemList;

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-lupa")
    public String lupa() throws ApplicationException {
        Preconditions.checkNotNull(itemLupaCriterio);
        Preconditions.checkNotNull(itemLupaCriterio.getEntiId());
        Preconditions.checkNotNull(itemLupaCriterio.getTextoBusqueda());

        if (itemLupaCriterio.getFechaVigencia() == null) {
            itemLupaCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(itemLupaCriterio.getEntiId());
        final TipoParametroVO enti = TipoParametroProxy.select(itemLupaCriterio.getEntiId());

        if (enti.getI18n()) {
            itemLupaCriterio.setIdioma(getIdioma());
        } else {
            itemLupaCriterio.setTpdtNombreId(enti.getTpdtNombre().getId());
        }

        itemList = prmtBO.selectLupaList(itemLupaCriterio, ROWS);

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
    public List<ParametroVO> getItemList() {
        return itemList;
    }

}
