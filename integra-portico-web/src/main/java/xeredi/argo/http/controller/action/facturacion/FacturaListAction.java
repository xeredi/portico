package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaListAction.
 */
@Data
public final class FacturaListAction extends GridListAction<FacturaCriterioVO, FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6828936466180806396L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fctr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final FacturaBO fctrBO = new FacturaBO();

        resultList = fctrBO.selectList(model, getOffset(), limit);
    }
}
