package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TramiteBO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteSaveAction.
 */
public final class TramiteSaveAction extends CrudSaveAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6857018201060457551L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TramiteBO trmtBO = new TramiteBO();

        switch (accion) {
        case create:
            trmtBO.insert(model, i18nMap);

            break;
        case edit:
            trmtBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Invalid action: " + accion.name());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        switch (accion) {
        case create:
            FieldValidator.validateRequired(this, MessageI18nKey.trmt_estado_orig, model.getEstadoOrig());
            FieldValidator.validateRequired(this, MessageI18nKey.trmt_estado_dest, model.getEstadoDest());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            break;
        default:
            throw new Error("Invalid action: " + accion.name());
        }

        FieldValidator.validateI18n(this, i18nMap);
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
