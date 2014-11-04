package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoAction.
 */
public final class AspectoCargoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1550351663461650264L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The ascr. */
    private AspectoCargoVO ascr;

    /** The crgo list. */
    private final List<LabelValueVO> crgoList = new ArrayList<LabelValueVO>();

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("ascr-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascr = ascrBO.select(ascr.getId(), getFechaVigencia());

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("ascr-create")
    public String create() throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getAspcId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        accion = ACCION_EDICION.create;

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoVO aspc = aspcBO.select(ascr.getAspcId(), getFechaVigencia(), getIdioma());
        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setTpsrId(aspc.getTpsr().getId());
        crgoCriterioVO.setFechaVigencia(getFechaVigencia());

        crgoList.addAll(crgoBO.selectLabelValueList(crgoCriterioVO));

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("ascr-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascr = ascrBO.select(ascr.getId(), getFechaVigencia());
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("ascr-save")
    public String save() throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(ascr);

        if (ACCION_EDICION.create == accion) {
            Preconditions.checkNotNull(ascr.getAspcId());

            FieldValidator.validateRequired(this, MessageI18nKey.ascr_crgo, ascr.getCrgo());
        } else {
            Preconditions.checkNotNull(ascr.getId());
            Preconditions.checkNotNull(ascr.getAscv());
            Preconditions.checkNotNull(ascr.getAscv().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, ascr.getAscv());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, ascr.getAscv().getFini());
        }

        if (!hasErrors()) {
            final AspectoCargoBO ascrBO = new AspectoCargoBO();

            switch (accion) {
            case create:
                ascrBO.insert(ascr);

                break;
            case edit:
                ascrBO.update(ascr);

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
    @Action("ascr-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getAscv());
        Preconditions.checkNotNull(ascr.getAscv().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascrBO.delete(ascr);

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
     * Gets the ascr.
     *
     * @return the ascr
     */
    public AspectoCargoVO getAscr() {
        return ascr;
    }

    /**
     * Sets the ascr.
     *
     * @param value
     *            the new ascr
     */
    public void setAscr(final AspectoCargoVO value) {
        ascr = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<LabelValueVO> getCrgoList() {
        return crgoList;
    }

}
