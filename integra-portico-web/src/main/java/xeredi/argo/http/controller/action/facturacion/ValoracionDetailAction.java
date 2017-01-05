package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.bo.ValoracionCargoBO;
import xeredi.argo.model.facturacion.bo.ValoracionImpuestoBO;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final ValoracionBO vlrcBO = new ValoracionBO();

		model = vlrcBO.select(model.getId(), getIdioma());

		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setId(model.getId());
		vlrcCriterio.setIdioma(getIdioma());

		final ValoracionImpuestoBO vlriBO = new ValoracionImpuestoBO();

		vlriList = vlriBO.selectList(vlrcCriterio);

		final ValoracionCargoBO vlrgBO = new ValoracionCargoBO();

		vlrgList = vlrgBO.selectList(vlrcCriterio);

		tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setId(model.getAspc().getId());
		aspcCriterio.setFechaVigencia(model.getFref());
		aspcCriterio.setIdioma(getIdioma());

		aspc = aspcService.selectObject(aspcCriterio);
	}
}
