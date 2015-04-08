package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoListadoAction.
 */
public final class TipoDatoListadoAction extends PaginableAction implements ModelDriven<TipoDatoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9073603323433179379L;

    /** The tpdt criterio. */
    private TipoDatoCriterioVO model;

    /** The list. */
    private PaginatedList<TipoDatoVO> tpdtList;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpdt-list")
    public String list() {
        if (model == null) {
            model = new TipoDatoCriterioVO();
        }

        model.setIdioma(getIdioma());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtList = tpdtBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("tpdt-filter")
    public static String filter() {
        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoDatoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoDatoCriterioVO value) {
        model = value;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public PaginatedList<TipoDatoVO> getTpdtList() {
        return tpdtList;
    }

    /**
     * Gets the tphts.
     *
     * @return the tphts
     */
    public TipoHtml[] getTphtList() {
        return TipoHtml.values();
    }

    /**
     * Gets the tipos elemento.
     *
     * @return the tipos elemento
     */
    public TipoElemento[] getTpelList() {
        return TipoElemento.values();
    }
}
