package xeredi.argo.http.controller.action.item;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.proxy.TramiteProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteSaveAction.
 */
public final class ItemTramiteSaveAction extends CrudSaveAction<ItemTramiteVO> implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1629906671936657593L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final AbstractEntidadDetailVO enti = EntidadProxy.select(model.getTrmt().getEntiId());

        switch (enti.getEnti().getTipo()) {
        case T:
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getTrmt().getEntiId());

            srvcBO.statechange(model);

            break;
        case S:
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getTrmt().getEntiId());

            ssrvBO.statechange(model);

            break;
        case P:
            throw new Error("No implementado!!");
        default:
            throw new Error("Invalid entity type: " + enti.getEnti().getTipo());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getItemId());
        Preconditions.checkNotNull(model.getTrmt());
        Preconditions.checkNotNull(model.getTrmt().getId());
        Preconditions.checkNotNull(model.getTrmt().getEntiId());

        final TramiteDetailVO trmt = TramiteProxy.select(model.getTrmt().getId());
        final AbstractEntidadDetailVO enti = EntidadProxy.select(model.getTrmt().getEntiId());

        switch (enti.getEnti().getTipo()) {
        case T:
            final TipoServicioDetailVO tpsr = TipoServicioProxy.select(model.getTrmt().getEntiId());

            if (tpsr.getEnti().isTemporal()) {
                FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getDitemFini());
                FieldValidator.validatePeriod(this, model.getDitemFini(), model.getDitemFfin());
            }

            break;
        case S:
            final TipoSubservicioDetailVO tpss = TipoSubservicioProxy.select(model.getTrmt().getEntiId());

            if (tpss.getEnti().isTemporal()) {
                FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getDitemFini());
                FieldValidator.validatePeriod(this, model.getDitemFini(), model.getDitemFfin());
            }

            break;
        case P:
            throw new Error("No implementado!!");
        default:
            throw new Error("Invalid entity type: " + enti.getEnti().getTipo());
        }

        FieldValidator.validateTrmt(this, enti, trmt, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTrmt());
        Preconditions.checkNotNull(model.getTrmt().getEntiId());

        return model.getTrmt().getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionPrefix getAccnPrefix() {
        return AccionPrefix.ittr;
    }
}
