package xeredi.integra.http.controller.action.facturacion;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoSaveAction.
 */
public final class CargoSaveAction extends CrudSaveAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4637124394309482562L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        switch (accion) {
        case create:
            crgoBO.insert(model, i18nMap);

            break;
        case edit:
            crgoBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_codigo, model.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.crgo_tipo, model.getVersion().getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_temporal, model.getVersion().getTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_principal, model.getVersion().getPrincipal());
        FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
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
