package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListadoAction.
 */
public final class TipoEstadisticaListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3298081565039330996L;

    /** The list. */
    private PaginatedList<TipoEstadisticaVO> entiList;

    /** The tpes criterio. */
    private TipoEstadisticaCriterioVO entiCriterio;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpes-list")
    public String list() {
        if (entiCriterio == null) {
            entiCriterio = new TipoEstadisticaCriterioVO();
        }

        if (entiCriterio.getCodigo() != null) {
            entiCriterio.setCodigo(entiCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de estadistica
        entiCriterio.setTipo(TipoEntidad.E);
        entiCriterio.setIdioma(getIdioma());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        entiList = tpesBO.selectList(entiCriterio, PaginatedList.getOffset(getPage(), ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

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
