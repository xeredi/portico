package xeredi.integra.http.controller.action.facturacion;

import java.util.Map;

import org.apache.commons.validator.GenericValidator;

import xeredi.integra.http.controller.action.CrudSaveAction;
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
        Preconditions.checkNotNull(model.getAspv());

        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_tpsr, model.getTpsr());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getAspv());
            Preconditions.checkNotNull(model.getAspv().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.aspc_fini, model.getAspv().getFini());
        FieldValidator.validatePeriod(this, model.getAspv().getFini(), model.getAspv().getFfin());
        FieldValidator.validateRequired(this, MessageI18nKey.aspc_prioridad, model.getAspv().getPrioridad());

        FieldValidator.validateI18n(this, i18nMap);

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo1())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo1())
                || model.getAspv().getCgrpInfo1() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo1, model.getAspv().getCetiqInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo1, model.getAspv().getCpathInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo1, model.getAspv().getCgrpInfo1());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo2())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo2())
                || model.getAspv().getCgrpInfo2() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo2, model.getAspv().getCetiqInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo2, model.getAspv().getCpathInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo2, model.getAspv().getCgrpInfo2());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo3())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo3())
                || model.getAspv().getCgrpInfo3() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo3, model.getAspv().getCetiqInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo3, model.getAspv().getCpathInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo3, model.getAspv().getCgrpInfo3());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo4())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo4())
                || model.getAspv().getCgrpInfo4() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo4, model.getAspv().getCetiqInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo4, model.getAspv().getCpathInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo4, model.getAspv().getCgrpInfo4());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo5())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo5())
                || model.getAspv().getCgrpInfo5() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo5, model.getAspv().getCetiqInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo5, model.getAspv().getCpathInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo5, model.getAspv().getCgrpInfo5());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo6())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo6())
                || model.getAspv().getCgrpInfo6() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo6, model.getAspv().getCetiqInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo6, model.getAspv().getCpathInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo6, model.getAspv().getCgrpInfo6());
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
