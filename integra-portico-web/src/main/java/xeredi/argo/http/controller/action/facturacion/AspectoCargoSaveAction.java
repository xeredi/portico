package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.util.DateUtil;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoSaveAction.
 */
public final class AspectoCargoSaveAction extends CrudSaveAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5838925962199897361L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        model.getVersion().setFini(DateUtil.resetTime(model.getVersion().getFini()));
        model.getVersion().setFfin(DateUtil.resetTime(model.getVersion().getFfin()));

        switch (accion) {
        case create:
            ascrBO.insert(model);

            break;
        case edit:
            ascrBO.update(model);

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
        Preconditions.checkNotNull(model.getAspcId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo, model.getCrgo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.ascr;
    }
}
