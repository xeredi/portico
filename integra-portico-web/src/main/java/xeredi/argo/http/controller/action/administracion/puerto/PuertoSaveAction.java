package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoSaveAction.
 */
public final class PuertoSaveAction extends CrudSaveAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5154698578823186211L;

    /** The i18n map. */
    @Setter
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();

        switch (accion) {
        case create:
            prtoBO.insert(model, i18nMap);

            break;
        case edit:
            prtoBO.update(model, i18nMap);

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
        if (accion == AccionCodigo.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.prto_codigo, model.getCodigo());
        FieldValidator.validateRequired(this, MessageI18nKey.prto_codigoCorto, model.getCodigoCorto());
        FieldValidator.validateRequired(this, MessageI18nKey.prto_codigoEdi, model.getCodigoEdi());
        FieldValidator.validateRequired(this, MessageI18nKey.prto_recAduanero, model.getRecAduanero());
        FieldValidator.validateRequired(this, MessageI18nKey.prto_unlocode, model.getUnlocode());
        FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt());

        FieldValidator.validateI18n(this, i18nMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prto;
    }
}
