package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaRemoveAction.
 */
public class ServicioSecuenciaRemoveAction extends CrudRemoveAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1665684591776965203L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getPrto());
        Preconditions.checkNotNull(model.getPrto().getId());
        Preconditions.checkNotNull(model.getTpsr());
        Preconditions.checkNotNull(model.getTpsr().getId());
        Preconditions.checkNotNull(model.getAnno());

        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        srscBO.delete(model);
    }
}
