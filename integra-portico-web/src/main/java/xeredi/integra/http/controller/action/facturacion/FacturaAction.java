package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAction.
 */
public final class FacturaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2376088438196649237L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The fctr. */
    private FacturaVO fctr;

    /** The aspc. */
    private AspectoVO aspc;

    /** The fcts list. */
    private List<FacturaServicioVO> fctsList;

    /** The fcti list. */
    private List<FacturaImpuestoVO> fctiList;

    /** The fctg list. */
    private List<FacturaCargoVO> fctgList;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctr-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(fctr);
        Preconditions.checkNotNull(fctr.getId());

        final FacturaBO fctrBO = new FacturaBO();
        final AspectoBO aspcBO = new AspectoBO();

        fctr = fctrBO.select(fctr.getId());
        aspc = aspcBO.select(fctr.getAspc().getId(), fctr.getFref(), getIdioma());
        fctsList = fctrBO.selectFctsList(fctr.getId());
        fctiList = fctrBO.selectFctiList(fctr.getId());
        fctgList = fctrBO.selectFctgList(fctr.getId());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctr-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(fctr);
        Preconditions.checkNotNull(fctr.getId());

        final FacturaBO fctrBO = new FacturaBO();

        fctr = fctrBO.select(fctr.getId());
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("fctr-save")
    public String save() {
        return SUCCESS;
    }

    // get / set

    /**
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaVO getFctr() {
        return fctr;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the new fctr
     */
    public void setFctr(final FacturaVO value) {
        fctr = value;
    }

    /**
     * Gets the fcts list.
     *
     * @return the fcts list
     */
    public List<FacturaServicioVO> getFctsList() {
        return fctsList;
    }

    /**
     * Gets the fcti list.
     *
     * @return the fcti list
     */
    public List<FacturaImpuestoVO> getFctiList() {
        return fctiList;
    }

    /**
     * Gets the fctg list.
     *
     * @return the fctg list
     */
    public List<FacturaCargoVO> getFctgList() {
        return fctgList;
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
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }
}
