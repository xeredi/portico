package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaListAction.
 */
public final class ServicioSecuenciaListAction extends GridListAction<ServicioSecuenciaCriterioVO, ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1060959675142011080L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        resultList = srscBO.selectList(model, getOffset(), limit);
    }
}
