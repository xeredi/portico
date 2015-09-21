package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.EstadisticaBO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaListAction.
 */
public final class EstadisticaListAction extends
        ItemListAction<EstadisticaCriterioVO, EstadisticaVO, TipoEstadisticaDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1284436845357248301L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificList() throws ApplicationException {
        Preconditions.checkNotNull(model.getPepr());
        Preconditions.checkNotNull(model.getPepr().getId());
        Preconditions.checkNotNull(model.getPepr().getSprtId());

        enti = TipoEstadisticaProxy.select(model.getEntiId());

        final EstadisticaBO itemBO = new EstadisticaBO();

        resultList = itemBO.selectList(model, getOffset(), limit);
    }
}
