package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.bo.escala.EscalaEdiBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaAction.
 */
public final class EscalaAction extends ItemAction implements ModelDriven<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2983663759005027128L;

    /** The item. */
    private ServicioVO model;

    /** The notificado. */
    private boolean notificado;

    // Acciones Web

    /**
     * Autorizar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "esca-notificar-popup", results = {
            @Result(name = "success", location = "escala/esca-notificar.jsp") })
    public String notificar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EscalaBO escaBO = new EscalaBO();

        model = escaBO.select(model.getId(), getIdioma());

        notificado = model.getItdtMap().get(TipoDato.CADENA_03.getId()).getCadena() != null
                && model.getItdtMap().get(TipoDato.FECHA_02.getId()).getFecha() != null;

        model.getItdtMap().get(TipoDato.CADENA_03.getId()).setCadena(escaBO.obtenerNumeroManifiestoAeat(model.getId()));
        model.getItdtMap().get(TipoDato.FECHA_02.getId()).setFecha(Calendar.getInstance().getTime());

        return SUCCESS;
    }

    /**
     * Notificar guardar.
     *
     * @return the string
     */
    @Action(value = "esca-notificar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "srvc-detalle", "model.id", "%{model.id}" }) })
    public String notificarGuardar() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EscalaEdiBO escaEdiBO = new EscalaEdiBO();

        escaEdiBO.notificarPractico(model.getId(), model.getItdtCadena(TipoDato.CADENA_03.getId()),
                model.getItdtFecha(TipoDato.FECHA_02.getId()));

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setModel(final ServicioVO value) {
        model = value;
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
