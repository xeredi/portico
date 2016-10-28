package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.usro;
    }

}
