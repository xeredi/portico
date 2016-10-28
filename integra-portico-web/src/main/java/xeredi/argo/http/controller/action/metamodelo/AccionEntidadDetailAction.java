package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadDetailAction.
 */
public final class AccionEntidadDetailAction extends CrudDetailAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6926170829964416671L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.acen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionEntidadBO acenBO = new AccionEntidadBO();
        final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

        acenCriterio.setId(model.getId());
        acenCriterio.setIdioma(getIdioma());

        model = acenBO.selectObject(acenCriterio);
    }
}
