package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.UsuarioBO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioListAction.
 */
public final class UsuarioListAction extends GridListAction<UsuarioCriterioVO, UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3750518542645128408L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final UsuarioBO usroBO = new UsuarioBO();

        resultList = usroBO.selectList(model, getOffset(), limit);
    }
}
