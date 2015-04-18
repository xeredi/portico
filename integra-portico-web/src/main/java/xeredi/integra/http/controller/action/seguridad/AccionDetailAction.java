package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionDetailAction.
 */
public final class AccionDetailAction extends CrudDetailAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7336296287400722992L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterioVO = new AccionCriterioVO();

        accnCriterioVO.setId(model.getId());

        model = accnBO.selectObject(accnCriterioVO);
    }
}
