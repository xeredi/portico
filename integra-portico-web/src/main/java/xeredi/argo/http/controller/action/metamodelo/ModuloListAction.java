package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ModuloListAction  extends GridListAction<ModuloCriterioVO, ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7287670605906578392L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ModuloBO mdloBO = new ModuloBO();

        resultList = mdloBO.selectList(model, getOffset(), limit);
    }
}
