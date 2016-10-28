package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloListAction.
 */
@Data
public final class ModuloListAction  extends GridListAction<ModuloCriterioVO, ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7287670605906578392L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.mdlo;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ModuloBO mdloBO = new ModuloBO();

        resultList = mdloBO.selectList(model, getOffset(), limit);
    }
}
