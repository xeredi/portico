package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteSaveAction.
 */
public final class SubservicioTramiteSaveAction extends ItemStatechangeSaveAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2510112295462616661L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        final TramiteDetailVO trmtDetail = TramiteProxy.select(ittr.getTrmt().getId());
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(ittr.getTrmt().getEntiId());

        if (tpssDetail.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.fini, ittr.getDitemFini());
            FieldValidator.validatePeriod(this, ittr.getDitemFini(), ittr.getDitemFfin());
        }

        FieldValidator.validateTrmt(this, tpssDetail, trmtDetail, ittr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStatechangeSave() throws ApplicationException {
        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(ittr.getTrmt().getEntiId());

        ssrvBO.statechange(ittr);
    }

}
