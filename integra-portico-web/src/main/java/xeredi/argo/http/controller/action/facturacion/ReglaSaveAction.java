package xeredi.argo.http.controller.action.facturacion;

import org.apache.commons.validator.GenericValidator;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaSaveAction.
 */
public final class ReglaSaveAction extends CrudSaveAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1378188997796757435L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ReglaBO rglaBO = new ReglaBO();

        switch (accion) {
        case create:
            rglaBO.insert(model);

            break;
        case edit:
            rglaBO.update(model);

            break;
        default:
            throw new Error(accion + " no implementada");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getCrgo().getId());

            FieldValidator.validateRequired(this, MessageI18nKey.rgla_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgla_tipo, model.getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.enti, model.getEnti());
        FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_orden, model.getVersion().getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_condicion, model.getVersion().getCondicion());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_formula, model.getVersion().getFormula());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_valorBase, model.getVersion().getValorBase());

        if (ReglaTipo.T == model.getTipo()) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathImpuesto, model.getVersion()
                    .getPathImpuesto());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathPagador, model.getVersion().getPathPagador());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathEsSujPasivo, model.getVersion()
                    .getPathEsSujPasivo());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCodExen, model.getVersion().getPathCodExen());

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo1())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo1, model.getVersion().getEtiqInfo1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo1, model.getVersion().getPathInfo1());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo2())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo2, model.getVersion().getEtiqInfo2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo2, model.getVersion().getPathInfo2());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo3())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo3, model.getVersion().getEtiqInfo3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo3, model.getVersion().getPathInfo3());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo4())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo4, model.getVersion().getEtiqInfo4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo4, model.getVersion().getPathInfo4());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo5())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo5, model.getVersion().getEtiqInfo5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo5, model.getVersion().getPathInfo5());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqInfo6())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathInfo6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo6, model.getVersion().getEtiqInfo6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo6, model.getVersion().getPathInfo6());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant1())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant1, model.getVersion()
                        .getEtiqCuant1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant1, model.getVersion()
                        .getPathCuant1());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant2())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant2, model.getVersion()
                        .getEtiqCuant2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant2, model.getVersion()
                        .getPathCuant2());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant3())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant3, model.getVersion()
                        .getEtiqCuant3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant3, model.getVersion()
                        .getPathCuant3());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant4())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant4, model.getVersion()
                        .getEtiqCuant4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant4, model.getVersion()
                        .getPathCuant4());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant5())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant5, model.getVersion()
                        .getEtiqCuant5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant5, model.getVersion()
                        .getPathCuant5());
            }

            if (!GenericValidator.isBlankOrNull(model.getVersion().getEtiqCuant6())
                    || !GenericValidator.isBlankOrNull(model.getVersion().getPathCuant6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant6, model.getVersion()
                        .getEtiqCuant6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant6, model.getVersion()
                        .getPathCuant6());
            }
        }
    }
}
