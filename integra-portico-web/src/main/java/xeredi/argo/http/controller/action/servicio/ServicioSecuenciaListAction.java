package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.srsc;
    }
}
