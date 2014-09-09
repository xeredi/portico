package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDato;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDato;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

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
    @Action("entd-create")
    public String create() throws InstanceNotFoundException {
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("entd-edit")
    public String edit() {
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());
        Preconditions.checkNotNull(entd.getTpdt());
        Preconditions.checkNotNull(entd.getTpdt().getId());

        accion = ACCION_EDICION.edit;

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
    @Action("entd-save")
    public String save() throws InstanceNotFoundException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (entd.getTpdt() == null || entd.getTpdt().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_tpdt") }));
            }
        } else {
            Preconditions.checkNotNull(entd.getTpdt());
            Preconditions.checkNotNull(entd.getTpdt().getId());
        }

        if (GenericValidator.isBlankOrNull(entd.getEtiqueta())) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_etiqueta") }));
        }
        if (entd.getGrupo() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_grupo") }));
        }
        if (entd.getFila() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_fila") }));
        }
        if (entd.getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_orden") }));
        }
        if (entd.getSpan() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_span") }));
        }
        if (entd.getSpanLg() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_spanLg") }));
        }
        if (entd.getObligatorio() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_obligatorio") }));
        }
        if (entd.getGridable() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_gridable") }));
        }
        if (entd.getFiltrable() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("entd_filtrable") }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final EntidadTipoDato entdBO = BOFactory.getInjector().getInstance(EntidadTipoDatoBO.class);

        if (accion == ACCION_EDICION.create) {
            try {
                entdBO.insert(entd);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("entd") }));
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
    @Action("entd-detail")
    public String detail() {
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());
        Preconditions.checkNotNull(entd.getTpdt());
        Preconditions.checkNotNull(entd.getTpdt().getId());

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
