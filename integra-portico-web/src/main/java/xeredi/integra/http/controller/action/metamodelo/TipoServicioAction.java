package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAction.
 */
public final class TipoServicioAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5123740111042031938L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpsr. */
    private TipoServicioVO enti;

    /** The tpss list. */
    private final List<TipoSubservicioVO> subentiList = new ArrayList<>();

    /** The enti hijas list. */
    private final List<EntidadVO> entiHijasList = new ArrayList<>();

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpsr-create")
    public String create() {
        accion = ACCION_EDICION.create;

        enti = new TipoServicioVO();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpsr-edit")
    public String edit() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoServicioBO tpsrBO = new TipoServicioBO();

        try {
            enti = tpsrBO.select(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("tpsr"), String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpsr-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enti);

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

        final TipoServicioBO tpsrBO = new TipoServicioBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpsrBO.insert(enti);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("tpsr") }));
            }
        } else {
            try {
                tpsrBO.update(enti);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(),
                        new String[] { getText("tpsr"), String.valueOf(enti.getId()) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpsr-remove")
    public String remove() {
        final TipoServicioBO tpsrBO = new TipoServicioBO();

        try {
            tpsrBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("tpsr"), String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpsr-detail")
    public String detail() {
        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final EntidadBO entiBO = new EntidadBO();

        try {
            enti = tpsrBO.select(enti.getId());

            TipoSubservicioCriterioVO tpssCriterioVO = null;

            tpssCriterioVO = new TipoSubservicioCriterioVO();
            tpssCriterioVO.setTpsrId(enti.getId());
            subentiList.addAll(tpssBO.selectList(tpssCriterioVO));

            if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
                EntidadCriterioVO entiCriterioVO = null;

                entiCriterioVO = new EntidadCriterioVO();
                entiCriterioVO.setEntiPadreId(enti.getId());

                entiHijasList.addAll(entiBO.selectList(entiCriterioVO));
            }
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("tpsr"), String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the tpsr form.
     *
     * @return the tpsr form
     */
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the tpsr form.
     *
     * @param value
     *            the new tpsr form
     */
    public void setEnti(final TipoServicioVO value) {
        enti = value;
    }

    /**
     * Gets the tpss list.
     *
     * @return the tpss list
     */
    public List<TipoSubservicioVO> getSubentiList() {
        return subentiList;
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
     * @param accion
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION accion) {
        this.accion = accion;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
    }

}
