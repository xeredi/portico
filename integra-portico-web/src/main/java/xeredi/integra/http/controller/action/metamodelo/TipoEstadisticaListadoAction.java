package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
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
    private PaginatedList<TipoEstadisticaVO> entiList;

    /** The tpes criterio. */
    private TipoEstadisticaCriterioVO entiCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo estadistica listado action.
     */
    public TipoEstadisticaListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        entiCriterio = new TipoEstadisticaCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpes-list")
    public String list() {
        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        if (entiCriterio.getCodigo() != null) {
            entiCriterio.setCodigo(entiCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de estadistica
        entiCriterio.setTipo(TipoEntidad.E);

        entiList = tpesBO.selectList(entiCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

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
    public TipoEstadisticaCriterioVO getEntiCriterio() {
        return entiCriterio;
    }

    /**
     * Sets the enti criterio.
     *
     * @param value
     *            the enti criterio
     */
    public void setEntiCriterio(final TipoEstadisticaCriterioVO value) {
        entiCriterio = value;
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
