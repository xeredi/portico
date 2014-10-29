package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListadoAction.
 */
public final class TipoParametroListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2703813016286375196L;

    /** The list. */
    private PaginatedList<TipoParametroVO> entiList;

    /** The tppr criterio. */
    private TipoParametroCriterioVO entiCriterio;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tppr-list")
    public String list() {
        if (entiCriterio == null) {
            entiCriterio = new TipoParametroCriterioVO();
        }

        if (entiCriterio.getCodigo() != null) {
            entiCriterio.setCodigo(entiCriterio.getCodigo().toUpperCase());
        }

        final TipoParametroBO tpprBO = new TipoParametroBO();

        // Traemos solo los maestros
        entiCriterio.setTipo(TipoEntidad.P);
        entiCriterio.setIdioma(getIdioma());

        entiList = tpprBO.selectList(entiCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

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
     * Gets the enti criterio.
     *
     * @return the enti criterio
     */
    public TipoParametroCriterioVO getEntiCriterio() {
        return entiCriterio;
    }

    /**
     * Sets the enti criterio.
     *
     * @param value
     *            the enti criterio
     */
    public void setEntiCriterio(final TipoParametroCriterioVO value) {
        entiCriterio = value;
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
