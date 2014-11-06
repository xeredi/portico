package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class TipoServicioListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1106261956835773345L;

    /** The list. */
    private PaginatedList<TipoServicioVO> entiList;

    /** The tppr criterio. */
    private TipoServicioCriterioVO entiCriterio;

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("tpsr-list")
    public String list() {
        if (entiCriterio == null) {
            entiCriterio = new TipoServicioCriterioVO();
        }

        if (entiCriterio.getCodigo() != null) {
            entiCriterio.setCodigo(entiCriterio.getCodigo().toUpperCase());
        }

        // Traemos solo los tipos de servicio
        entiCriterio.setTipo(TipoEntidad.T);
        entiCriterio.setIdioma(getIdioma());

        final TipoServicioBO tpsrBO = new TipoServicioBO();

        entiList = tpsrBO.selectList(entiCriterio, PaginatedList.getOffset(getPage(), ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("tpsr-filter")
    public static String filter() {
        return SUCCESS;
    }

    // get / set
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
    public void setEntiCriterio(final TipoServicioCriterioVO value) {
        entiCriterio = value;
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
