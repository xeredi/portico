package xeredi.integra.http.controller.action.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoEstado;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListadoAction.
 */
public final class ProcesoListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8194151847278687792L;

    /** The prbt criterio vo. */
    private ProcesoCriterioVO prbtCriterio;

    /** The prbt list. */
    private PaginatedList<ProcesoVO> prbtList;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("prbt-list")
    public String listado() {
        final ProcesoBO prbtBO = new ProcesoBO();

        if (prbtCriterio == null) {
            prbtCriterio = new ProcesoCriterioVO();
        }

        prbtList = prbtBO.selectList(prbtCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("prbt-filter")
    public String filtro() {
        return SUCCESS;
    }

    // get / set

    /**
     * Gets the proceso tipos.
     *
     * @return the proceso tipos
     */
    public ProcesoTipo[] getProcesoTipos() {
        return ProcesoTipo.values();
    }

    /**
     * Gets the proceso modulos.
     *
     * @return the proceso modulos
     */
    public ProcesoModulo[] getProcesoModulos() {
        return ProcesoModulo.values();
    }

    /**
     * Gets the proceso estados.
     *
     * @return the proceso estados
     */
    public ProcesoEstado[] getProcesoEstados() {
        return ProcesoEstado.values();
    }

    /**
     * Gets the prbt criterio vo.
     *
     * @return the prbt criterio vo
     */
    public ProcesoCriterioVO getPrbtCriterio() {
        return prbtCriterio;
    }

    /**
     * Sets the prbt criterio vo.
     *
     * @param value
     *            the new prbt criterio vo
     */
    public void setPrbtCriterio(final ProcesoCriterioVO value) {
        prbtCriterio = value;
    }

    /**
     * Gets the prbt list.
     *
     * @return the prbt list
     */
    public PaginatedList<ProcesoVO> getPrbtList() {
        return prbtList;
    }

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

}
