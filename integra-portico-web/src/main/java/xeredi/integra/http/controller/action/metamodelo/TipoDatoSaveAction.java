package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;

import com.google.common.base.Preconditions;

/**
 * The Class TipoDatoSaveAction.
 */
public final class TipoDatoSaveAction extends CrudSaveAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6497317985967093794L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();

        switch (accion) {
        case create:
            tpdtBO.insert(model, i18nMap);

            break;
        case edit:
            tpdtBO.update(model, i18nMap);

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
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpdt_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpht, model.getTpht());
        FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpel, model.getTipoElemento());

        if (FieldValidator.isInList(model.getTipoElemento(), TipoElemento.PR, TipoElemento.SR)) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpdt_enti, model.getEnti());
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
