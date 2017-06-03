package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionFilterAction.
 */
public final class ValoracionFilterAction extends GridFilterAction<ValoracionCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3391977535580636697L;

	/** The tpdt cod exencion. */
	@Getter
	private TipoDatoVO tpdtCodExencion;

	/** The tpsr list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doPrepareFilter() throws ApplicationException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setIdioma(getIdioma());

		prtoList = prtoService.selectList(prtoCriterio);
		tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());
		tpdtCodExencion = tpdtProxy.select(TipoDato.COD_EXEN.getId());
	}
}
