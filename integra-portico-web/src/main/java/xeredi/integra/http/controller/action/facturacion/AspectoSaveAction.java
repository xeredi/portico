package xeredi.integra.http.controller.action.facturacion;

import java.util.Map;

import org.apache.commons.validator.GenericValidator;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoSaveAction.
 */
public final class AspectoSaveAction extends CrudSaveAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5347828326827355006L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AspectoBO aspcBO = new AspectoBO();

        switch (accion) {
        case create:
            aspcBO.insert(model, i18nMap);

            break;
        case duplicate:
            aspcBO.duplicate(model, i18nMap);

            break;
        case edit:
            aspcBO.update(model, i18nMap);

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
        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_tpsr, model.getTpsr());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateVersion(this, accion, model);
        FieldValidator.validateRequired(this, MessageI18nKey.aspc_prioridad, model.getVersion().getPrioridad());

        FieldValidator.validateI18n(this, i18nMap);

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo1())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo1())
                || model.getVersion().getCgrpInfo1() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo1, model.getVersion().getCetiqInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo1, model.getVersion().getCpathInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo1, model.getVersion().getCgrpInfo1());
        }

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo2())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo2())
                || model.getVersion().getCgrpInfo2() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo2, model.getVersion().getCetiqInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo2, model.getVersion().getCpathInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo2, model.getVersion().getCgrpInfo2());
        }

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo3())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo3())
                || model.getVersion().getCgrpInfo3() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo3, model.getVersion().getCetiqInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo3, model.getVersion().getCpathInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo3, model.getVersion().getCgrpInfo3());
        }

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo4())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo4())
                || model.getVersion().getCgrpInfo4() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo4, model.getVersion().getCetiqInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo4, model.getVersion().getCpathInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo4, model.getVersion().getCgrpInfo4());
        }

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo5())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo5())
                || model.getVersion().getCgrpInfo5() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo5, model.getVersion().getCetiqInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo5, model.getVersion().getCpathInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo5, model.getVersion().getCgrpInfo5());
        }

        if (!GenericValidator.isBlankOrNull(model.getVersion().getCetiqInfo6())
                || !GenericValidator.isBlankOrNull(model.getVersion().getCpathInfo6())
                || model.getVersion().getCgrpInfo6() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo6, model.getVersion().getCetiqInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo6, model.getVersion().getCpathInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo6, model.getVersion().getCgrpInfo6());
        }
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
