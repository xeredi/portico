package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteSaveAction.
 */
public final class SubservicioTramiteSaveAction extends ItemStatechangeSaveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2510112295462616661L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        final TramiteDetailVO trmtDetail = TramiteProxy.select(trmtId);
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(item.getEntiId());

        if (tpssDetail.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_fini, item.getFini());
            FieldValidator.validatePeriod(this, item.getFini(), item.getFfin());
        }

        FieldValidator.validateTrmt(this, tpssDetail, trmtDetail, item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStatechangeSave() throws ApplicationException {
        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

        // TODO Auto-generated method stub

    }

}
