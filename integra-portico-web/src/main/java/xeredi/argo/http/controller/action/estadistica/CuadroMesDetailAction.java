package xeredi.argo.http.controller.action.estadistica;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.service.CuadroMesService;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.CuadroMesVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesAction.
 */
public final class CuadroMesDetailAction extends CrudDetailAction<PeriodoProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6080323896171314975L;

	/** The cdms map. */
	@Getter
	private Map<String, List<CuadroMesVO>> cdmsMap;

	@Inject
	private PeriodoProcesoService peprService;

	@Inject
	private CuadroMesService cdmsService;

	// acciones web
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getId());

		model = peprService.select(model.getId(), getIdioma());
		cdmsMap = cdmsService.selectMap(model.getId());
	}
}
