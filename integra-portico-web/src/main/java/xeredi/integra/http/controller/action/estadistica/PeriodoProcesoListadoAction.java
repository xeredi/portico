package xeredi.integra.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListadoAction.
 */
public final class PeriodoProcesoListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3153358700832148921L;

    /** The peprs. */
    private PaginatedList<PeriodoProcesoVO> peprList;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /** The pepr criterio form. */
    private PeriodoProcesoCriterioVO peprCriterio;

    /** The subps. */
    private List<LabelValueVO> autpList;

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("pepr-filter")
    public String filtro() {
        setFechaVigencia(Calendar.getInstance().getTime());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("pepr-list")
    public String listado() {
        if (peprCriterio == null) {
            peprCriterio = new PeriodoProcesoCriterioVO();
        }

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprList = peprBO.selectList(peprCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

        return SUCCESS;
    }

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.AUTORIDAD_PORTUARIA.getId());
        final Set<Long> tpprIds = new HashSet<>();

        tpprIds.add(Entidad.AUTORIDAD_PORTUARIA.getId());

        autpList = prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()).get(
                Entidad.AUTORIDAD_PORTUARIA.getId());
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
     * Gets the autp list.
     *
     * @return the autp list
     */
    public List<LabelValueVO> getAutpList() {
        return autpList;
    }

    /**
     * Gets the limits.
     *
     * @return the limits
     */
    public int[] getLimits() {
        return VALID_ROWS_PER_PAGE;
    }

}
