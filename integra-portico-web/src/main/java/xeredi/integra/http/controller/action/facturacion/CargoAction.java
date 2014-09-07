package xeredi.integra.http.controller.action.facturacion;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Cargo;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoTipo;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoAction.
 */
public final class CargoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5711768506965624584L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The crgo. */
    private CargoVO crgo;

    /** The fecha vigencia. */
    private Date fechaVigencia;

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
     */
    @Actions({ @Action("crgo-detail") })
    public String detalle() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkArgument(crgo.getId() != null && fechaVigencia != null || crgo.getCrgv() != null
                && crgo.getCrgv().getId() != null);

        final Cargo crgoBO = BOFactory.getInjector().getInstance(CargoBO.class);
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setId(crgo.getId());
        crgoCriterioVO.setFechaVigencia(fechaVigencia);

        if (crgo.getCrgv() != null) {
            crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());
        }

        crgo = crgoBO.select(crgoCriterioVO);

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Actions({ @Action("crgo-create") })
    public String alta() {
        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Actions({ @Action("crgo-edit") })
    public String modificar() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        accion = ACCION_EDICION.edit;

        final Cargo crgoBO = BOFactory.getInjector().getInstance(CargoBO.class);
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());

        crgo = crgoBO.select(crgoCriterioVO);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the tipos.
     *
     * @return the tipos
     */
    public CargoTipo[] getTipos() {
        return CargoTipo.values();
    }

    /**
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the new crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

}
