package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroListAction.
 */
public final class ParametroListAction extends ItemListAction<ParametroCriterioVO, ParametroVO, TipoParametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9015729508898215168L;

	@Inject
	private ParametroService prmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificList() throws ApplicationException {
		if (model.getFechaVigencia() == null) {
			model.setFechaVigencia(Calendar.getInstance().getTime());
		}

		enti = TipoParametroProxy.select(model.getEntiId());

		resultList = prmtService.selectList(model, getOffset(), limit);
	}
}
