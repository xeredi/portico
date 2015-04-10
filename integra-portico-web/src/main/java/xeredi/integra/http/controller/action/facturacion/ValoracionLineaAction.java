package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
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

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("vlrl-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.selectVlrl(model.getId(), getIdioma());

        if (model.getId() == model.getPadreId()) {
            vlrlPadre = model;
        } else {
            vlrlPadre = vlrcBO.selectVlrl(model.getPadreId(), getIdioma());
        }

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

        return SUCCESS;
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

}
