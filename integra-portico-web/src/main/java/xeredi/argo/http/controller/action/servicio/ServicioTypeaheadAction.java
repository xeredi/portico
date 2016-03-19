package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTypeaheadAction.
 */
public final class ServicioTypeaheadAction extends ItemTypeaheadAction<ServicioTypeaheadCriterioVO, ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3651561999872993795L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificTypeahead() throws ApplicationException {
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        resultList = srvcBO.selectTypeaheadList(model, limit);
    }
}
