package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.bo.escala.EscalaEdiBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.util.TipoDato;

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
     */
    @Action(value = "esca-notificar-popup", results = { @Result(name = "success", location = "escala/esca-notificar.jsp") })
    public String notificar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final ServicioBO srvcBO = new ServicioBO();
            final EscalaBO escaBO = new EscalaBO();

            item = srvcBO.select(item.getId(), getIdioma());

            notificado = item.getItdtMap().get(TipoDato.CADENA_03.getId()).getCadena() != null
                    && item.getItdtMap().get(TipoDato.FECHA_02.getId()).getFecha() != null;

            item.getItdtMap().get(TipoDato.CADENA_03.getId())
            .setCadena(escaBO.obtenerNumeroManifiestoAeat(item.getId()));
            item.getItdtMap().get(TipoDato.FECHA_02.getId()).setFecha(Calendar.getInstance().getTime());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Notificar guardar.
     *
     * @return the string
     */
    @Action(value = "esca-notificar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "srvc-detalle", "item.id", "%{item.id}" }) })
    public String notificarGuardar() {
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
