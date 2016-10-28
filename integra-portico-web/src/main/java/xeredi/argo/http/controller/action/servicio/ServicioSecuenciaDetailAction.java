package xeredi.argo.http.controller.action.servicio;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaDetailAction.
 */
@Data
public final class ServicioSecuenciaDetailAction extends CrudDetailAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2738862112087523687L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.srsc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getPrto());
        Preconditions.checkNotNull(model.getPrto().getId());
        Preconditions.checkNotNull(model.getTpsr());
        Preconditions.checkNotNull(model.getTpsr().getId());
        Preconditions.checkNotNull(model.getAnno());

        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();
        final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

        srscCriterio.setPrtoId(model.getPrto().getId());
        srscCriterio.setTpsrId(model.getTpsr().getId());
        srscCriterio.setAnno(model.getAnno());
        srscCriterio.setIdioma(getIdioma());

        model = srscBO.select(srscCriterio);
    }
}
