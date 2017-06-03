package xeredi.argo.http.controller.action.proceso;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoDetailAction.
 */
public final class ProcesoDetailAction extends CrudDetailAction<ProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2068504814675826214L;

	/** The prar entrada list. */
	@Getter
	private List<ArchivoInfoVO> arinEntradaList;

	/** The prar salida list. */
	@Getter
	private List<ArchivoInfoVO> arinSalidaList;

	/** The prit entrada list. */
	@Getter
	private List<ProcesoItemVO> pritEntradaList;

	/** The prit salida list. */
	@Getter
	private List<ProcesoItemVO> pritSalidaList;

	/** The prpm map. */
	@Getter
	private Map<String, ProcesoParametroVO> prpmMap;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = prbtService.select(model.getId());
		arinEntradaList = prbtService.selectArinEntradaList(model.getId());
		arinSalidaList = prbtService.selectArinSalidaList(model.getId());
		pritEntradaList = prbtService.selectPritEntradaList(model.getId());
		pritSalidaList = prbtService.selectPritSalidaList(model.getId());
		prpmMap = prbtService.selectPrpmMap(model.getId());
	}
}
