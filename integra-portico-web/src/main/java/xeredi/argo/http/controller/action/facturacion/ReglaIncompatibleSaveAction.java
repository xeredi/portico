package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.util.DateUtil;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleSaveAction.
 */
public final class ReglaIncompatibleSaveAction extends CrudSaveAction<ReglaIncompatibleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3406256689953956051L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        model.getVersion().setFini(DateUtil.resetTime(model.getVersion().getFini()));
        model.getVersion().setFfin(DateUtil.resetTime(model.getVersion().getFfin()));

        switch (accion) {
        case create:
            rginBO.insert(model);

            break;
        case edit:
            rginBO.update(model);

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
        Preconditions.checkNotNull(model.getRgla1Id());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgin_rgla2, model.getRgla2());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion().getId());
            Preconditions.checkNotNull(model.getRgla2());
            Preconditions.checkNotNull(model.getRgla2().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgin;
    }
}
