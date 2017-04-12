package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.ValidacionProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadProxyServiceImpl.
 */
public class EntidadProxyServiceImpl implements EntidadProxyService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EntidadProxyServiceImpl.class);

	/** The Constant LABEL_VALUE_LIST. */
	private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

	/** The Constant ENTIDAD_MAP. */
	private static final Map<Long, AbstractEntidadDetailVO> MAP = new HashMap<>();

	/** The enti service. */
	@Inject
	private EntidadService entiService;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	/** The tpsp service. */
	@Inject
	private TipoSubparametroService tpspService;

	/** The tpsr service. */
	@Inject
	private TipoServicioService tpsrService;

	/** The tpss service. */
	@Inject
	private TipoSubservicioService tpssService;

	/** The tpes service. */
	@Inject
	private TipoEstadisticaService tpesService;

	/** The engd service. */
	@Inject
	private EntidadGrupoDatoService engdService;

	/** The entd service. */
	@Inject
	private EntidadTipoDatoService entdService;

	/** The enen service. */
	@Inject
	private EntidadEntidadService enenService;

	/** The acen service. */
	@Inject
	private AccionEntidadService acenService;

	/** The aces service. */
	@Inject
	private AccionEspecialService acesService;

	/** The trmt service. */
	@Inject
	private TramiteService trmtService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractEntidadDetailVO select(Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.enti, id));
		}

		return MAP.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoParametroDetailVO selectTppr(Long id) {
		return (TipoParametroDetailVO) select(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoSubparametroDetailVO selectTpsp(Long id) {
		return (TipoSubparametroDetailVO) select(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoServicioDetailVO selectTpsr(Long id) {
		return (TipoServicioDetailVO) select(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoSubservicioDetailVO selectTpss(Long id) {
		return (TipoSubservicioDetailVO) select(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoEstadisticaDetailVO selectTpes(Long id) {
		return (TipoEstadisticaDetailVO) select(id);
	}

	/**
	 * Load.
	 */
	private synchronized void load() {
		LOG.info("Entity Load");

		for (final TipoParametroVO enti : tpprService.selectList(new TipoParametroCriterioVO())) {
			final TipoParametroDetailVO entiDetail = new TipoParametroDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);
		}

		for (final TipoSubparametroVO enti : tpspService.selectList(new TipoSubparametroCriterioVO())) {
			final TipoSubparametroDetailVO entiDetail = new TipoSubparametroDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);

			((TipoParametroDetailVO) MAP.get(enti.getTpprId())).getSubentiList().add(enti);
		}

		for (final TipoServicioVO enti : tpsrService.selectList(new TipoServicioCriterioVO())) {
			if (enti.getTpdtEstado() != null) {
				enti.setTpdtEstado(tpdtProxy.select(enti.getTpdtEstado().getId()));
			}

			final TipoServicioDetailVO entiDetail = new TipoServicioDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);
		}

		for (final TipoSubservicioVO enti : tpssService.selectList(new TipoSubservicioCriterioVO())) {
			if (enti.getTpdtEstado() != null) {
				enti.setTpdtEstado(tpdtProxy.select(enti.getTpdtEstado().getId()));
			}

			final TipoSubservicioDetailVO entiDetail = new TipoSubservicioDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);
		}

		for (final TipoEstadisticaVO enti : tpesService.selectList(new TipoEstadisticaCriterioVO())) {
			final TipoEstadisticaDetailVO entiDetail = new TipoEstadisticaDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);
		}

		LABEL_VALUE_LIST.addAll(entiService.selectLabelValues(new EntidadCriterioVO()));

		for (final EntidadGrupoDatoVO engd : engdService.selectList(new EntidadGrupoDatoCriterioVO())) {
			final AbstractEntidadDetailVO entidadDetail = MAP.get(engd.getEntiId());

			entidadDetail.getEngdList().add(engd);
			engd.setEntiId(null);
		}

		for (final EntidadTipoDatoVO entd : entdService.selectList(new EntidadTipoDatoCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(entd.getEntiId());

			if (entd.getTpdt() != null) {
				entd.setTpdt(tpdtProxy.select(entd.getTpdt().getId()));

				if (entd.getValidacion() != null) {
					entd.setVldn(ValidacionProxy.generate(entd.getTpdt().getTipoElemento(), entd.getValidacion()));
				}
			}

			if (entd.getGridable()) {
				entiDetail.getEntdGridList().add(entd.getTpdt().getId());
			}

			entiDetail.getEntdList().add(entd.getTpdt().getId());
			entiDetail.getEntdMap().put(entd.getTpdt().getId(), entd);
		}

		for (final EntidadEntidadVO enen : enenService.selectList(new EntidadEntidadCriterioVO())) {
			final AbstractEntidadDetailVO entiDetailPadre = MAP.get(enen.getEntiPadreId());
			final AbstractEntidadDetailVO entiDetailHija = MAP.get(enen.getEntiHija().getId());

			entiDetailPadre.getEntiHijasList().add(entiDetailHija.getEnti().getId());
			entiDetailHija.getEntiPadresList().add(entiDetailPadre.getEnti().getId());
		}

		for (final AccionEntidadVO acen : acenService.selectList(new AccionEntidadCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(acen.getEntiId());

			entiDetail.getAcenMap().put(acen.getAebs().getCodigo(), acen);
			acen.setEntiId(null);
		}

		for (final AccionEspecialVO aces : acesService.selectList(new AccionEspecialCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(aces.getEntiId());

			entiDetail.getAcesList().add(aces);
			aces.setEntiId(null);
		}

		for (final TramiteVO trmt : trmtService.selectList(new TramiteCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(trmt.getEntiId());

			entiDetail.getTrmtList().add(trmt);
			trmt.setEntiId(null);
		}

		LOG.info("Entity Load Success");
	}
}