package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoAction.
 */
public final class AspectoCargoAction extends BaseAction implements ModelDriven<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1550351663461650264L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The ascr. */
    private AspectoCargoVO model;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The crgo list. */
    private List<LabelValueVO> crgoList;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ascr-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        model = ascrBO.select(model.getId(), getFechaVigencia());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ascr-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getAspcId());
        Preconditions.checkNotNull(getFechaVigencia());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final AspectoCargoBO ascrBO = new AspectoCargoBO();

            model = ascrBO.select(model.getId(), getFechaVigencia());
        } else {
            final AspectoBO aspcBO = new AspectoBO();
            final AspectoVO aspc = aspcBO.select(model.getAspcId(), getFechaVigencia(), getIdioma());
            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setTpsrId(aspc.getTpsr().getId());
            crgoCriterio.setFechaVigencia(getFechaVigencia());
            crgoCriterio.setIdioma(getIdioma());

            crgoList = crgoBO.selectLabelValueList(crgoCriterio);
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ascr-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);

        if (ACCION_EDICION.create == accion) {
            Preconditions.checkNotNull(model.getAspcId());

            FieldValidator.validateRequired(this, MessageI18nKey.ascr_crgo, model.getCrgo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getAscv());
            Preconditions.checkNotNull(model.getAscv().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, model.getAscv());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ascr_fini, model.getAscv().getFini());
        }

        if (!hasErrors()) {
            final AspectoCargoBO ascrBO = new AspectoCargoBO();

            switch (accion) {
            case create:
                ascrBO.insert(model);

                break;
            case edit:
                ascrBO.update(model);

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ascr-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getAscv());
        Preconditions.checkNotNull(model.getAscv().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascrBO.delete(model.getAscv().getId());

        return SUCCESS;
    }

    // get / set
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
     * {@inheritDoc}
     */
    @Override
    public AspectoCargoVO getModel() {
        return model;
    }

    /**
     * Sets the ascr.
     *
     * @param value
     *            the new ascr
     */
    public void setModel(final AspectoCargoVO value) {
        model = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<LabelValueVO> getCrgoList() {
        return crgoList;
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
}
