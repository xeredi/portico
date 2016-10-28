package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioSaveAction.
 */
@Data
public final class TipoSubservicioSaveAction extends EntidadSaveAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2564809133906860884L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpss;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpsrId());

        FieldValidator.validateRequired(this, MessageI18nKey.enti_temporal, model.isTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_facturable, model.isFacturable());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_exencionable, model.isExencionable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        switch (accion) {
        case create:
            tpssBO.insert(model, i18nMap);

            break;
        case edit:
            tpssBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }
}
