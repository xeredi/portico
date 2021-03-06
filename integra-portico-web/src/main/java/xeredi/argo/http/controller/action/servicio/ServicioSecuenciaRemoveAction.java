package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.ServicioSecuenciaService;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaRemoveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServicioSecuenciaRemoveAction extends CrudRemoveAction<ServicioSecuenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1665684591776965203L;

	@Inject
	private ServicioSecuenciaService srscService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getPrto());
		Preconditions.checkNotNull(model.getPrto().getId());
		Preconditions.checkNotNull(model.getTpsr());
		Preconditions.checkNotNull(model.getTpsr().getId());
		Preconditions.checkNotNull(model.getAnno());

		srscService.delete(model);
	}
}
