package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.servicio.bo.ServicioTramiteBO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTramiteDetailAction.
 */
public final class ServicioTramiteDetailAction extends
        ItemStatechangeDetailAction<TipoServicioDetailVO, ServicioTramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5167502577623669436L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doDetail() throws ApplicationException {
        final ServicioTramiteBO ittrBO = new ServicioTramiteBO();

        ittr = ittrBO.select(ittr.getId(), idioma);

        trmt = TramiteProxy.select(ittr.getTrmt().getId());
        enti = TipoServicioProxy.select(ittr.getTrmt().getEntiId());
    }
}
