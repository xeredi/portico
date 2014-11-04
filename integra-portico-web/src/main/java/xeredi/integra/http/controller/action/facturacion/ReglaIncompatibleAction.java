package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVersionVO;
import xeredi.util.applicationobjects.LabelValueVO;

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

    /** The crgo id. */
    private Long crgoId;

    /** The crgo. */
    private ReglaIncompatibleVO rgin;

    /** The rgla2 list. */
    private final List<LabelValueVO> rgla2List = new ArrayList<>();

    /** The fecha vigencia. */
    private final Date fechaVigencia;

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
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setId(rgin.getId());
        rginCriterioVO.setFechaVigencia(fechaVigencia);

        if (rgin.getRgiv() != null) {
            rginCriterioVO.setRgivId(rgin.getRgiv().getId());
        }

        rgin = rginBO.select(rginCriterioVO);

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("rgin-create")
    public String create() {
        Preconditions.checkNotNull(crgoId);
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgla1Id());

        accion = ACCION_EDICION.create;

        rgin.setRgiv(new ReglaIncompatibleVersionVO());
        rgin.getRgiv().setFini(Calendar.getInstance().getTime());

        {
            final ReglaBO rglaBO = new ReglaBO();
            final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

            rglaCriterioVO.setCrgoId(crgoId);

            rgla2List.addAll(rglaBO.selectLabelValueList(rglaCriterioVO));
        }

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("rgin-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        accion = ACCION_EDICION.edit;

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgivId(rgin.getRgiv().getId());

        rgin = rginBO.select(rginCriterioVO);

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("rgin-save")
    public String save() throws InstanceNotFoundException, OverlapException {
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

        if (!hasErrors()) {
            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

            switch (accion) {
            case create:
                rginBO.insert(rgin);

                break;
            case edit:
                rginBO.update(rgin);

                break;

            default:
                throw new Error("Accion no valida: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("rgin-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        rginBO.delete(rgin);

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
    public List<LabelValueVO> getRgla2List() {
        return rgla2List;
    }

    /**
     * Gets the crgo id.
     *
     * @return the crgo id
     */
    public Long getCrgoId() {
        return crgoId;
    }

    /**
     * Sets the crgo id.
     *
     * @param value
     *            the new crgo id
     */
    public void setCrgoId(final Long value) {
        crgoId = value;
    }

}
