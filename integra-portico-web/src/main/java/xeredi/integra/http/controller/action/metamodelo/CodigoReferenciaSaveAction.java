package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;

import com.google.common.base.Preconditions;

/**
 * The Class CodigoReferenciaSaveAction.
 */
public final class CodigoReferenciaSaveAction extends CrudSaveAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8704360630485075850L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        switch (accion) {
        case create:
            cdrfBO.insert(model, i18nMap);

            break;
        case edit:
            cdrfBO.update(model, i18nMap);

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
        Preconditions.checkNotNull(model.getTpdtId());
        Preconditions.checkNotNull(i18nMap);

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cdrf_valor, model.getValor());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getValor());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cdrf_orden, model.getOrden());
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
