package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

/**
 * The Class TipoDatoListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoDatoListAction extends GridListAction<TipoDatoCriterioVO, TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2898524538399018227L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();

        resultList = tpdtBO.selectList(model, getOffset(), limit);
    }
}
