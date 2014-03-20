package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.metamodelo.TipoDato;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.metamodelo.TipoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoListadoAction.
 */
public final class TipoDatoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9073603323433179379L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The list. */
    private PaginatedList<TipoDatoVO> tpdts;

    /** The tpdt criterio. */
    private TipoDatoCriterioVO tpdtCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo dato listado action.
     */
    public TipoDatoListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        tpdtCriterio = new TipoDatoCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action(value = "tpdt-listado")
    public String listado() {
        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDato.class);

        tpdts = tpdtBO.selectList(tpdtCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "tpdt-filtro"),
        @Action(value = "tpdt-filtro-popup", results = { @Result(name = "success", location = "tpdt-filtro.jsp") }) })
    public static String editarFiltro() {
        return SUCCESS;
    }

    // get / set
    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public PaginatedList<TipoDatoVO> getTpdts() {
        return tpdts;
    }

    /**
     * Gets the tphts.
     *
     * @return the tphts
     */
    public TipoHtml[] getTphts() {
        return TipoHtml.values();
    }

    /**
     * Gets the tpprs.
     *
     * @return the tpprs
     */
    public List<LabelValueVO> getEntis() {
        return BOFactory.getInjector().getInstance(Entidad.class).selectLabelValues();
    }

    /**
     * Gets the tipos elemento.
     *
     * @return the tipos elemento
     */
    public TipoElemento[] getTiposElemento() {
        return TipoElemento.values();
    }

    /**
     * Gets the tpdt criterio.
     *
     * @return the tpdt criterio
     */
    public TipoDatoCriterioVO getTpdtCriterio() {
        return tpdtCriterio;
    }

    /**
     * Sets the tpdt criterio.
     *
     * @param value
     *            the new tpdt criterio
     */
    public void setTpdtCriterio(final TipoDatoCriterioVO value) {
        tpdtCriterio = value;
    }
}
