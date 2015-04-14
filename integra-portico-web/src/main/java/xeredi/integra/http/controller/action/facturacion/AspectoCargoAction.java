package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoAction.
 */
public final class AspectoCargoAction extends ItemAction implements ModelDriven<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1550351663461650264L;

    /** The ascr. */
    private AspectoCargoVO model;

    /** The crgo list. */
    private List<CargoVO> crgoList;

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
        final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

        ascrCriterio.setId(model.getId());
        ascrCriterio.setFechaVigencia(getFechaVigencia());

        model = ascrBO.selectObject(ascrCriterio);

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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getAspcId());
        Preconditions.checkNotNull(getFechaVigencia());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final AspectoCargoBO ascrBO = new AspectoCargoBO();
            final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

            ascrCriterio.setId(model.getId());
            ascrCriterio.setFechaVigencia(getFechaVigencia());

            model = ascrBO.selectObject(ascrCriterio);
        } else {
            final AspectoBO aspcBO = new AspectoBO();
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(model.getId());
            aspcCriterio.setFechaVigencia(getFechaVigencia());
            aspcCriterio.setIdioma(getIdioma());

            final AspectoVO aspc = aspcBO.selectObject(aspcCriterio);

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setTpsrId(aspc.getTpsr().getId());
            crgoCriterio.setFechaVigencia(getFechaVigencia());
            crgoCriterio.setIdioma(getIdioma());

            crgoList = crgoBO.selectList(crgoCriterio);
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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);

        if (ACCION_EDICION.create == getAccion()) {
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

            switch (getAccion()) {
            case create:
                ascrBO.insert(model);

                break;
            case edit:
                ascrBO.update(model);

                break;

            default:
                throw new Error("Accion no valida: " + getAccion());
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
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }
}
