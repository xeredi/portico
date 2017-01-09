package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.ValoracionCargoService;
import xeredi.argo.model.facturacion.service.ValoracionImpuestoService;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetailAction.
 */
public final class FacturaDetailAction extends CrudDetailAction<FacturaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5987039917634891480L;

	/** The aspc. */
	@Getter
	private AspectoVO aspc;

	/** The fcts list. */
	@Getter
	private List<ValoracionVO> vlrcList;

	/** The fcti list. */
	@Getter
	private List<ValoracionImpuestoVO> fctiList;

	/** The fctg list. */
	@Getter
	private List<ValoracionCargoVO> fctgList;

	@Inject
	private AspectoService aspcService;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private ValoracionCargoService vlrgService;

	@Inject
	private ValoracionImpuestoService vlriService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final FacturaBO fctrBO = new FacturaBO();

		model = fctrBO.select(model.getId(), getIdioma());

		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setFctr(model);
		vlrcCriterio.setIdioma(getIdioma());

		vlrcList = vlrcService.selectList(vlrcCriterio);
		fctgList = vlrgService.selectList(vlrcCriterio);
		fctiList = vlriService.selectList(vlrcCriterio);

		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setId(model.getAspc().getId());
		aspcCriterio.setFechaVigencia(model.getFref());
		aspcCriterio.setIdioma(getIdioma());

		aspc = aspcService.selectObject(aspcCriterio);
	}
}
