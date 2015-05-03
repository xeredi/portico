package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemChangeStateEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueChangeStateEditAction.
 */
public abstract class AtraqueChangeStateEditAction extends
ItemChangeStateEditAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2549115287175803269L;

    /** The entd buque. */
    private EntidadTipoDatoVO entdBuque;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        entdBuque = TipoServicioProxy.select(Entidad.ESCALA.getId()).getEntdMap().get(TipoDato.BUQUE.getId());

        final EscalaBO escaBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), idioma);
        model.setSrvc(escaBO.select(model.getSrvc().getId(), idioma));

        doSpecificEdit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Date getFechaVigencia() {
        return model.getSrvc().getFref();
    }

    /**
     * Do specific edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificEdit() throws ApplicationException;

    /**
     * Gets the entd buque.
     *
     * @return the entd buque
     */
    public EntidadTipoDatoVO getEntdBuque() {
        return entdBuque;
    }
}
