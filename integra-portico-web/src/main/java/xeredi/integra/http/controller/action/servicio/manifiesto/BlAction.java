package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.bo.servicio.manifiesto.Bl;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class BlAction.
 */
public final class BlAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3751908708490319574L;

    /** The item. */
    private SubservicioVO item;

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
    @Action(value = "mabl-bloquear-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String bloquear() throws InstanceNotFoundException {
        final Bl mablBO = BOFactory.getInjector().getInstance(Bl.class);

        try {
            mablBO.bloquear(item.getId());

            addActionMessage(getText("ssrv.bloquear.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mabl-completar-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String completar() throws InstanceNotFoundException {
        final Bl mablBO = BOFactory.getInjector().getInstance(Bl.class);

        try {
            mablBO.completar(item.getId());

            addActionMessage(getText("ssrv.completar.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mabl-iniciar-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String iniciar() throws InstanceNotFoundException {
        final Bl mablBO = BOFactory.getInjector().getInstance(Bl.class);

        try {
            mablBO.iniciar(item.getId());

            addActionMessage(getText("ssrv.iniciar.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
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
    @Action(value = "mabl-anular-popup", results = { @Result(location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String anular() throws InstanceNotFoundException {
        final Bl mablBO = BOFactory.getInjector().getInstance(Bl.class);

        try {
            mablBO.anular(item.getId());

            addActionMessage(getText("ssrv.anular.success"));
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item.
     * 
     * @return the item
     */
    public final SubservicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     * 
     * @param value
     *            the new item
     */
    public final void setItem(final SubservicioVO value) {
        item = value;
    }

}
