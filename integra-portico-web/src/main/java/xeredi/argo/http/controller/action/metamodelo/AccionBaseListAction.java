package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseListAction extends GridListAction<AccionBaseCriterioVO, AccionBaseVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8697939019605785607L;

	/**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final AccionBaseBO acbsBO = new AccionBaseBO();

        resultList = acbsBO.selectList(model, getOffset(), limit);
    }
}
