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
 * The Class AtraqueAutorizarEditAction.
 */
public final class AtraqueAutorizarEditAction extends AtraqueChangeStateEditAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4608442587307848842L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        final AtraqueBO atraBO = new AtraqueBO();

        if (!atraBO.isAutorizable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_autorizar,
                    model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        // Copiar los datos de solicitud a autorizacion
        model.getItdtMap().put(TipoDato.DECIMAL_07.getId(), model.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_08.getId(), model.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
        model.getItdtMap().put(TipoDato.ALIN_2.getId(), model.getItdtMap().get(TipoDato.ALIN.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ATR_EDI_2.getId(), model.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_2.getId(),
                model.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_09.getId(), model.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_10.getId(), model.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), model.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
        model.getItdtMap().put(TipoDato.TEXTO_02.getId(), model.getItdtMap().get(TipoDato.TEXTO_01.getId()));
        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
    }
}
