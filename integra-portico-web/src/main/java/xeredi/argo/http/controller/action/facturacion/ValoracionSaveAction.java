package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionSaveAction.
 */
public final class ValoracionSaveAction extends CrudSaveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4029857636749956262L;

	@Inject
	private ValoracionService vlrcService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        switch (accion) {
        case create:
            vlrcService.insert(model);

            break;
        case edit:
            vlrcService.update(model);

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
