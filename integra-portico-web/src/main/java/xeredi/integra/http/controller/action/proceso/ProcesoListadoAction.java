package xeredi.integra.http.controller.action.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.proceso.Proceso;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.proceso.ProcesoCriterioVO;
import xeredi.integra.model.vo.proceso.ProcesoEstado;
import xeredi.integra.model.vo.proceso.ProcesoModulo;
import xeredi.integra.model.vo.proceso.ProcesoTipo;
import xeredi.integra.model.vo.proceso.ProcesoVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListadoAction.
 */
public final class ProcesoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8194151847278687792L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The prbt criterio vo. */
    private ProcesoCriterioVO prbtCriterio;

    /** The prbt list. */
    private PaginatedList<ProcesoVO> prbtList;

    /** The page. */
    private int page;

    /**
     * Instantiates a new proceso listado action.
     */
    public ProcesoListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        prbtCriterio = new ProcesoCriterioVO();
    }

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
    @Actions({
        @Action(value = "prbt-listado"),
        @Action(value = "prbt-listado-json", results = { @Result(name = "success", type = "json", params = {
                "excludeNullProperties", "true" }) }) })
    public String listado() {
        final Proceso prbtBO = BOFactory.getInjector().getInstance(Proceso.class);

        prbtList = prbtBO.selectList(prbtCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "prbt-filtro"),
        @Action(value = "prbt-filtro-popup", results = { @Result(name = "success", location = "prbt-filtro.jsp") }) })
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
