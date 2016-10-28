package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new modulo save action.
 */
@Data
public final class ModuloSaveAction  extends CrudSaveAction<ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8050794442778503887L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.mdlo;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ModuloBO mdloBO = new ModuloBO();

        switch (accion) {
        case create:
            mdloBO.insert(model, i18nMap);

            break;
        case edit:
            mdloBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        if (accion == AccionCodigo.create) {
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.mdlo_codigo, model.getCodigo());

        FieldValidator.validateI18n(this, i18nMap);
    }
}
