package xeredi.argo.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class ServicioIndexAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5523514529976849793L;

	@Getter
	private List<LabelValueVO> resultList;

	/**
	 * {@link Map} de tipos de subservicio indexados por id de tipo de servicio.
	 */
	@Getter
	private Map<Long, List<LabelValueVO>> tpssMap;

	@Inject
	private TipoSubservicioService tpssService;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() throws ApplicationException {
		final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

		tpsrCriterio.setIdioma(getIdioma());
		resultList = tpsrService.selectLabelValues(tpsrCriterio);
		tpssMap = new HashMap<>();

		final TipoSubservicioCriterioVO tpssCriterio = new TipoSubservicioCriterioVO();

		tpssCriterio.setIdioma(getIdioma());

		for (final TipoSubservicioVO vo : tpssService.selectList(tpssCriterio)) {
			if (!tpssMap.containsKey(vo.getTpsrId())) {
				tpssMap.put(vo.getTpsrId(), new ArrayList<LabelValueVO>());
			}

			tpssMap.get(vo.getTpsrId()).add(new LabelValueVO(vo.getNombre(), vo.getId()));
		}
	}
}
