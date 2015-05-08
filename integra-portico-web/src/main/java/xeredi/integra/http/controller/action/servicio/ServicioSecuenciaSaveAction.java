package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaSaveAction.
 */
public final class ServicioSecuenciaSaveAction extends CrudSaveAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7028594284567884292L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        switch (accion) {
        case create:
            srscBO.insert(model);

            break;
        case edit:
            srscBO.update(model);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        switch (accion) {
        case create:
            FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());
            FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr().getId());
                FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
            }

            FieldValidator.validateRequired(this, MessageI18nKey.srsc_anno, model.getAnno());

            break;
        case edit:
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
            Preconditions.checkNotNull(model.getTpsr());
            Preconditions.checkNotNull(model.getTpsr().getId());
            Preconditions.checkNotNull(model.getAnno());

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }

        FieldValidator.validateRequired(this, MessageI18nKey.srsc_ultimo_numero, model.getUltimoNumero());
    }
}