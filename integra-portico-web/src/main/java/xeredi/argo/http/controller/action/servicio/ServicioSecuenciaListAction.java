package xeredi.argo.http.controller.action.servicio;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaListAction.
 */
@Data
public final class ServicioSecuenciaListAction extends GridListAction<ServicioSecuenciaCriterioVO, ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1060959675142011080L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.srsc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        resultList = srscBO.selectList(model, getOffset(), limit);
    }
}
