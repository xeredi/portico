package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadDetailAction.
 */
@Data
public final class AccionEntidadDetailAction extends CrudDetailAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6926170829964416671L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.acen;

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
