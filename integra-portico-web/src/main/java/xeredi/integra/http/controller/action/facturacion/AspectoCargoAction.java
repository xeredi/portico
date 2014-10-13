package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.InstanceNotFoundException;

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

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The crgo list. */
    private final List<LabelValueVO> crgoList = new ArrayList<LabelValueVO>();

    /**
     * Instantiates a new aspecto cargo action.
     */
    public AspectoCargoAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
    }

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("ascr-detail")
    public String detail() {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getId());
        Preconditions.checkNotNull(fechaVigencia);

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterioVO = new AspectoCargoCriterioVO();

        ascrCriterioVO.setId(ascr.getId());
        ascrCriterioVO.setFechaVigencia(fechaVigencia);

        ascr = ascrBO.select(ascrCriterioVO);

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("ascr-create")
    public String create() {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getAspcId());
        Preconditions.checkNotNull(fechaVigencia);

        accion = ACCION_EDICION.create;

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setId(ascr.getAspcId());
        aspcCriterioVO.setFechaVigencia(fechaVigencia);

        final AspectoVO aspc = aspcBO.select(aspcCriterioVO);

        if (aspc != null) {
            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

            crgoCriterioVO.setTpsrId(aspc.getTpsr().getId());
            crgoCriterioVO.setFechaVigencia(fechaVigencia);

            crgoList.addAll(crgoBO.selectLabelValueList(crgoCriterioVO));
        }

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("ascr-edit")
    public String edit() {
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getAscv());
        Preconditions.checkNotNull(ascr.getAscv().getId());

        accion = ACCION_EDICION.edit;

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterioVO = new AspectoCargoCriterioVO();

        ascrCriterioVO.setAscvId(ascr.getAscv().getId());

        ascr = ascrBO.select(ascrCriterioVO);

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("ascr-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(ascr);
        Preconditions.checkNotNull(ascr.getAscv());

        if (ACCION_EDICION.create == accion) {
            Preconditions.checkNotNull(ascr.getAspcId());

            if (ascr.getCrgo() == null || ascr.getCrgo().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ascr_crgo") }));
            }
        } else {
            Preconditions.checkNotNull(ascr.getId());
            Preconditions.checkNotNull(ascr.getAscv().getId());
        }

        if (ascr.getAscv().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ascr_fini") }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        switch (accion) {
        case create:
            try {
                ascrBO.insert(ascr);
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("ascr") }));
            }

            break;
        case edit:
            try {
                ascrBO.update(ascr);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(),
                        new String[] { getText("ascr"), String.valueOf(ascr.getId()) }));
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("ascr") }));
            }

            break;

        default:
            throw new Error("Accion no valida: " + accion);
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
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<LabelValueVO> getCrgoList() {
        return crgoList;
    }

}