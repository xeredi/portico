package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoListadoAction.
 */
public final class TipoDatoListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9073603323433179379L;

    /** The list. */
    private PaginatedList<TipoDatoVO> tpdtList;

    /** The tpdt criterio. */
    private TipoDatoCriterioVO tpdtCriterio;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpdt-list")
    public String list() {
        if (tpdtCriterio == null) {
            tpdtCriterio = new TipoDatoCriterioVO();
        }

        tpdtCriterio.setIdioma(getIdioma());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtList = tpdtBO.selectList(tpdtCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

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
    public PaginatedList<TipoDatoVO> getTpdtList() {
        return tpdtList;
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
