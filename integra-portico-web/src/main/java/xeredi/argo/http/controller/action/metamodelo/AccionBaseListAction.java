package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseListAction.
 */
@Data
public final class AccionBaseListAction extends GridListAction<AccionBaseCriterioVO, AccionBaseVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8697939019605785607L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.acbs;

	/**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final AccionBaseBO acbsBO = new AccionBaseBO();

        resultList = acbsBO.selectList(model, getOffset(), limit);
    }
}
