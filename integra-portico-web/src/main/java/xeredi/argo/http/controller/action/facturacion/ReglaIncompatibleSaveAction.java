package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
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

        if (accion == AccionCodigo.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgin_rgla2, model.getRgla2());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion().getId());
            Preconditions.checkNotNull(model.getRgla2());
            Preconditions.checkNotNull(model.getRgla2().getId());
        }

        DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        FieldValidator.validateVersion(this, accion, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgin;
    }
}
