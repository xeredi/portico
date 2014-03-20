package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.TipoParametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoParametroCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListadoAction.
 */
public final class TipoParametroListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2703813016286375196L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The list. */
    private PaginatedList<TipoParametroVO> tpprs;

    /** The tppr criterio. */
    private TipoParametroCriterioVO tpprCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo parametro listado action.
     */
    public TipoParametroListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        tpprCriterio = new TipoParametroCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action(value = "tppr-listado")
    public String listado() {
        if (tpprCriterio.getCodigo() != null) {
            tpprCriterio.setCodigo(tpprCriterio.getCodigo().toUpperCase());
        }

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametro.class);

        // Traemos solo los maestros
        tpprCriterio.setTipo(TipoEntidad.P);

        tpprs = tpprBO.selectList(tpprCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({
        @Action(value = "tppr-filtro"),
        @Action(value = "tppr-filtro-popup", results = { @Result(name = "success", location = "tppr-filtro.jsp") }) })
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
    public PaginatedList<TipoParametroVO> getTpprs() {
        return tpprs;
    }

    /**
     * Gets the tppr criterio.
     *
     * @return the tppr criterio
     */
    public TipoParametroCriterioVO getTpprCriterio() {
        return tpprCriterio;
    }

    /**
     * Sets the tppr criterio.
     *
     * @param value
     *            the new tppr criterio
     */
    public void setTpprCriterio(final TipoParametroCriterioVO value) {
        tpprCriterio = value;
    }

}
