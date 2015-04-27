package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioListAction.
 */
public final class SubservicioListAction extends
        ItemListAction<SubservicioCriterioVO, SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7791150298212933914L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificList() throws ApplicationException {
        enti = TipoSubservicioProxy.select(model.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        resultList = ssrvBO.selectList(model, getOffset(), limit);
    }
}
