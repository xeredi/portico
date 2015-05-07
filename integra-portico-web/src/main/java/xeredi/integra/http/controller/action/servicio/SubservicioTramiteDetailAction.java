package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.servicio.bo.SubservicioTramiteBO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteDetailAction.
 */
public final class SubservicioTramiteDetailAction extends
ItemStatechangeDetailAction<TipoSubservicioDetailVO, SubservicioTramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 862368077800075649L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doDetail() throws ApplicationException {
        final SubservicioTramiteBO ittrBO = new SubservicioTramiteBO();

        ittr = ittrBO.select(ittr.getId(), idioma);

        trmt = TramiteProxy.select(ittr.getTrmt().getId());
        enti = TipoSubservicioProxy.select(ittr.getTrmt().getEntiId());
    }
}
