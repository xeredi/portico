package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

public final class ServicioSaveAction extends ItemSaveAction<ServicioVO> {

    /**
     *
     */
    private static final long serialVersionUID = 8100605830957326882L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        final TipoServicioDetailVO enti = TipoServicioProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_anno, model.getAnno());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_numero, model.getNumero());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        if (enti.getEnti().getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_estado, model.getEstado());
        }

        if (enti.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fini, model.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_ffin, model.getFfin());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fref, model.getFref());
        }

        FieldValidator.validateItem(this, enti, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        // FIXME ACABAR
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        switch (accion) {
        case create:
            srvcBO.insert(model, null, null, null);

            break;
        case edit:
            srvcBO.update(model);

            break;
        case duplicate:
            srvcBO.duplicate(model);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }
}
