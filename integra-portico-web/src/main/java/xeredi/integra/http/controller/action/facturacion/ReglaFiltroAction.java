package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaFiltroAction.
 */
public final class ReglaFiltroAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3818522120357934385L;

    /** The rgla criterio. */
    private ReglaCriterioVO rglaCriterio;

    /** The rgla list. */
    private List<ReglaVO> rglaList;

    // acciones web

    /**
     * Filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "rgla-filtro") })
    public String filtro() {
        Preconditions.checkNotNull(rglaCriterio);

        final ReglaBO rglaBO = new ReglaBO();

        rglaList = rglaBO.selectList(rglaCriterio);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the rgla criterio.
     *
     * @return the rgla criterio
     */
    public ReglaCriterioVO getRglaCriterio() {
        return rglaCriterio;
    }

    /**
     * Sets the rgla criterio.
     *
     * @param value
     *            the rgla criterio
     */
    public void setRglaCriterio(final ReglaCriterioVO value) {
        rglaCriterio = value;
    }

    /**
     * Gets the rgla list.
     *
     * @return the rgla list
     */
    public List<ReglaVO> getRglaList() {
        return rglaList;
    }

}
