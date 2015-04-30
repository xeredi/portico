package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListAction.
 */
public final class TipoServicioListAction extends GridListAction<TipoServicioCriterioVO, TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -334690081170777720L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        if (model.getCodigo() != null) {
            model.setCodigo(model.getCodigo().toUpperCase());
        }

        final TipoServicioBO entiBO = new TipoServicioBO();

        resultList = entiBO.selectList(model, getOffset(), limit);
    }
}
