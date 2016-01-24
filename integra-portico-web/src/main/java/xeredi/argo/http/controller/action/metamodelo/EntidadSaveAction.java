package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadSaveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class EntidadSaveAction<T extends EntidadVO> extends CrudSaveAction<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6795337588003242186L;

    /** The i18n map. */
    @Setter
    protected Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doValidate() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdAlta, model.isCmdAlta());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdBaja, model.isCmdBaja());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdEdicion, model.isCmdEdicion());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdDuplicado, model.isCmdDuplicado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_maxGrid, model.getMaxGrid());

        doSpecificValidate();

        if (!hasErrors()) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }
    }

    /**
     * Do specific validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificValidate() throws ApplicationException;
}
