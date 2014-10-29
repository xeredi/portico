package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVersionVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleAction.
 */
public final class ReglaIncompatibleAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8806246091503780542L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The crgo. */
    private ReglaIncompatibleVO rgin;

    /** The rgla2 list. */
    private final List<ReglaVO> rgla2List = new ArrayList<>();

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Instantiates a new regla incompatible action.
     */
    public ReglaIncompatibleAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("rgin-detail")
    public String detail() {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkArgument(rgin.getId() != null && fechaVigencia != null || rgin.getRgiv() != null
                && rgin.getRgiv().getId() != null);

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setId(rgin.getId());
        rginCriterioVO.setFechaVigencia(fechaVigencia);

        if (rgin.getRgiv() != null) {
            rginCriterioVO.setRgivId(rgin.getRgiv().getId());
        }

        try {
            rgin = rginBO.select(rginCriterioVO);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.rgin),
                    String.valueOf(rginCriterioVO.getRgivId()));
        }

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("rgin-create")
    public String create() {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgla1Id());
        Preconditions.checkNotNull(rgin.getRgla2());
        Preconditions.checkNotNull(rgin.getRgla2().getCrgo());
        Preconditions.checkNotNull(rgin.getRgla2().getCrgo().getId());

        accion = ACCION_EDICION.create;

        rgin.setRgiv(new ReglaIncompatibleVersionVO());
        rgin.getRgiv().setFini(Calendar.getInstance().getTime());

        {
            final ReglaBO rglaBO = new ReglaBO();
            final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

            rglaCriterioVO.setCrgoId(rgin.getRgla2().getCrgo().getId());

            rgla2List.addAll(rglaBO.selectList(rglaCriterioVO));
        }

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("rgin-edit")
    public String edit() {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        accion = ACCION_EDICION.edit;

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgivId(rgin.getRgiv().getId());

        try {
            rgin = rginBO.select(rginCriterioVO);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.rgin),
                    String.valueOf(rginCriterioVO.getRgivId()));
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("rgin-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgla1Id());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgin_rgla2, rgin.getRgla2());
        } else {
            Preconditions.checkNotNull(rgin.getId());
            Preconditions.checkNotNull(rgin.getRgiv().getId());
            Preconditions.checkNotNull(rgin.getRgla2());
            Preconditions.checkNotNull(rgin.getRgla2().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgin_fini, rgin.getRgiv().getFini());

        if (hasErrors()) {
            return SUCCESS;
        }

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        switch (accion) {
        case create:
            try {
                rginBO.insert(rgin);
            } catch (final OverlapException ex) {
                addActionError(MessageI18nKey.E00009, getText(MessageI18nKey.rgin));
            }

            break;
        case edit:
            try {
                rginBO.update(rgin);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.rgin));
            } catch (final OverlapException ex) {
                addActionError(MessageI18nKey.E00009, getText(MessageI18nKey.rgin));
            }

            break;

        default:
            throw new Error("Accion no valida: " + accion);
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("rgin-remove")
    public String remove() {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        try {
            rginBO.delete(rgin);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.rgin), String.valueOf(rgin.getRgiv().getId()));
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
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the rgin.
     *
     * @return the rgin
     */
    public ReglaIncompatibleVO getRgin() {
        return rgin;
    }

    /**
     * Sets the rgin.
     *
     * @param value
     *            the new rgin
     */
    public void setRgin(final ReglaIncompatibleVO value) {
        rgin = value;
    }

    /**
     * Gets the rgla2 list.
     *
     * @return the rgla2 list
     */
    public List<ReglaVO> getRgla2List() {
        return rgla2List;
    }

}
