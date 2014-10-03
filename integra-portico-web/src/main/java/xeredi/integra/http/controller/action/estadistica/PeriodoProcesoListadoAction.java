package xeredi.integra.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.GlobalNames;
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
    private PaginatedList<PeriodoProcesoVO> peprList;

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
    @Action("pepr-filter")
    public String filtro() {
        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("pepr-list")
    public String listado() {
        if (hasErrors()) {
            return INPUT;
        }

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprList = peprBO.selectList(peprCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

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
    public PaginatedList<PeriodoProcesoVO> getPeprList() {
        return peprList;
    }

    /**
     * Gets the autps.
     *
     * @return the autps
     */
    public List<ParametroVO> getAutps() {
        final ParametroBO prmtBO = new ParametroBO();
        final Set<Long> tpprIds = new HashSet<>();

        tpprIds.add(Entidad.AUTORIDAD_PORTUARIA.getId());

        return prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getIdioma()).get(
                Entidad.AUTORIDAD_PORTUARIA.getId());
    }

}
