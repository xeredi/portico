package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Grabación de una Acción Específica de Entidad.
 */
public final class EntidadAccionSaveAction extends CrudSaveAction<EntidadAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5020791075508829152L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final EntidadAccionBO enacBO = new EntidadAccionBO();

        switch (accion) {
        case create:
            enacBO.insert(model, i18nMap);

            break;
        case edit:
            enacBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no implementada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enac_path, model.getPath());
        } else {
            Preconditions.checkNotNull(model.getPath());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enac_orden, model.getOrden());
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
