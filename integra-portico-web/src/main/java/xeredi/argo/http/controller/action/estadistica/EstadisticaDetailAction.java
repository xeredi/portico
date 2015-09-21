package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.EstadisticaBO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaDetailAction.
 */
public final class EstadisticaDetailAction extends ItemDetailAction<EstadisticaVO, TipoEstadisticaDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -375730466702517334L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterio = new EstadisticaCriterioVO();

        enti = TipoEstadisticaProxy.select(model.getEntiId());

        estdCriterio.setId(model.getId());
        estdCriterio.setIdioma(idioma);

        model = estdBO.selectObject(estdCriterio);
    }
}
