package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListadoAction.
 */
public final class PeriodoProcesoListadoAction extends PaginableAction implements ModelDriven<PeriodoProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3153358700832148921L;

    /** The pepr criterio form. */
    private PeriodoProcesoCriterioVO model;

    /** The peprs. */
    private PaginatedList<PeriodoProcesoVO> peprList;

    /** The subps. */
    private List<SuperpuertoVO> sprtList;

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("pepr-filter")
    public String filtro() {
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
        if (model == null) {
            model = new PeriodoProcesoCriterioVO();
        }

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprList = peprBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Load label values map.
     */
    private void loadLabelValuesMap() {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtList = sprtBO.selectList(sprtCriterio);
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public PeriodoProcesoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the pepr criterio.
     *
     * @param value
     *            the new pepr criterio
     */
    public void setModel(final PeriodoProcesoCriterioVO value) {
        model = value;
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
    public List<SuperpuertoVO> getSprtList() {
        return sprtList;
    }

}
