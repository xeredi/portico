package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Regla;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "rgla-filtro") })
    public String filtro() {
        Preconditions.checkNotNull(rglaCriterio);

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);

        this.rglaList = rglaBO.selectList(rglaCriterio);

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
    public void setRglaCriterio(ReglaCriterioVO value) {
        this.rglaCriterio = value;
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
