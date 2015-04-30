package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionSaveAction.
 */
public final class ValoracionSaveAction extends CrudSaveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4029857636749956262L;

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
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_srvc, model.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_aspc, model.getAspc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fliq, model.getFliq());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fref, model.getFref());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            break;

        default:
            break;
        }

        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_pagador, model.getPagador());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_sujPasivo, model.getSujPasivo());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_codExencion, model.getCodExencion());
    }
}
