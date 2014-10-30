package xeredi.integra.http.controller.action.estadistica;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
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
     */

    @Action("estd-detail")
    public String detalle() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final EstadisticaBO estdBO = new EstadisticaBO();
            final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();

            estdCriterioVO.setId(item.getId());
            estdCriterioVO.setIdioma(getIdioma());

            item = estdBO.selectObject(estdCriterioVO);
            enti = TipoEstadisticaProxy.select(item.getEntiId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

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

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

}
