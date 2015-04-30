package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoSaveAction.
 */
public final class EntidadTipoDatoSaveAction extends CrudSaveAction<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6877738229315027201L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        switch (accion) {
        case create:
            entdBO.insert(model, i18nMap);

            break;
        case edit:
            entdBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no contemplada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.entd_tpdt, model.getTpdt());
        } else {
            Preconditions.checkNotNull(model.getTpdt());
            Preconditions.checkNotNull(model.getTpdt().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.entd_grupo, model.getGrupo());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_fila, model.getFila());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_orden, model.getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_span, model.getSpan());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_spanLg, model.getSpanLg());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_obligatorio, model.getObligatorio());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_gridable, model.getGridable());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_filtrable, model.getFiltrable());
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
