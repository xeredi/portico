package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.bo.servicio.Servicio;
import xeredi.integra.model.bo.servicio.escala.EscalaBO;
import xeredi.integra.model.bo.servicio.escala.EscalaEdiBO;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaAction.
 */
public final class EscalaAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2983663759005027128L;

    /** The item. */
    private ServicioVO item;

    /** The enti. */
    private TipoServicioVO enti;

    /** The notificado. */
    private boolean notificado;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones Web

    /**
     * Autorizar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "esca-notificar-popup", results = { @Result(name = "success", location = "escala/esca-notificar.jsp") })
    public String notificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final Servicio srvcBO = BOFactory.getInjector().getInstance(Servicio.class);
        final EscalaBO escaBO = new EscalaBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

        notificado = item.getItdtMap().get(TipoDato.CADENA_03.getId()).getCadena() != null
                && item.getItdtMap().get(TipoDato.FECHA_02.getId()).getFecha() != null;

        item.getItdtMap().get(TipoDato.CADENA_03.getId()).setCadena(escaBO.obtenerNumeroManifiestoAeat(item.getId()));
        item.getItdtMap().get(TipoDato.FECHA_02.getId()).setFecha(Calendar.getInstance().getTime());

        return SUCCESS;
    }

    /**
     * Notificar guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "esca-notificar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "srvc-detalle", "item.id", "%{item.id}" }) })
    public String notificarGuardar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EscalaEdiBO escaEdiBO = new EscalaEdiBO();

        escaEdiBO.notificarPractico(item.getId(), item.getItdtMap().get(TipoDato.CADENA_03.getId()).getCadena(), item
                .getItdtMap().get(TipoDato.FECHA_02.getId()).getFecha());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item == null ? Calendar.getInstance().getTime() : item.getFreferencia();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     * 
     * @param value
     *            the new item
     */
    public final void setItem(final ServicioVO value) {
        item = value;
    }

    /**
     * Checks if is notificado.
     * 
     * @return true, if is notificado
     */
    public final boolean isNotificado() {
        return notificado;
    }

}
