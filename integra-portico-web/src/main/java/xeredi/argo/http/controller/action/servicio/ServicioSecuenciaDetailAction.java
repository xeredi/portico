package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaDetailAction.
 */
public final class ServicioSecuenciaDetailAction extends CrudDetailAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2738862112087523687L;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.srsc;
    }
}
