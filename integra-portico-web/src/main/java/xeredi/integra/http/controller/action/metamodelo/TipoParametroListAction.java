package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroListAction.
 */
public final class TipoParametroListAction extends GridListAction<TipoParametroCriterioVO, TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -417082160677321691L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        if (model.getCodigo() != null) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }

        final TipoParametroBO entiBO = new TipoParametroBO();

        resultList = entiBO.selectList(model, getOffset(), limit);
    }
}
