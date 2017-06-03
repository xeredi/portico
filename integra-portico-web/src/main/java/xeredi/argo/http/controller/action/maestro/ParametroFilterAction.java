package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroFilterAction.
 */
public final class ParametroFilterAction extends ItemFilterAction<ParametroCriterioVO, TipoParametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1740124942966001653L;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	/** The fecha vigencia. */
	@Getter
	@Setter
	private Date fechaVigencia;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificPrepareFilter() throws ApplicationException {
		enti = entiProxy.selectTppr(model.getEntiId());

		if (fechaVigencia == null) {
			fechaVigencia = Calendar.getInstance().getTime();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		if (enti.getEnti().getPuerto()) {
			final PuertoBO prtoBO = new PuertoBO();
			final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

			prtoCriterio.setSprtId(getSprtId());
			prtoCriterio.setIdioma(getIdioma());

			prtoList = prtoBO.selectList(prtoCriterio);
		}
	}
}
