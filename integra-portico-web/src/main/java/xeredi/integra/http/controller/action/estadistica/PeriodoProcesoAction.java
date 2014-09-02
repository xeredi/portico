package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.estadistica.bo.PeriodoProceso;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoAction.
 */
public final class PeriodoProcesoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 849907867635380383L;

    /** The pepr form. */
    private PeriodoProcesoVO pepr;

    /**
     * Instantiates a new periodo proceso action.
     */
    public PeriodoProcesoAction() {
        super();
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
     * Preparar carga.
     *
     * @return the string
     */
    @Action(value = "pepr-preparar-carga", results = { @Result(name = "success", location = "pepr-preparar-carga.jsp") })
    public String prepararCarga() {
        return SUCCESS;
    }

    /**
     * Cargar.
     *
     * @return the string
     */
    @Action(value = "pepr-cargar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "pepr-listado" }),
            @Result(name = "input", location = "pepr-preparar-carga.jsp") })
    public String cargar() {
        PropertyValidator.validateRequired(this, "pepr.anio", pepr.getAnio());
        PropertyValidator.validateRequired(this, "pepr.mes", pepr.getMes());
        PropertyValidator.validateRequired(this, "pepr.autp", pepr.getAutp());

        if (hasErrors()) {
            return INPUT;
        }

        throw new Error("No Implementado");
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action(value = "pepr-borrar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "pepr-listado" }) })
    public String borrar() {
        if (pepr.getId() == null) {
            throw new Error("No se ha especificado un periodo de proceso");
        }

        final PeriodoProceso peprBO = BOFactory.getInjector().getInstance(PeriodoProcesoBO.class);

        peprBO.delete(pepr.getId());

        addActionMessage("Periodo de proceso borrado correctamente");

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "pepr-detalle")
    public String detalle() throws InstanceNotFoundException {
        if (pepr.getId() == null) {
            throw new Error("No se ha especificado un periodo de proceso");
        }

        final PeriodoProceso peprBO = BOFactory.getInjector().getInstance(PeriodoProcesoBO.class);

        pepr = peprBO.select(pepr.getId());

        return SUCCESS;
    }

    /**
     * Exportar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "pepr-exportar")
    public String exportar() throws InstanceNotFoundException {
        if (pepr.getId() == null) {
            throw new Error("No se ha especificado un periodo de proceso");
        }

        throw new Error("No implementado");
    }

    // get / set

    /**
     * Gets the tpess.
     *
     * @return the tpess
     */
    public List<LabelValueVO> getTpess() {
        return TipoEstadisticaProxy.selectLabelValues();
    }

    /**
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
    }

}
