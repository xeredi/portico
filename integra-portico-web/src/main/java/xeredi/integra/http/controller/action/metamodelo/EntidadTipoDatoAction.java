package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDato;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDato;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAction.
 */
public final class EntidadTipoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9005055738040850443L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadTipoDatoVO entd;

    /**
     * Instantiates a new entidad tipo dato action.
     */
    public EntidadTipoDatoAction() {
        super();

        entd = new EntidadTipoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("entd-alta")
    public String alta() throws InstanceNotFoundException {
        if (entd.getEntiId() == null) {
            throw new Error("No se ha seleccionado una entidad");
        }

        accion = ACCION_EDICION.alta;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("entd-modificar")
    public String modificar() {
        accion = ACCION_EDICION.modificar;

        final EntidadTipoDato entdBO = BOFactory.getInjector().getInstance(EntidadTipoDatoBO.class);

        entd = entdBO.select(entd.getEntiId(), entd.getTpdt().getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("entd-guardar")
    public String guardar() throws InstanceNotFoundException {
        final EntidadTipoDato entdBO = BOFactory.getInjector().getInstance(EntidadTipoDatoBO.class);

        // PropertyValidator.validateRequired(this, "entd.grupo", entd.getGrupo());
        PropertyValidator.validateRequired(this, "entd.fila", entd.getFila());
        PropertyValidator.validateRequired(this, "entd.orden", entd.getOrden());
        PropertyValidator.validateRequired(this, "entd.span", entd.getSpan());
        PropertyValidator.validateRequired(this, "entd.etiqueta", entd.getEtiqueta());

        if (hasErrors()) {
            return SUCCESS;
        }

        if (accion == ACCION_EDICION.alta) {
            try {
                entdBO.insert(entd);
            } catch (final DuplicateInstanceException ex) {
                // FIXME Error
                throw new Error("No implementado");
            }
        } else {
            entdBO.update(entd);
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("entd-detalle")
    public String detalle() {
        final EntidadTipoDato entdBO = BOFactory.getInjector().getInstance(EntidadTipoDatoBO.class);

        entd = entdBO.select(entd.getEntiId(), entd.getTpdt().getId());

        return SUCCESS;
    }

    // get/set
    /**
     * Gets the engds.
     *
     * @return the engds
     */
    public List<LabelValueVO> getEngds() {
        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDatoBO.class);

        return engdBO.selectLabelValues(entd.getEntiId());
    }

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
     * Gets the entd.
     *
     * @return the entd
     */
    public EntidadTipoDatoVO getEntd() {
        return entd;
    }

    /**
     * Sets the entd.
     *
     * @param value
     *            the new entd
     */
    public void setEntd(final EntidadTipoDatoVO value) {
        entd = value;
    }

}
