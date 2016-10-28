package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoRemoveAction.
 */
@Data
public final class EntidadGrupoDatoRemoveAction extends CrudRemoveAction<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8335697148874416415L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.engd;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        engdBO.delete(model);
    }
}
