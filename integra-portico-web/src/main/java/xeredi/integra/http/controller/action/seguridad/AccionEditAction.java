package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEditAction.
 */
public final class AccionEditAction extends CrudEditAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3956096847895499243L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final AccionBO accnBO = new AccionBO();
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setId(model.getId());

            model = accnBO.selectObject(accnCriterio);
        }
    }
}
