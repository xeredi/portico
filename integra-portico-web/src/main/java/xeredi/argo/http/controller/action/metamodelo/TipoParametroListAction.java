package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListAction.
 */
@Data
public final class TipoParametroListAction extends GridListAction<TipoParametroCriterioVO, TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -417082160677321691L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tppr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoParametroBO entiBO = new TipoParametroBO();

        resultList = entiBO.selectList(model, getOffset(), limit);
    }
}
