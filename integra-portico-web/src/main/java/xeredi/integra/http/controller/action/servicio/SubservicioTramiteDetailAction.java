package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemStatechangeDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.item.bo.ItemTramiteBO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteDetailAction.
 */
public final class SubservicioTramiteDetailAction extends
ItemStatechangeDetailAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 862368077800075649L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doDetail() throws ApplicationException {
        final ItemTramiteBO ittrBO = new ItemTramiteBO();

        ittr = ittrBO.select(ittr.getId(), idioma);

        trmt = TramiteProxy.select(ittr.getTrmt().getId());
        enti = TipoSubservicioProxy.select(ittr.getTrmt().getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(ittr.getTrmt().getEntiId());

        item = ssrvBO.select(ittr.getItemId(), idioma);
    }
}
