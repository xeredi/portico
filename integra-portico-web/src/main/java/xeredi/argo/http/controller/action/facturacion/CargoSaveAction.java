package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoSaveAction.
 */
@Data
public final class CargoSaveAction extends CrudSaveAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4637124394309482562L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.crgo;

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
        if (AccionCodigo.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo_codigo, model.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_tipo, model.getVersion().getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_temporal, model.getVersion().getTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.crgo_principal, model.getVersion().getPrincipal());

        DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        FieldValidator.validateVersion(this, accion, model);
    }
}
