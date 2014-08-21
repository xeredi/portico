package xeredi.integra.http.controller.action.estadistica;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.estadistica.CuadroMes;
import xeredi.integra.model.bo.estadistica.PeriodoProceso;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.estadistica.vo.CuadroMesVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesAction.
 */
public final class CuadroMesAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6080323896171314975L;

    /** The cdms map. */
    private Map<String, List<CuadroMesVO>> cdmsMap;

    /** The pepr id. */
    private PeriodoProcesoVO pepr;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web
    /**
     * Detalle.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cdms-detalle")
    public String detalle() throws InstanceNotFoundException {
        if (pepr == null || pepr.getId() == null) {
            throw new Error("Periodo de Proceso nulo");
        }

        final PeriodoProceso peprBO = BOFactory.getInjector().getInstance(PeriodoProceso.class);
        final CuadroMes cdmsBO = BOFactory.getInjector().getInstance(CuadroMes.class);

        pepr = peprBO.select(pepr.getId());
        cdmsMap = cdmsBO.selectMap(pepr.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the cdms map.
     * 
     * @return the cdms map
     */
    public Map<String, List<CuadroMesVO>> getCdmsMap() {
        return cdmsMap;
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
