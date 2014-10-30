package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.manifiesto.PartidaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaAction.
 */
public final class PartidaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6389372066711184329L;

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
     */
    @Action("part-bloquear")
    public String bloquear() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        try {
            partBO.bloquear(item.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     */
    @Action("part-iniciar")
    public String iniciar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        try {
            partBO.iniciar(item.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     */
    @Action("part-anular")
    public String anular() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        try {
            partBO.anular(item.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
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
