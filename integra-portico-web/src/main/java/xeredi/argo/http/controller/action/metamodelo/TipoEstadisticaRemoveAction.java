package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaRemoveAction.
 */
public final class TipoEstadisticaRemoveAction extends CrudRemoveAction<TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8551997472365097343L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoEstadisticaBO entiBO = new TipoEstadisticaBO();

        entiBO.delete(model);
    }

}
