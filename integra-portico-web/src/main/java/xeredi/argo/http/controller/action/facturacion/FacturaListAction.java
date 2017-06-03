package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaService;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaListAction.
 */
public final class FacturaListAction extends GridListAction<FacturaCriterioVO, FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6828936466180806396L;

	@Inject
	private FacturaService fctrService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        resultList = fctrService.selectList(model, getOffset(), limit);
    }
}
