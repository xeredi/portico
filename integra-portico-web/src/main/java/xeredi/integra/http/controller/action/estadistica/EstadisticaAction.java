package xeredi.integra.http.controller.action.estadistica;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAction.
 */
public final class EstadisticaAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8514285987958813188L;

    /** The enti. */
    private TipoEstadisticaVO enti;

    /** The estd. */
    private EstadisticaVO item;

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
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
        enti = TipoEstadisticaProxy.select(item.getEntiId());
        setFechaVigencia(item.getFref());

        return SUCCESS;
    }

    // get / set

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

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

}
