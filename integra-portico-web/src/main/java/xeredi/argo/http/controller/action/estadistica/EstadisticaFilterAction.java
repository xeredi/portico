package xeredi.argo.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaFilterAction.
 */
public final class EstadisticaFilterAction extends ItemFilterAction<EstadisticaCriterioVO, TipoEstadisticaDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7668343371684180192L;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	@Inject
	private PuertoService prtoService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificPrepareFilter() throws ApplicationException {
		Preconditions.checkNotNull(model.getPepr());
		Preconditions.checkNotNull(model.getPepr().getId());
		Preconditions.checkNotNull(model.getPepr().getSprtId());
		Preconditions.checkNotNull(model.getIdioma());

		enti = entiProxy.selectTpes(model.getEntiId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setSprtId(getSprtId());
		prtoCriterio.setIdioma(getIdioma());

		prtoList = prtoService.selectList(prtoCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date getFechaVigencia() {
		// FIXME Devolver fecha de referencia del periodo de proceso
		return Calendar.getInstance().getTime();
	}
}
