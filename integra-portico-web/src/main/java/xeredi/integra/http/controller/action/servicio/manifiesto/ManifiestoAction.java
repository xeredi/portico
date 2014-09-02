package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.bo.manifiesto.Manifiesto;
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
    @Action(value = "mani-bloquear-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String bloquear() throws InstanceNotFoundException {
        final Manifiesto maniBO = BOFactory.getInjector().getInstance(ManifiestoBO.class);

        try {
            maniBO.bloquear(item.getId());

            addActionMessage(getText("srvc.bloquear.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("srvc.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mani-completar-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String completar() throws InstanceNotFoundException {
        final Manifiesto maniBO = BOFactory.getInjector().getInstance(ManifiestoBO.class);

        try {
            maniBO.completar(item.getId());

            addActionMessage(getText("srvc.completar.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("srvc.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mani-iniciar-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String iniciar() throws InstanceNotFoundException {
        final Manifiesto maniBO = BOFactory.getInjector().getInstance(ManifiestoBO.class);

        try {
            maniBO.iniciar(item.getId());

            addActionMessage(getText("srvc.iniciar.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("srvc.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mani-anular-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String anular() throws InstanceNotFoundException {
        final Manifiesto maniBO = BOFactory.getInjector().getInstance(ManifiestoBO.class);

        try {
            maniBO.anular(item.getId());

            addActionMessage(getText("srvc.anular.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("srvc.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
