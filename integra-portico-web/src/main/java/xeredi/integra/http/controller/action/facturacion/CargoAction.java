package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoTipo;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.CargoVersionVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.InstanceNotFoundException;

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

    /** The rgla list. */
    private final List<ReglaVO> rglaList = new ArrayList<>();

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
    @Action("crgo-detail")
    public String detail() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkArgument(crgo.getId() != null && fechaVigencia != null || crgo.getCrgv() != null
                && crgo.getCrgv().getId() != null);

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setId(crgo.getId());
        crgoCriterioVO.setFechaVigencia(fechaVigencia);

        if (crgo.getCrgv() != null) {
            crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());
        }

        crgo = crgoBO.select(crgoCriterioVO);

        if (crgo != null) {
            final ReglaBO rglaBO = new ReglaBO();
            final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

            rglaCriterioVO.setCrgvId(crgo.getCrgv().getId());
            rglaList.addAll(rglaBO.selectList(rglaCriterioVO));
        }

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("crgo-create")
    public String create() {
        accion = ACCION_EDICION.create;

        crgo = new CargoVO();
        crgo.setCrgv(new CargoVersionVO());
        crgo.getCrgv().setFini(Calendar.getInstance().getTime());

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("crgo-edit")
    public String edit() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        accion = ACCION_EDICION.edit;

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());

        crgo = crgoBO.select(crgoCriterioVO);

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("crgo-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());

        if (ACCION_EDICION.create == accion) {
            if (GenericValidator.isBlankOrNull(crgo.getCodigo())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_codigo") }));
            }

            if (crgo.getTpsr() == null || crgo.getTpsr().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_tpsr") }));
            }
        }

        if (ACCION_EDICION.create != accion) {
            Preconditions.checkNotNull(crgo.getId());
            Preconditions.checkNotNull(crgo.getCrgv().getId());
        }

        if (GenericValidator.isBlankOrNull(crgo.getCrgv().getDescripcion())) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_descripcion") }));
        }
        if (crgo.getCrgv().getTipo() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_tipo") }));
        }
        if (crgo.getCrgv().getTemporal() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_temporal") }));
        }
        if (crgo.getCrgv().getPrincipal() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_principal") }));
        }
        if (crgo.getCrgv().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("crgo_fini") }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final CargoBO crgoBO = new CargoBO();

        switch (accion) {
        case create:
            try {
                crgoBO.insert(crgo);
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("crgo") }));
            }

            break;
        case edit:
            try {
                crgoBO.update(crgo);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("crgo"), crgo.getCodigo() }));
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("crgo") }));
            }

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("crgo-remove")
    public String remove() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final CargoBO crgoBO = new CargoBO();

        try {
            crgoBO.delete(crgo);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("crgo"), crgo.getCodigo() }));
        }

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

    /**
     * Gets the rgla list.
     *
     * @return the rgla list
     */
    public List<ReglaVO> getRglaList() {
        return rglaList;
    }

}
