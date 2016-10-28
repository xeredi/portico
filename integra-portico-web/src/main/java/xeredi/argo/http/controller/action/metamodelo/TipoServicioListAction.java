package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListAction.
 */
@Data
public final class TipoServicioListAction extends GridListAction<TipoServicioCriterioVO, TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -334690081170777720L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpsr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoServicioBO entiBO = new TipoServicioBO();

        resultList = entiBO.selectList(model, getOffset(), limit);
    }
}
