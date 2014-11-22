package xeredi.integra.http.controller.action.estadistica;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.CuadroMesBO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.CuadroMesVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

import com.google.common.base.Preconditions;

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

    // acciones web
    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdms-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final CuadroMesBO cdmsBO = new CuadroMesBO();

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
