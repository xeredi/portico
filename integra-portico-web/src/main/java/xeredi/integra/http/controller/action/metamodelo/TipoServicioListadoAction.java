package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.TipoServicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoServicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
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
    private PaginatedList<TipoServicioVO> tpsrs;

    /** The tppr criterio. */
    private TipoServicioCriterioVO tpsrCriterio;

    /** The page. */
    private int page;

    /**
     * Instantiates a new tipo servicio listado action.
     */
    public TipoServicioListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        tpsrCriterio = new TipoServicioCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action(value = "tpsr-listado")
    public String listado() {
        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicio.class);

        if (tpsrCriterio.getCodigo() != null) {
            tpsrCriterio.setCodigo(tpsrCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de servicio
        tpsrCriterio.setTipo(TipoEntidad.T);

        tpsrs = tpsrBO.selectList(tpsrCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "tpsr-filtro"),
        @Action(value = "tpsr-filtro-popup", results = { @Result(name = "success", location = "tpsr-filtro.jsp") }) })
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
    public PaginatedList<TipoServicioVO> getTpsrs() {
        return tpsrs;
    }

    /**
     * Gets the tpsr criterio.
     *
     * @return the tpsr criterio
     */
    public TipoServicioCriterioVO getTpsrCriterio() {
        return tpsrCriterio;
    }

    /**
     * Sets the tpsr criterio.
     *
     * @param value
     *            the new tpsr criterio
     */
    public void setTpsrCriterio(final TipoServicioCriterioVO value) {
        tpsrCriterio = value;
    }

}
