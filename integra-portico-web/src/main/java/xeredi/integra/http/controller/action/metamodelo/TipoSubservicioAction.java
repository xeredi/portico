package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicio;
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
        Preconditions.checkNotNull(enti.getTpsr());
        Preconditions.checkNotNull(enti.getTpsr().getId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpss-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);

        enti = tpssBO.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("tpss-save")
    public String save() throws DuplicateInstanceException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpsr());
        Preconditions.checkNotNull(enti.getTpsr().getId());

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (GenericValidator.isBlankOrNull(enti.getCodigo())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_codigo") }));
            }
            if (GenericValidator.isBlankOrNull(enti.getNombre())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_nombre") }));
            }
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        if (enti.getCmdAlta() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_cmdAlta") }));
        }
        if (enti.getCmdBaja() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_cmdBaja") }));
        }
        if (enti.getCmdEdicion() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_cmdEdicion") }));
        }
        if (enti.getCmdDuplicado() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_cmdDuplicado") }));
        }
        if (enti.getTemporal() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_temporal") }));
        }
        if (enti.getFacturable() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_facturable") }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            tpssBO.insert(enti);
        } else {
            try {
                tpssBO.update(enti);
            } catch (final InstanceNotFoundException ex) {
                throw new Error(ex);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpss-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);

        tpssBO.delete(enti.getId());

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

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        enti = tpssBO.select(enti.getId());

        EntidadCriterioVO entiCriterioVO = null;

        if (enti.getEntiPadresList() != null && !enti.getEntiPadresList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiHijaId(enti.getId());

            entiPadresList = entiBO.selectList(entiCriterioVO);
        }

        if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(enti.getId());

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
