package xeredi.argo.http.controller.action.administracion.puerto;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoListAction.
 */
public final class SuperpuertoListAction extends GridListAction<SuperpuertoCriterioVO, SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 871252972692007990L;

	@Inject
	private SuperpuertoService sprtService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        resultList = sprtService.selectList(model, getOffset(), limit);
    }
}
