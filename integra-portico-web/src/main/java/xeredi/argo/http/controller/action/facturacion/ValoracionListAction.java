package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionListAction.
 */
public final class ValoracionListAction extends GridListAction<ValoracionCriterioVO, ValoracionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3608142356966434674L;

	/** The tpdt cod exencion. */
	@Getter
	private TipoDatoVO tpdtCodExencion;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = vlrcService.selectList(model, getOffset(), limit);
		tpdtCodExencion = tpdtProxy.select(TipoDato.COD_EXEN.getId());
	}
}
