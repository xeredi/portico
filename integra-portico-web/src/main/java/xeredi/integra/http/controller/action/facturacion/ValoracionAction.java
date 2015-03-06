package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAction.
 */
public final class ValoracionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4129919965585365201L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The aspc. */
    private AspectoVO aspc;

    /** The vlrg list. */
    private List<ValoracionCargoVO> vlrgList;

    /** The vlri list. */
    private List<ValoracionImpuestoVO> vlriList;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(vlrc.getId());
        vlrcCriterio.setIdioma(getIdioma());

        vlrc = vlrcBO.select(vlrc.getId(), getIdioma());
        vlriList = vlrcBO.selectVlriList(vlrcCriterio);
        vlrgList = vlrcBO.selectVlrgList(vlrcCriterio);
        aspc = aspcBO.select(vlrc.getAspc().getId(), vlrc.getFref(), getIdioma());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(vlrc.getId());
        vlrcCriterio.setIdioma(getIdioma());

        vlrc = vlrcBO.select(vlrc.getId(), getIdioma());
        accion = ACCION_EDICION.edit;

        loadLabelValues();

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-create")
    public String create() throws ApplicationException {
        vlrc = new ValoracionVO();
        accion = ACCION_EDICION.edit;

        loadLabelValues();

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.delete(vlrc.getId());

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        if (ACCION_EDICION.create == accion) {
            tpsrList = TipoServicioProxy.selectLabelValues();
        }
    }

    // get / set

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the vlrc
     */
    public void setVlrc(final ValoracionVO value) {
        vlrc = value;
    }

    /**
     * Gets the vlrg list.
     *
     * @return the vlrg list
     */
    public List<ValoracionCargoVO> getVlrgList() {
        return vlrgList;
    }

    /**
     * Gets the vlri list.
     *
     * @return the vlri list
     */
    public List<ValoracionImpuestoVO> getVlriList() {
        return vlriList;
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
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
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
