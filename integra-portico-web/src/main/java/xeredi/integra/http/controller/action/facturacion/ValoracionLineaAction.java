package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAction.
 */
public final class ValoracionLineaAction extends ItemAction implements ModelDriven<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3876356981308567280L;

    /** The vlrl. */
    private ValoracionLineaVO model;

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
    @Action("vlrl-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.selectVlrl(model.getId(), getIdioma());

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
    @Action("vlrl-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final ValoracionBO vlrcBO = new ValoracionBO();

            model = vlrcBO.selectVlrl(model.getId(), getIdioma());
        }

        loadDependencies();

        return SUCCESS;
    }

    @Action("vlrl-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        loadDependencies();

        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (getAccion()) {
        case create:
            vlrcBO.insertVlrl(model, null);

            break;
        case edit:
            vlrcBO.updateVlrl(model);

            break;
        default:
            throw new Error("Accion no valida: " + getAccion());
        }

        return SUCCESS;
    }

    /**
     * Load data.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        if (model.getId() != null) {
            if (model.getId() == model.getPadreId()) {
                vlrlPadre = model;
            } else {
                final ValoracionBO vlrcBO = new ValoracionBO();

                vlrlPadre = vlrcBO.selectVlrl(model.getPadreId(), getIdioma());
            }
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setVlrcId(model.getVlrcId());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    // get / set

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    @Override
    public ValoracionLineaVO getModel() {
        return model;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the vlrl
     */
    public void setModel(final ValoracionLineaVO value) {
        model = value;
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
