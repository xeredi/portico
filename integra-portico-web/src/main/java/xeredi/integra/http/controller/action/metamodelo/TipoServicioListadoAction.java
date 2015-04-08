package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class TipoServicioListadoAction extends PaginableAction implements ModelDriven<TipoServicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1106261956835773345L;

    /** The list. */
    private PaginatedList<TipoServicioVO> entiList;

    /** The tppr criterio. */
    private TipoServicioCriterioVO model;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpsr-list")
    public String list() {
        if (model == null) {
            model = new TipoServicioCriterioVO();
        }

        if (model.getCodigo() != null) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de servicio
        model.setTipo(TipoEntidad.T);
        model.setIdioma(getIdioma());

        final TipoServicioBO tpsrBO = new TipoServicioBO();

        entiList = tpsrBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("tpsr-filter")
    public static String filter() {
        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoServicioCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoServicioCriterioVO value) {
        model = value;
    }

    /**
     * Gets the enti list.
     *
     * @return the enti list
     */
    public PaginatedList<TipoServicioVO> getEntiList() {
        return entiList;
    }

}
