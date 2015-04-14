package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroListadoAction.
 */
public final class SubparametroListadoAction extends PaginableAction implements ModelDriven<SubparametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8182660007822844841L;

    /** The item criterio. */
    private SubparametroCriterioVO model;

    /** The item list. */
    private PaginatedList<SubparametroVO> itemList;

    /** The enti. */
    private TipoSubparametroDetailVO enti;

    /**
     * Listado.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("sprm-list")
    public String listado() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getPrmt().getId());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        enti = TipoSubparametroProxy.select(model.getEntiId());

        final SubparametroBO sprmBO = new SubparametroBO();

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        model.setSoloDatosGrid(true);
        model.setIdioma(getIdioma());

        itemList = sprmBO.selectList(model, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubparametroCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setModel(final SubparametroCriterioVO value) {
        model = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public PaginatedList<SubparametroVO> getItemList() {
        return itemList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubparametroDetailVO getEnti() {
        return enti;
    }

}
