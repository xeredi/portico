package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.EntidadAccionBO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Grabación de una Acción Específica de Entidad.
 */
public final class EntidadAccionSaveAction extends CrudSaveAction<EntidadAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5020791075508829152L;

    /** The cdri map. */
    @Setter
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enac;
    }
}
