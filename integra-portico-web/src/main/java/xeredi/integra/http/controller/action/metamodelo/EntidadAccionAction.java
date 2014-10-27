package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionAction.
 */
public final class EntidadAccionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8430223895677320578L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadAccionVO enac;

    // Acciones Web
    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("enac-create")
    public String create() {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("enac-edit")
    public String edit() {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());
        Preconditions.checkNotNull(enac.getPath());

        accion = ACCION_EDICION.edit;

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enac = enacBO.select(enac.getEntiId(), enac.getPath());

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("enac-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (GenericValidator.isBlankOrNull(enac.getPath())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enac_path.name()) }));
            }
        } else {
            Preconditions.checkNotNull(enac.getPath());
        }

        if (GenericValidator.isBlankOrNull(enac.getEtiqueta())) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enac_etiqueta.name()) }));
        }
        if (enac.getOrden() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enac_orden.name()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        if (accion == ACCION_EDICION.create) {
            try {
                enacBO.insert(enac);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.enac.name()) }));
            }
        } else {
            enacBO.update(enac);
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("enac-remove")
    public String remove() {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());
        Preconditions.checkNotNull(enac.getPath());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enacBO.delete(enac);

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("enac-detail")
    public String detail() {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());
        Preconditions.checkNotNull(enac.getPath());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enac = enacBO.select(enac.getEntiId(), enac.getPath());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the enac.
     *
     * @return the enac
     */
    public EntidadAccionVO getEnac() {
        return enac;
    }

    /**
     * Sets the enac.
     *
     * @param value
     *            the new enac
     */
    public void setEnac(final EntidadAccionVO value) {
        enac = value;
    }

}
