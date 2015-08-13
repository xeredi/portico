package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTramiteSaveAction.
 */
public final class ServicioTramiteSaveAction extends ItemStatechangeSaveAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 895782322404815962L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        final TramiteDetailVO trmtDetail = TramiteProxy.select(ittr.getTrmt().getId());
        final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(ittr.getTrmt().getEntiId());

        FieldValidator.validateTrmt(this, tpsrDetail, trmtDetail, ittr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStatechangeSave() throws ApplicationException {
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(ittr.getTrmt().getEntiId());

        srvcBO.statechange(ittr);
    }
}
