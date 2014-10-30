package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

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
     */
    @Action("mabl-bloquear")
    public String bloquear() {
        final BlBO mablBO = new BlBO();
        final SubservicioBO ssrvBO = new SubservicioBO();

        try {
            mablBO.bloquear(item.getId());

            item = ssrvBO.select(item.getId(), getIdioma());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     */
    @Action("mabl-completar")
    public String completar() {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.completar(item.getId());
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
    @Action("mabl-iniciar")
    public String iniciar() {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.iniciar(item.getId());
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
    @Action("mabl-anular")
    public String anular() {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.anular(item.getId());
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
