package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.I18nValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
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

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The rgla list. */
    private final List<ReglaVO> rglaList = new ArrayList<>();

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Instantiates a new cargo action.
     */
    public CargoAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
    }

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
        Preconditions.checkNotNull(crgo.getId());

        final CargoBO crgoBO = new CargoBO();
        final I18nBO i18nBO = new I18nBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setId(crgo.getId());
        crgoCriterioVO.setFechaVigencia(fechaVigencia);
        crgoCriterioVO.setIdioma(getIdioma());

        crgo = crgoBO.select(crgoCriterioVO);
        i18nMap = i18nBO.selectMap(I18nPrefix.crgv, crgo.getCrgv().getId());

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
        final I18nBO i18nBO = new I18nBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());
        crgoCriterioVO.setIdioma(getIdioma());

        crgo = crgoBO.select(crgoCriterioVO);
        i18nMap = i18nBO.selectMap(I18nPrefix.crgv, crgo.getCrgv().getId());

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
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.crgo_codigo.name()) }));
            }

            if (crgo.getTpsr() == null || crgo.getTpsr().getId() == null) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.crgo_tpsr.name()) }));
            }
        }

        if (ACCION_EDICION.create != accion) {
            Preconditions.checkNotNull(crgo.getId());
            Preconditions.checkNotNull(crgo.getCrgv().getId());
        }

        I18nValidator.validate(this, i18nMap);

        if (crgo.getCrgv().getTipo() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.crgo_tipo.name()) }));
        }
        if (crgo.getCrgv().getTemporal() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.crgo_temporal.name()) }));
        }
        if (crgo.getCrgv().getPrincipal() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.crgo_principal.name()) }));
        }
        if (crgo.getCrgv().getFini() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.crgo_fini.name()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final CargoBO crgoBO = new CargoBO();

        switch (accion) {
        case create:
            try {
                crgoBO.insert(crgo, i18nMap);
            } catch (final OverlapException ex) {
                addActionError(getText(MessageI18nKey.E00009.name(),
                        new String[] { getText(MessageI18nKey.crgo.name()) }));
            }

            break;
        case edit:
            try {
                crgoBO.update(crgo, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                    getText(MessageI18nKey.crgo.name()), crgo.getCodigo() }));
            } catch (final OverlapException ex) {
                addActionError(getText(MessageI18nKey.E00009.name(),
                        new String[] { getText(MessageI18nKey.crgo.name()) }));
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
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.crgo.name()),
                crgo.getCodigo() }));
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

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

}
