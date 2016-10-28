package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionSaveAction.
 */
@Data
public final class ValoracionSaveAction extends CrudSaveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4029857636749956262L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.vlrc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (accion) {
        case create:
            vlrcBO.insert(model);

            break;
        case edit:
            vlrcBO.update(model);

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
        switch (accion) {
        case create:
            FieldValidator.validateRequired(this, MessageI18nKey.srvc, model.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc, model.getAspc());
            FieldValidator.validateRequired(this, MessageI18nKey.fref, model.getFref());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.srvc, model.getSrvc().getId());
                FieldValidator.validateRequired(this, MessageI18nKey.aspc, model.getAspc().getId());
            }

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            break;

        default:
            break;
        }

        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fliq, model.getFliq());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_sujPasivo, model.getSujPasivo());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_codExencion, model.getCodExencion());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_pagador, model.getPagador().getId());
        }
    }
}
