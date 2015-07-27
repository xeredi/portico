package xeredi.integra.http.controller.action.administracion.puerto;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.SuperpuertoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoSaveAction.
 */
public final class SuperpuertoSaveAction extends CrudSaveAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1633665993855067357L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        switch (accion) {
        case create:
            sprtBO.insert(model, i18nMap);

            break;
        case edit:
            sprtBO.update(model, i18nMap);

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
        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.sprt_codigo, model.getCodigo());

        FieldValidator.validateI18n(this, i18nMap);
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public final void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }
}