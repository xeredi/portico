package xeredi.integra.http.controller.action.estadistica;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaDetailVO;

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
