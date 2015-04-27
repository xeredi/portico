package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioSaveAction.
 */
public final class SubservicioSaveAction extends ItemSaveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7087277709727877248L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        final TipoSubservicioDetailVO enti = TipoSubservicioProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_srvc, model.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_numero, model.getNumero());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());
            Preconditions.checkNotNull(model.getNumero());
        }

        if (enti.getEnti().getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_estado, model.getEstado());
        }

        if (enti.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_fini, model.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_ffin, model.getFfin());
        }

        FieldValidator.validateItem(this, enti, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoSubservicioDetailVO enti = TipoSubservicioProxy.select(model.getEntiId());
        final SubservicioBO itemBO = SubservicioBOFactory.newInstance(model.getEntiId());

        switch (accion) {
        case create:
            itemBO.insert(model, enti, null);

            break;
        case edit:
            itemBO.update(model);

            break;
        case duplicate:
            itemBO.duplicate(model);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }
}
