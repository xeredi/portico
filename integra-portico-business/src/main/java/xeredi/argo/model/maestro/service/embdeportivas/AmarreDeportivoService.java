package xeredi.argo.model.maestro.service.embdeportivas;

import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.dao.ParametroDAO;
import xeredi.argo.model.maestro.dao.ParametroDatoDAO;
import xeredi.argo.model.maestro.dao.SubparametroDAO;
import xeredi.argo.model.maestro.dao.SubparametroDatoDAO;
import xeredi.argo.model.maestro.dao.embdeportivas.AmarreDeportivoDAO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoServiceImpl.
 */
@Transactional
public class AmarreDeportivoService extends ParametroService {

	/** The amad DAO. */
	private final AmarreDeportivoDAO amadDAO;

	/**
	 * Instantiates a new amarre deportivo service.
	 *
	 * @param prmtDAO
	 *            the prmt DAO
	 * @param prdtDAO
	 *            the prdt DAO
	 * @param sprmDAO
	 *            the sprm DAO
	 * @param spdtDAO
	 *            the spdt DAO
	 * @param i18nService
	 *            the i 18 n service
	 * @param entiProxy
	 *            the enti proxy
	 * @param amadDAO
	 *            the amad DAO
	 */
	@Inject
	public AmarreDeportivoService(final ParametroDAO prmtDAO, final ParametroDatoDAO prdtDAO,
			final SubparametroDAO sprmDAO, final SubparametroDatoDAO spdtDAO, final I18nService i18nService,
			final EntidadProxyService entiProxy, final AmarreDeportivoDAO amadDAO) {
		super(prmtDAO, prdtDAO, sprmDAO, spdtDAO, i18nService, entiProxy);

		this.amadDAO = amadDAO;
	}

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
