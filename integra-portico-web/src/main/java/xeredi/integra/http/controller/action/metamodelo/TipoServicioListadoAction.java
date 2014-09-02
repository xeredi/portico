package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoServicio;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class TipoServicioListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1106261956835773345L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The list. */
    private PaginatedList<TipoServicioVO> entiList;

    /** The tppr criterio. */
    private TipoServicioCriterioVO entiCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo servicio listado action.
     */
    public TipoServicioListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        entiCriterio = new TipoServicioCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpsr-listado")
    public String listado() {
        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicioBO.class);

        if (entiCriterio.getCodigo() != null) {
            entiCriterio.setCodigo(entiCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de servicio
        entiCriterio.setTipo(TipoEntidad.T);

        entiList = tpsrBO.selectList(entiCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action("tpsr-filtro") })
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
     * Gets the enti criterio.
     *
     * @return the enti criterio
     */
    public TipoServicioCriterioVO getEntiCriterio() {
        return entiCriterio;
    }

    /**
     * Sets the enti criterio.
     *
     * @param value
     *            the enti criterio
     */
    public void setEntiCriterio(TipoServicioCriterioVO value) {
        this.entiCriterio = value;
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
