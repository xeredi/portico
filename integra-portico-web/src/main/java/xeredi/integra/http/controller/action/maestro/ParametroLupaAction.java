package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.LupaAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroLupaAction.
 */
public final class ParametroLupaAction extends LupaAction implements ModelDriven<ParametroLupaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5446558166864475230L;

    /** The criterio vo. */
    private ParametroLupaCriterioVO model;

    /** The prmts. */
    private List<ParametroVO> itemList;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final TipoParametroVO enti = TipoParametroProxy.select(model.getEntiId());

        if (enti.isI18n()) {
            model.setIdioma(getIdioma());
        } else if (enti.getTpdtNombre() != null) {
            model.setTpdtNombreId(enti.getTpdtNombre().getId());
        }

        itemList = prmtBO.selectLupaList(model, getLimit());

        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public ParametroLupaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item lupa criterio.
     *
     * @param value
     *            the new item lupa criterio
     */
    public void setModel(final ParametroLupaCriterioVO value) {
        model = value;
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
