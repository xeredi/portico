package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoSaveAction.
 */
public final class EntidadGrupoDatoSaveAction extends CrudSaveAction<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6118734142717724781L;

    /** The i18n map. */
    @Setter
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        switch (accion) {
        case create:
            engdBO.insert(model, i18nMap);

            break;
        case edit:
            engdBO.update(model, i18nMap);

            break;
        default:
            throw new Error("No implementado :" + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        FieldValidator.validateRequired(this, MessageI18nKey.engd_numero, model.getNumero());
        FieldValidator.validateI18n(this, i18nMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.engd;
    }
}
