package xeredi.integra.http.controller.action.estadistica;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.bo.estadistica.Estadistica;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.proxy.metamodelo.TipoEstadisticaProxy;
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

    /** The tpes. */
    private TipoEstadisticaVO enti;

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
    @Actions({
        @Action(value = "estd-detalle"),
        @Action(value = "estd-detalle-popup", results = { @Result(name = "success", location = "estd-detalle.jsp") }) })
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final Estadistica estdBO = BOFactory.getInjector().getInstance(Estadistica.class);
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();

        estdCriterioVO.setId(item.getId());
        estdCriterioVO.setIdioma(getIdioma());

        item = estdBO.selectObject(estdCriterioVO);
        enti = TipoEstadisticaProxy.select(item.getEntiId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        // FIXME Implementar
        return null;
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
     * @param item the new item
     */
    public final void setItem(final EstadisticaVO item) {
        this.item = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final TipoEstadisticaVO getEnti() {
        return enti;
    }

}
