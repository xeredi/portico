package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.comun.CrudChangeStateAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoIniciarAction.
 */
public final class ManifiestoIniciarAction extends CrudChangeStateAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 800146882829670345L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.iniciar(model.getId());
    }
}
