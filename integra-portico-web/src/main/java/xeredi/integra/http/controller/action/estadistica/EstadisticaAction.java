package xeredi.integra.http.controller.action.estadistica;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAction.
 */
public final class EstadisticaAction extends ItemAction implements ModelDriven<EstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8514285987958813188L;

    /** The estd. */
    private EstadisticaVO model;

    /** The enti. */
    private TipoEstadisticaVO enti;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();

        estdCriterioVO.setId(model.getId());
        estdCriterioVO.setIdioma(getIdioma());

        model = estdBO.selectObject(estdCriterioVO);
        enti = TipoEstadisticaProxy.select(model.getEntiId());
        setFechaVigencia(model.getFref());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final EstadisticaVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final EstadisticaVO value) {
        model = value;
    }

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public Long getPrtoId() {
        return model == null || model.getPrto() == null ? null : model.getPrto().getId();
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
