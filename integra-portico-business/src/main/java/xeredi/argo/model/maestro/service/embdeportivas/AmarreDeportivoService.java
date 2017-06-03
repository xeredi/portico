package xeredi.argo.model.maestro.service.embdeportivas;

import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoServiceImpl.
 */
@Transactional
public class AmarreDeportivoService extends ParametroService {

	/** The amad DAO. */
	@Inject
	private AmarreDeportivoDAO amadDAO;

	/**
	 * Update recalcular estado.
	 */
	public void updateRecalcularEstado() {
		final ParametroCriterioVO amadCriterio = new ParametroCriterioVO();

		amadCriterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(amadCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void insertPostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) {
		final ParametroCriterioVO criterio = new ParametroCriterioVO();

		criterio.setId(prmt.getId());
		criterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(criterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void duplicatePostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		final ParametroCriterioVO criterio = new ParametroCriterioVO();

		criterio.setId(prmt.getId());
		criterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(criterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updatePostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		final ParametroCriterioVO criterio = new ParametroCriterioVO();

		criterio.setId(prmt.getId());
		criterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(criterio);
	}

}
