package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.item.bo.ItemTramiteBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTramiteDetailAction.
 */
public final class ServicioTramiteDetailAction extends ItemStatechangeDetailAction<ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5167502577623669436L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doDetail() throws ApplicationException {
        final ItemTramiteBO ittrBO = new ItemTramiteBO();

        ittr = ittrBO.select(ittr.getId(), idioma);

        trmt = TramiteProxy.select(ittr.getTrmt().getId());
        enti = TipoServicioProxy.select(ittr.getTrmt().getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(ittr.getTrmt().getEntiId());

        item = srvcBO.select(ittr.getItemId(), idioma);
    }
}
