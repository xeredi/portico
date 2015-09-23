package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSaveAction.
 */
public final class ServicioSaveAction extends ItemSaveAction<ServicioVO> {

    /** The Constant serialVersionUID. */
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
            FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.ffin, model.getFfin());

            // FIXME ¿Deberia estar en la clase de negocio?
            model.setFref(model.getFini());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.fref, model.getFref());
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