package xeredi.argo.model.maestro.service.embdeportivas;

import java.util.Calendar;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.argo.model.maestro.service.ParametroServiceImpl;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoServiceImpl.
 */
@Singleton
@Transactional
public class AmarreDeportivoServiceImpl extends ParametroServiceImpl implements AmarreDeportivoService {

	/** The amad DAO. */
	@Inject
	private AmarreDeportivoDAO amadDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void updateRecalcularEstado() {
		final ParametroCriterioVO amadCriterio = new ParametroCriterioVO();

		amadCriterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(amadCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final void insertPostOperations(@NonNull final ParametroVO prmt,
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
	protected final void duplicatePostOperations(@NonNull final ParametroVO prmt,
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
	protected final void updatePostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		final ParametroCriterioVO criterio = new ParametroCriterioVO();

		criterio.setId(prmt.getId());
		criterio.setFechaVigencia(Calendar.getInstance().getTime());

		amadDAO.updateRecalcularEstado(criterio);
	}

}
