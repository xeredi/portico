package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;
import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemChangeStateEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueAnularEditAction.
 */
public final class AtraqueAnularEditAction extends ItemChangeStateEditAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1433080883956999859L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        if (!atraBO.isAnulable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_anular, model.getId());
        }

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model = atraBO.select(model.getId(), idioma);
        model.setSrvc(srvcBO.select(model.getSrvc().getId(), idioma));

        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return model.getSrvc().getFref();
    }
}
