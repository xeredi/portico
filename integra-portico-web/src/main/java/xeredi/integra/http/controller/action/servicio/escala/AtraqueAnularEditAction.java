package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueAnularEditAction.
 */
public final class AtraqueAnularEditAction extends AtraqueChangeStateEditAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1433080883956999859L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        final AtraqueBO atraBO = new AtraqueBO();

        if (!atraBO.isAnulable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_anular, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
    }
}
