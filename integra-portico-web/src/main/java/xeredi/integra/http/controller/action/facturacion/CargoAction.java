package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.CargoTipo;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.CargoVersionVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.applicationobjects.LabelValueVO;

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
    private List<ReglaVO> rglaList;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("crgo-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        crgo = crgoBO.select(crgo.getId(), getFechaVigencia(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.crgv, crgo.getCrgv().getId());

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(crgo.getId());
        rglaCriterioVO.setFechaVigencia(getFechaVigencia());

        rglaList = rglaBO.selectList(rglaCriterioVO);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("crgo-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(crgo);
            Preconditions.checkNotNull(crgo.getId());

            if (getFechaVigencia() == null) {
                setFechaVigencia(Calendar.getInstance().getTime());
            }

            final CargoBO crgoBO = new CargoBO();

            crgo = crgoBO.select(crgo.getId(), getFechaVigencia(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.crgv, crgo.getCrgv().getId());
        } else {
            crgo = new CargoVO();
            crgo.setCrgv(new CargoVersionVO());
            crgo.getCrgv().setFini(Calendar.getInstance().getTime());

            loadLabelValues();
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("crgo-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());

        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_codigo, crgo.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_tpsr, crgo.getTpsr());
        }

        if (ACCION_EDICION.create != accion) {
            Preconditions.checkNotNull(crgo.getId());
            Preconditions.checkNotNull(crgo.getCrgv().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.crgo_tipo, crgo.getCrgv().getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_temporal, crgo.getCrgv().getTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_principal, crgo.getCrgv().getPrincipal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_fini, crgo.getCrgv().getFini());

        if (!hasErrors()) {
            final CargoBO crgoBO = new CargoBO();

            switch (accion) {
            case create:
                crgoBO.insert(crgo, i18nMap);

                break;
            case edit:
                crgoBO.update(crgo, i18nMap);

                break;
            default:
                throw new Error("Accion no valida: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("crgo-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final CargoBO crgoBO = new CargoBO();

        crgoBO.delete(crgo.getCrgv().getId());

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.T);
        entiCriterioVO.setIdioma(getIdioma());

        tpsrList = entiBO.selectLabelValues(entiCriterioVO);
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
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
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
