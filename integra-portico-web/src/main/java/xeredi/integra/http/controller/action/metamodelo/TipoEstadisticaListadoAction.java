package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListadoAction.
 */
public final class TipoEstadisticaListadoAction extends PaginableAction implements
ModelDriven<TipoEstadisticaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3298081565039330996L;

    /** The list. */
    private PaginatedList<TipoEstadisticaVO> entiList;

    /** The tpes criterio. */
    private TipoEstadisticaCriterioVO model;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpes-list")
    public String list() {
        if (model == null) {
            model = new TipoEstadisticaCriterioVO();
        }

        if (model.getCodigo() != null) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de estadistica
        model.setTipo(TipoEntidad.E);
        model.setIdioma(getIdioma());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        entiList = tpesBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action("tpes-filter") })
    public String filter() {
        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoEstadisticaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoEstadisticaCriterioVO value) {
        model = value;
    }

    /**
     * Gets the enti list.
     *
     * @return the enti list
     */
    public PaginatedList<TipoEstadisticaVO> getEntiList() {
        return entiList;
    }

}
