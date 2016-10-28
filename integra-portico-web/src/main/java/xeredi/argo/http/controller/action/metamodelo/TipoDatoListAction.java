package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

/**
 * The Class TipoDatoListAction.
 */
@Data
public final class TipoDatoListAction extends GridListAction<TipoDatoCriterioVO, TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2898524538399018227L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpdt;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();

        resultList = tpdtBO.selectList(model, getOffset(), limit);
    }
}
