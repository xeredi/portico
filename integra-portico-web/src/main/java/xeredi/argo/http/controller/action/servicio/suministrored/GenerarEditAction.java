package xeredi.argo.http.controller.action.servicio.suministrored;

import java.util.Calendar;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.vo.ServicioMaestroCriterioVO;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new generate edit action.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GenerarEditAction extends CrudEditAction<ServicioMaestroCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5314432978346685428L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		model.setFfin(Calendar.getInstance().getTime());

		DateUtil.truncTime(model.getFfin(), Calendar.HOUR_OF_DAY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}

}
