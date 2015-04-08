package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListadoAction.
 */
public final class TipoParametroListadoAction extends PaginableAction implements ModelDriven<TipoParametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2703813016286375196L;

    /** The list. */
    private PaginatedList<TipoParametroVO> entiList;

    /** The tppr criterio. */
    private TipoParametroCriterioVO model;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tppr-list")
    public String list() {
        if (model == null) {
            model = new TipoParametroCriterioVO();
        }

        if (model.getCodigo() != null) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }

        final TipoParametroBO tpprBO = new TipoParametroBO();

        // Traemos solo los maestros
        model.setTipo(TipoEntidad.P);
        model.setIdioma(getIdioma());

        entiList = tpprBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action("tppr-filter") })
    public static String filter() {
        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoParametroCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoParametroCriterioVO value) {
        model = value;
    }

    /**
     * Gets the enti list.
     *
     * @return the enti list
     */
    public PaginatedList<TipoParametroVO> getEntiList() {
        return entiList;
    }

}
