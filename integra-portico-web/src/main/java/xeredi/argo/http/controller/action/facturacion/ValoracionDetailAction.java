package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.ValoracionCargoService;
import xeredi.argo.model.facturacion.service.ValoracionImpuestoService;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetailAction.
 */
public final class ValoracionDetailAction extends CrudDetailAction<ValoracionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8955027989386166332L;

	/** The aspc. */
	@Getter
	private AspectoVO aspc;

	/** The vlrg list. */
	@Getter
	private List<ValoracionCargoVO> vlrgList;

	/** The vlri list. */
	@Getter
	private List<ValoracionImpuestoVO> vlriList;

	/** The tpdt cod exencion. */
	@Getter
	private TipoDatoVO tpdtCodExencion;

	@Inject
	private AspectoService aspcService;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private ValoracionCargoService vlrgService;

	@Inject
	private ValoracionImpuestoService vlriService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = vlrcService.select(model.getId(), getIdioma());

		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setId(model.getId());
		vlrcCriterio.setIdioma(getIdioma());

		vlriList = vlriService.selectList(vlrcCriterio);
		vlrgList = vlrgService.selectList(vlrcCriterio);
		tpdtCodExencion = tpdtProxy.select(TipoDato.COD_EXEN.getId());

		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setId(model.getAspc().getId());
		aspcCriterio.setFechaVigencia(model.getFref());
		aspcCriterio.setIdioma(getIdioma());

		aspc = aspcService.selectObject(aspcCriterio);
	}
}
