package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioListAction.
 */
public final class ServicioListAction extends ItemListAction<ServicioCriterioVO, ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1069829008412284361L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificList() throws ApplicationException {
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        resultList = srvcBO.selectList(model, getOffset(), limit);
        enti = TipoServicioProxy.select(model.getEntiId());
    }
}
