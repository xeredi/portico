package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAction.
 */
public final class TipoSubservicioAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1943908334114266376L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpss form. */
    private TipoSubservicioVO enti;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    // Acciones web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpss-create")
    public String create() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpsrId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpss-edit")
    public String edit() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        enti = tpssBO.select(enti.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpss-save")
    public String save() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpsrId());

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (GenericValidator.isBlankOrNull(enti.getCodigo())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enti_codigo.name()) }));
            }
            if (GenericValidator.isBlankOrNull(enti.getNombre())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enti_nombre.name()) }));
            }
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        if (enti.getCmdAlta() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdAlta.name()) }));
        }
        if (enti.getCmdBaja() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdBaja.name()) }));
        }
        if (enti.getCmdEdicion() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdEdicion.name()) }));
        }
        if (enti.getCmdDuplicado() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdDuplicado.name()) }));
        }
        if (enti.getTemporal() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_temporal.name()) }));
        }
        if (enti.getFacturable() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_facturable.name()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpssBO.insert(enti);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.tpss.name()) }));
            }
        } else {
            try {
                tpssBO.update(enti);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                    getText(MessageI18nKey.tpss.name()), String.valueOf(enti.getId()) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpss-remove")
    public String remove() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        try {
            tpssBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tpss.name()),
                String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpss-detail")
    public String detail() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final EntidadBO entiBO = new EntidadBO();

        enti = tpssBO.select(enti.getId(), getIdioma());

        EntidadCriterioVO entiCriterioVO = null;

        if (enti.getEntiPadresList() != null && !enti.getEntiPadresList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiHijaId(enti.getId());
            entiCriterioVO.setIdioma(getIdioma());

            entiPadresList = entiBO.selectList(entiCriterioVO);
        }

        if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(enti.getId());
            entiCriterioVO.setIdioma(getIdioma());

            entiHijasList = entiBO.selectList(entiCriterioVO);
        }

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
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoSubservicioVO value) {
        enti = value;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the enti padres list.
     *
     * @return the enti padres list
     */
    public List<EntidadVO> getEntiPadresList() {
        return entiPadresList;
    }
}
