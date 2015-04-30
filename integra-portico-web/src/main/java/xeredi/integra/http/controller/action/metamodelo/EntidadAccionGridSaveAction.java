package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridSaveAction.
 */
public final class EntidadAccionGridSaveAction extends CrudSaveAction<EntidadAccionGridVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1043893285126622890L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        switch (accion) {
        case create:
            enagBO.insert(model, i18nMap);

            break;
        case edit:
            enagBO.update(model, i18nMap);

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
        Preconditions.checkNotNull(model.getEntiId());

        switch (accion) {
        case create:
            FieldValidator.validateRequired(this, MessageI18nKey.enag_path, model.getPath());

            break;
        case edit:
            Preconditions.checkNotNull(model.getPath());

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enag_orden, model.getOrden());
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
