package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

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

    /** The engd list. */
    private final List<LabelValueVO> engdList = new ArrayList<>();

    /** The tpdt list. */
    private final List<LabelValueVO> tpdtList = new ArrayList<>();

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
     */
    @Action("entd-create")
    public String create() {
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());

        accion = ACCION_EDICION.create;

        loadLabelValues();

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

        try {
            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            entd = entdBO.select(entd.getEntiId(), entd.getTpdt().getId(), getIdioma());

            loadLabelValues();
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("entd-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.entd_tpdt, entd.getTpdt());
        } else {
            Preconditions.checkNotNull(entd.getTpdt());
            Preconditions.checkNotNull(entd.getTpdt().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.entd_etiqueta, entd.getEtiqueta());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_grupo, entd.getGrupo());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_fila, entd.getFila());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_orden, entd.getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_span, entd.getSpan());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_spanLg, entd.getSpanLg());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_obligatorio, entd.getObligatorio());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_gridable, entd.getGridable());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_filtrable, entd.getFiltrable());

        if (!hasErrors()) {
            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            switch (accion) {
            case create:
                try {
                    entdBO.insert(entd);
                } catch (final DuplicateInstanceException ex) {
                    addActionError(MessageI18nKey.E00005, getText(ex.getClassName()));
                }

                break;
            case edit:
                try {
                    entdBO.update(entd);
                } catch (final InstanceNotFoundException ex) {
                    addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
                }

                break;
            default:
                throw new Error("Accion no contemplada: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("entd-remove")
    public String remove() {
        Preconditions.checkNotNull(entd);
        Preconditions.checkNotNull(entd.getEntiId());
        Preconditions.checkNotNull(entd.getTpdt());
        Preconditions.checkNotNull(entd.getTpdt().getId());

        try {
            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            entdBO.delete(entd);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
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

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        try {
            entd = entdBO.select(entd.getEntiId(), entd.getTpdt().getId(), getIdioma());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        engdList.addAll(engdBO.selectLabelValues(entd.getEntiId(), getIdioma()));

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterioVO = new TipoDatoCriterioVO();

        tpdtCriterioVO.setIdioma(getIdioma());

        tpdtList.addAll(tpdtBO.selectLabelValues(tpdtCriterioVO));
    }

    // get/set

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public List<LabelValueVO> getEngdList() {
        return engdList;
    }

    /**
     * Gets the tpdt list.
     *
     * @return the tpdt list
     */
    public List<LabelValueVO> getTpdtList() {
        return tpdtList;
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
