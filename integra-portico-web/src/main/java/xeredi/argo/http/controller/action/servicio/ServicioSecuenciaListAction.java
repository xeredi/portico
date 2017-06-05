package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.ServicioSecuenciaService;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServicioSecuenciaListAction
		extends GridListAction<ServicioSecuenciaCriterioVO, ServicioSecuenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1060959675142011080L;

	@Inject
	private ServicioSecuenciaService srscService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = srscService.selectList(model, getOffset(), limit);
	}
}
