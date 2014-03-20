package xeredi.integra.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.estadistica.PeriodoProceso;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.estadistica.PeriodoProcesoCriterioVO;
import xeredi.integra.model.vo.estadistica.PeriodoProcesoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListadoAction.
 */
public final class PeriodoProcesoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3153358700832148921L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The peprs. */
    private PaginatedList<PeriodoProcesoVO> peprs;

    /** The page. */
    private int page;

    /** The pepr criterio form. */
    private PeriodoProcesoCriterioVO peprCriterio;

    /**
     * Instantiates a new periodo proceso listado action.
     */
    public PeriodoProcesoListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        peprCriterio = new PeriodoProcesoCriterioVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Editar filtro.
     * 
     * @return the string
     */
    @Actions({ @Action(value = "pepr-filtro"),
        @Action(value = "pepr-filtro-popup", results = { @Result(name = "success", location = "pepr-filtro.jsp") }) })
    public String filtro() {
        return SUCCESS;
    }

    /**
     * Listado.
     * 
     * @return the string
     */
    @Action(value = "pepr-listado")
    public String listado() {
        if (hasErrors()) {
            return INPUT;
        }

        final PeriodoProceso peprBO = BOFactory.getInjector().getInstance(PeriodoProceso.class);

        peprs = peprBO.selectList(peprCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

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
     * Gets the pepr criterio.
     * 
     * @return the pepr criterio
     */
    public PeriodoProcesoCriterioVO getPeprCriterio() {
        return peprCriterio;
    }

    /**
     * Sets the pepr criterio.
     * 
     * @param value
     *            the new pepr criterio
     */
    public void setPeprCriterio(final PeriodoProcesoCriterioVO value) {
        peprCriterio = value;
    }

    /**
     * Gets the peprs.
     * 
     * @return the peprs
     */
    public PaginatedList<PeriodoProcesoVO> getPeprs() {
        return peprs;
    }

    /**
     * Gets the autps.
     * 
     * @return the autps
     */
    public List<LabelValueVO> getAutps() {
        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);
        final Set<Long> tpprIds = new HashSet<>();

        tpprIds.add(Entidad.AUTORIDAD_PORTUARIA.getId());

        return prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getIdioma()).get(
                Entidad.AUTORIDAD_PORTUARIA.getId());
    }

}
