package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAction.
 */
public final class ValoracionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4129919965585365201L;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The vlrg list. */
    private List<ValoracionCargoVO> vlrgList;

    /** The vlri list. */
    private List<ValoracionImpuestoVO> vlriList;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Actions({ @Action("vlrc-detail") })
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrcCriterioVO.setId(vlrc.getId());

        vlrc = vlrcBO.select(vlrc.getId());
        vlriList = vlrcBO.selectVlriList(vlrcCriterioVO);
        vlrgList = vlrcBO.selectVlrgList(vlrcCriterioVO);

        return SUCCESS;
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

}
