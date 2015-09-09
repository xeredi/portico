package xeredi.integra.http.controller.action.item;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.EntidadProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteSaveAction.
 */
public final class ItemTramiteSaveAction extends CrudSaveAction<ItemTramiteVO> {

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
}
