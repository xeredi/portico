package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadDetailAction extends CrudDetailAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6926170829964416671L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final AccionEntidadBO acenBO = new AccionEntidadBO();

        model = acenBO.select(model.getId(), getIdioma());
    }
}
