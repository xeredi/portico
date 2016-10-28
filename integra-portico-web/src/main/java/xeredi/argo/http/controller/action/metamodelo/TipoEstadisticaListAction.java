package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListAction.
 */
@Data
public final class TipoEstadisticaListAction extends GridListAction<TipoEstadisticaCriterioVO, TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3250106088197977726L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpes;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoEstadisticaBO entiBO = new TipoEstadisticaBO();

        resultList = entiBO.selectList(model, getOffset(), limit);
    }
}
