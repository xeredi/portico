package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoAction.
 */
public final class ManifiestoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6347595712376492068L;

    /** The srvc. */
    private ServicioVO item;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Bloquear.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("mani-bloquear")
    public String bloquear() throws InstanceNotFoundException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        try {
            maniBO.bloquear(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(MessageI18nKey.E00010, ex.getEstado());
        }

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("mani-completar")
    public String completar() throws InstanceNotFoundException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        try {
            maniBO.completar(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(MessageI18nKey.E00010, ex.getEstado());
        }

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("mani-iniciar")
    public String iniciar() throws InstanceNotFoundException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        try {
            maniBO.iniciar(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(MessageI18nKey.E00010, ex.getEstado());
        }

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("mani-anular")
    public String anular() throws InstanceNotFoundException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        try {
            maniBO.anular(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(MessageI18nKey.E00010, ex.getEstado());
        }

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getItem() {
        return item;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setItem(final ServicioVO value) {
        item = value;
    }

}
