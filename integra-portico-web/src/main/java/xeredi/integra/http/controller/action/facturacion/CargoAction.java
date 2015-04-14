package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
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
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoAction.
 */
public final class CargoAction extends ItemAction implements ModelDriven<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5711768506965624584L;

    /** The crgo. */
    private CargoVO model;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setId(model.getId());
        crgoCriterio.setFechaVigencia(getFechaVigencia());
        crgoCriterio.setIdioma(getIdioma());

        model = crgoBO.selectObject(crgoCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.crgv, model.getCrgv().getId());

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(model.getId());
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
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            if (getFechaVigencia() == null) {
                setFechaVigencia(Calendar.getInstance().getTime());
            }

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getId());
            crgoCriterio.setFechaVigencia(getFechaVigencia());
            crgoCriterio.setIdioma(getIdioma());

            model = crgoBO.selectObject(crgoCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.crgv, model.getCrgv().getId());
        } else {
            model = new CargoVO();
            model.setCrgv(new CargoVersionVO());
            model.getCrgv().setFini(Calendar.getInstance().getTime());

            tpsrList = TipoServicioProxy.selectLabelValues();
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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getCrgv());

        if (ACCION_EDICION.create == getAccion()) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_codigo, model.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_tpsr, model.getTpsr());
        }

        if (ACCION_EDICION.create != getAccion()) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getCrgv().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.crgo_tipo, model.getCrgv().getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_temporal, model.getCrgv().getTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_principal, model.getCrgv().getPrincipal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_fini, model.getCrgv().getFini());

        if (!hasErrors()) {
            final CargoBO crgoBO = new CargoBO();

            switch (getAccion()) {
            case create:
                crgoBO.insert(model, i18nMap);

                break;
            case edit:
                crgoBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion no valida: " + getAccion());
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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getCrgv());
        Preconditions.checkNotNull(model.getCrgv().getId());

        final CargoBO crgoBO = new CargoBO();

        crgoBO.delete(model.getCrgv().getId());

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
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoVO getModel() {
        return model;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the new crgo
     */
    public void setModel(final CargoVO value) {
        model = value;
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
