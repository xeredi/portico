package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioSaveAction.
 */
public final class TipoSubservicioSaveAction extends EntidadSaveAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2564809133906860884L;

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
