package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoSaveAction.
 */
@Data
public final class AspectoCargoSaveAction extends CrudSaveAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5838925962199897361L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.ascr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AspectoCargoBO ascrBO = new AspectoCargoBO();

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

        if (accion == AccionCodigo.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.crgo, model.getCrgo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        FieldValidator.validateVersion(this, accion, model);
    }
}
