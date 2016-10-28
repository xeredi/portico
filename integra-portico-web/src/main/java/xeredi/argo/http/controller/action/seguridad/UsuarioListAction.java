package xeredi.argo.http.controller.action.seguridad;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioListAction.
 */
@Data
public final class UsuarioListAction extends GridListAction<UsuarioCriterioVO, UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3750518542645128408L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.usro;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final UsuarioBO usroBO = new UsuarioBO();

        resultList = usroBO.selectList(model, getOffset(), limit);
    }
}
