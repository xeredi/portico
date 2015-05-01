package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.comun.CrudChangeStateAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.PartidaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaBloquearAction.
 */
public final class PartidaBloquearAction extends CrudChangeStateAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8598460807198821428L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PartidaBO partBO = new PartidaBO();

        partBO.bloquear(model.getId());
    }
}
