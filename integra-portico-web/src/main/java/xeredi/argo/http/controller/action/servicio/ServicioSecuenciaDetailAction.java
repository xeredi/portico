package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.ServicioSecuenciaService;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServicioSecuenciaDetailAction extends CrudDetailAction<ServicioSecuenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2738862112087523687L;

	@Inject
	private ServicioSecuenciaService srscService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getPrto());
		Preconditions.checkNotNull(model.getPrto().getId());
		Preconditions.checkNotNull(model.getTpsr());
		Preconditions.checkNotNull(model.getTpsr().getId());
		Preconditions.checkNotNull(model.getAnno());

		final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

		srscCriterio.setPrtoId(model.getPrto().getId());
		srscCriterio.setTpsrId(model.getTpsr().getId());
		srscCriterio.setAnno(model.getAnno());
		srscCriterio.setIdioma(getIdioma());

		model = srscService.select(srscCriterio);
	}
}
