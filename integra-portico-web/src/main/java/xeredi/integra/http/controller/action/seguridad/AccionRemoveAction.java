package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

/**
 * The Class AccionRemoveAction.
 */
public final class AccionRemoveAction extends CrudRemoveAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 353308355649870324L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();

        accnBO.delete(model);
    }
}
