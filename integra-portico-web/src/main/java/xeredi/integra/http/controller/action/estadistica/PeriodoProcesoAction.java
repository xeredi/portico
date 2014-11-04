package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

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
    @Action("pepr-preparar-carga")
    public String prepararCarga() {
        return SUCCESS;
    }

    /**
     * Cargar.
     *
     * @return the string
     */
    @Action("pepr-cargar")
    public String cargar() {
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, pepr);

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, pepr.getAnio());
            FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, pepr.getMes());
            FieldValidator.validateRequired(this, MessageI18nKey.pepr_autp, pepr.getAutp());
        }

        if (!hasErrors()) {
            throw new Error("No Implementado");
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("pepr-remove")
    public String borrar() {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprBO.delete(pepr.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("pepr-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        pepr = peprBO.select(pepr.getId());

        return SUCCESS;
    }

    /**
     * Exportar.
     *
     * @return the string
     */
    @Action("pepr-export")
    public String exportar() {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        throw new Error("No implementado");
    }

    // get / set

    /**
     * Gets the tpess.
     *
     * @return the tpess
     */
    public List<LabelValueVO> getTpesList() {
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
