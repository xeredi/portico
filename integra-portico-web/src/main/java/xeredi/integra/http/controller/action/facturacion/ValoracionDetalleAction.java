package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleAction.
 */
public final class ValoracionDetalleAction extends ItemAction implements ModelDriven<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8445459876553622926L;

    /** The vlrd. */
    private ValoracionDetalleVO model;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The aspc. */
    private AspectoVO aspc;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrd-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.selectVlrd(model.getId());

        loadDependencies();

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrd-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());

        if (ACCION_EDICION.edit == getAccion()) {
            Preconditions.checkNotNull(model.getId());

            final ValoracionBO vlrcBO = new ValoracionBO();

            model = vlrcBO.selectVlrd(model.getId());
        }

        loadDependencies();

        return SUCCESS;
    }

    @Action("vlrd-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());

        if (ACCION_EDICION.edit == getAccion()) {
            Preconditions.checkNotNull(model.getId());
        }

        loadDependencies();

        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (getAccion()) {
        case create:
            vlrcBO.insertVlrd(model);

            break;
        case edit:
            vlrcBO.updateVlrd(model);

            break;
        default:
            throw new Error("Accion no valida: " + getAccion());
        }

        return SUCCESS;
    }

    /**
     * Load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrl = vlrcBO.selectVlrl(model.getVlrlId(), getIdioma());

        if (vlrl.getId() == vlrl.getPadreId()) {
            vlrlPadre = vlrl;
        } else {
            vlrlPadre = vlrcBO.selectVlrl(vlrl.getPadreId(), getIdioma());
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setVlrcId(model.getVlrcId());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ValoracionDetalleVO getModel() {
        return model;
    }

    /**
     * Sets the vlrd.
     *
     * @param value
     *            the vlrd
     */
    public void setModel(final ValoracionDetalleVO value) {
        model = value;
    }

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

    /**
     * Gets the vlrl padre.
     *
     * @return the vlrl padre
     */
    public ValoracionLineaVO getVlrlPadre() {
        return vlrlPadre;
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
