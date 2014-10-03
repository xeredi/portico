package xeredi.integra.http.controller.action.estadistica;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAction.
 */
public final class EstadisticaAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8514285987958813188L;

    /** The estd. */
    private EstadisticaVO item;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */

    @Action("estd-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();

        estdCriterioVO.setId(item.getId());
        estdCriterioVO.setIdioma(getIdioma());

        item = estdBO.selectObject(estdCriterioVO);

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item.getPepr().getFreferencia();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final EstadisticaVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param item
     *            the new item
     */
    public final void setItem(final EstadisticaVO item) {
        this.item = item;
    }

}
