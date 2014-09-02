package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoEstadistica;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListadoAction.
 */
public final class TipoEstadisticaListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3298081565039330996L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The list. */
    private PaginatedList<TipoEstadisticaVO> tpess;

    /** The tpes criterio. */
    private TipoEstadisticaCriterioVO tpesCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo estadistica listado action.
     */
    public TipoEstadisticaListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        tpesCriterio = new TipoEstadisticaCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action(value = "tpes-listado")
    public String listado() {
        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadisticaBO.class);

        if (tpesCriterio.getCodigo() != null) {
            tpesCriterio.setCodigo(tpesCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de estadistica
        tpesCriterio.setTipo(TipoEntidad.E);

        tpess = tpesBO.selectList(tpesCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({
        @Action(value = "tpes-filtro"),
        @Action(value = "tpes-filtro-popup", results = { @Result(name = "success", location = "tpes-filtro.jsp") }) })
    public String editarFiltro() {
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
    public PaginatedList<TipoEstadisticaVO> getTpess() {
        return tpess;
    }

    /**
     * Gets the tpes criterio.
     *
     * @return the tpes criterio
     */
    public TipoEstadisticaCriterioVO getTpesCriterio() {
        return tpesCriterio;
    }

    /**
     * Sets the tpes criterio.
     *
     * @param value
     *            the new tpes criterio
     */
    public void setTpesCriterio(final TipoEstadisticaCriterioVO value) {
        tpesCriterio = value;
    }

}
